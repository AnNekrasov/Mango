package android.example.tng.di

import android.content.Context
import android.example.data.UserService
import android.example.data.UserRepositoryImpl
import android.example.domain.repository.IUserRepository
import android.example.tng.utils.AuthInterceptor
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(appContext))
        .addInterceptor(AuthInterceptor(appContext))
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : UserService = retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideUserRepository(userService: UserService): IUserRepository {
        return UserRepositoryImpl(userService)
    }

    @Provides
    fun providesBaseUrl() : String = "https://plannerok.ru/"
}