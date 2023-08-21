package com.rodriguesporan.uilists.di.factories

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rodriguesporan.uilists.data.GatewayApiUri.buildGatewayApiUri
import com.rodriguesporan.uilists.di.session.SessionProvider
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal abstract class ApiServiceFactory<T>(
    private val service: Class<T>,
    private val session: SessionProvider
) {

    fun create(): T {
        return Retrofit.Builder()
            .baseUrl(buildGatewayApiUri().toString())
            .addConverterFactory(createConverterFactory())
            .client(buildOkHttpClient())
            .build()
            .create(service)
    }

    private fun createConverterFactory(): Converter.Factory {
        val gson: Gson = GsonBuilder().setLenient().create()
        return GsonConverterFactory.create(gson)
    }

    private fun buildOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val headerAuthorizationValue = session.getHeaderAuthorization()
                val request =
                    if (headerAuthorizationValue != null) {
                        val requestBuilder = chain.request().newBuilder()
                        requestBuilder.header("Authorization", headerAuthorizationValue)
                        requestBuilder.build()
                    } else {
                        chain.request()
                    }
                val logMsgReq =
                    with(request) { "Sending request $url on ${chain.connection()}\n${headers}" }
                Log.i(TAG_REQUEST, logMsgReq)
                return@addInterceptor chain.proceed(request).also { response ->
                    val logMsgRes =
                        with(response) { "Received response for ${request.url}\n${headers}\n${this}" }
                    Log.i(TAG_RESPONSE, logMsgRes)
                }
            }
        return okHttpClient.build()
    }

    companion object {
        private const val TAG_REQUEST = "TAG_REQUEST"
        private const val TAG_RESPONSE = "TAG_RESPONSE"
    }
}
