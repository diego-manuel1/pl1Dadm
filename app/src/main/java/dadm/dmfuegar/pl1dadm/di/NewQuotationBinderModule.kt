package dadm.dmfuegar.pl1dadm.di

import dadm.dmfuegar.pl1dadm.data.newquotation.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(newQuotationRepository : NewQuotationRepositoryImpl) : NewQuotationRepository
    @Binds
    abstract fun bindNewQuotationDataSource(newQuotationDataSource: NewQuotationDataSourceImpl) : NewQuotationDataSource
    @Binds
    abstract fun provideNewQuotationManager(newQuotationManagerImpl: NewQuotationManagerImpl): NewQuotationManager
}