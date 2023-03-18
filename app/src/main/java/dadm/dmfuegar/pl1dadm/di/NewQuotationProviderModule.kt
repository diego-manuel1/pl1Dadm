package dadm.dmfuegar.pl1dadm.di

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NewQuotationProviderModule {
    @Singleton
    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager{
        return context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.forismatic.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

}