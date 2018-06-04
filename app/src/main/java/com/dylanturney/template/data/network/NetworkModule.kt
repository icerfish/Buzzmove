package com.dylanturney.template.data.network

import com.dylanturney.buzzmove.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named


@Module
object NetworkModule {

    /**
     * Provides the Foursquare service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Foursquare service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    /**
     * Provides the Interceptor object.
     * @return the Interceptor object
     */
    @Provides
    @Reusable
    @JvmStatic
    @Named("authInterceptor")
    internal fun provideAuthInterceptor(): Interceptor {
        return Interceptor {
            it.proceed(it.request())
        }
    }

    /**
     * Provides the Interceptor object.
     * @return the Interceptor object
     */
    @Provides
    @Reusable
    @JvmStatic
    @Named("loggingInterceptor")
    internal fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        return interceptor
    }

    /**
     * Provides the OkHttpClient object.
     * @return the OkHttpClient object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttpClient(@Named("authInterceptor") authInterceptor: Interceptor,
                                     @Named("loggingInterceptor") loggingInterceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .connectTimeout(21, TimeUnit.SECONDS)
                .readTimeout(21, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                .addInterceptor(loggingInterceptor)
                .followRedirects(false)
                .followSslRedirects(false)

        return builder.build()
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

}