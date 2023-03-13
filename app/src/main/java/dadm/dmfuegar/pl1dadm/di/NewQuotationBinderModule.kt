package dadm.dmfuegar.pl1dadm.di

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
}