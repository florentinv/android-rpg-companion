package com.fvanaldewereld.rpgcompanion.scenario.business.domain

import com.fvanaldewereld.rpgcompanion.common.extensions.extractDocumentId
import com.fvanaldewereld.rpgcompanion.scenario.business.data.repository.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper.ScenarioModelMapper
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import org.koin.core.context.GlobalContext
import java.net.URL

class GetScenarioByUrlUseCase {
    private val googleDocsRepository: GoogleDocsRepository by GlobalContext.get().inject()
    private val scenarioModelMapper: ScenarioModelMapper by GlobalContext.get().inject()

    suspend operator fun invoke(documentUrl: URL): ScenarioModel {
        Thread.sleep(1000)
        val document = googleDocsRepository.getGoogleDocsById(documentUrl.extractDocumentId())
        return scenarioModelMapper.to(from = document)
    }
}