package dadm.dmfuegar.pl1dadm.di

import dadm.dmfuegar.pl1dadm.data.newquotation.NewQuotationDataSource
import dadm.dmfuegar.pl1dadm.data.newquotation.NewQuotationDataSourceImpl
import dadm.dmfuegar.pl1dadm.data.newquotation.NewQuotationRepository
import dadm.dmfuegar.pl1dadm.data.newquotation.NewQuotationRepositoryImpl
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

}