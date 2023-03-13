package dadm.dmfuegar.pl1dadm.di

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(Singleton::class)
@Module
class NewQuotationProviderModule {
    @Singleton
    @Provides
    @ApplicationContext
    fun provideConnectivityManager(context: Context): ConnectivityManager{
        return context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}