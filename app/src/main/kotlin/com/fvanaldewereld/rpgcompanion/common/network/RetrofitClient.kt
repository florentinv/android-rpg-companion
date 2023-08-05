package com.fvanaldewereld.rpgcompanion.common.network

import android.content.Context
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.service.GdocsService
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.docs.v1.DocsScopes
import com.google.auth.oauth2.GoogleCredentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream

object RetrofitClient {
    private const val BASE_URL = "https://docs.googleapis.com/"

    private var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun createGoogleDocsService(context: Context): GdocsService {
        NetHttpTransport()
        JacksonFactory.getDefaultInstance()
        val inputStream = context.assets.open("service-account-key.json")
        val googleCredential = createGoogleCredential(inputStream)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val token = googleCredential.refreshAccessToken().tokenValue
                val request = chain.request()
                    .newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(GdocsService::class.java)
    }

    private fun createGoogleCredential(inputStream: InputStream): GoogleCredentials {

        return GoogleCredentials.fromStream(inputStream)
            .createScoped(listOf(DocsScopes.DOCUMENTS_READONLY))
    }
}