package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.di

import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.repository.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.repository.GoogleDocsRepositoryImpl
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.source.googleDocs.GoogleDocsDataSource
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.source.googleDocs.GoogleDocsDataSourceImpl
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.source.googleDocs.service.GoogleDocsService
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.GetScenarioByUrlUseCase
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.mapper.ScenarioModelMapper
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.mapper.ScenarioModelMapperImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val SCENARIO_DETAIL_BUSINESS_MODULE = module {
    // Mappers
    single<ScenarioModelMapper> { ScenarioModelMapperImpl() }

    // Source
    single<GoogleDocsService> { GoogleDocsService(androidContext()) }
    factory<GoogleDocsDataSource> { GoogleDocsDataSourceImpl() }
    factory<GoogleDocsRepository> { GoogleDocsRepositoryImpl() }

    // Usecase
    factory { GetScenarioByUrlUseCase() }
}
