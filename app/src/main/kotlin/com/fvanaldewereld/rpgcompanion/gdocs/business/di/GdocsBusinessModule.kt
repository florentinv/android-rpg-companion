package com.fvanaldewereld.rpgcompanion.gdocs.business.di

import com.fvanaldewereld.rpgcompanion.common.network.RetrofitClient
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.GdocsRepository
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.GdocsRepositoryImpl
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.mapper.GdocsMapper
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.mapper.GdocsMapperImpl
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.GdocsDataSource
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.GdocsDataSourceImpl
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.service.GdocsService
import com.fvanaldewereld.rpgcompanion.gdocs.business.domain.GetGdocsByUrlUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val GDOCS_BUSINESS_MODULE = module {
    // Mappers
    single<GdocsMapper> { GdocsMapperImpl() }

    // Source
    single<GdocsService> { RetrofitClient.createGoogleDocsService(androidContext()) }
    factory<GdocsDataSource> { GdocsDataSourceImpl() }
    factory<GdocsRepository> { GdocsRepositoryImpl() }

    // Usecase
    factory { GetGdocsByUrlUseCase() }
}
