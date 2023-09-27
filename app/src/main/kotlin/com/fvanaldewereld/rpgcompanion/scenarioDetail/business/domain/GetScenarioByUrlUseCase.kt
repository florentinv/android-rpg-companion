package com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain

import com.fvanaldewereld.rpgcompanion.common.extensions.extractDocumentId
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.data.repository.GoogleDocsRepository
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.mapper.ScenarioModelMapper
import com.fvanaldewereld.rpgcompanion.scenarioDetail.business.domain.model.ScenarioModel
import kotlinx.coroutines.delay
import org.koin.core.context.GlobalContext
import java.net.URL

class GetScenarioByUrlUseCase {
    private val googleDocsRepository: GoogleDocsRepository by GlobalContext.get().inject()
    private val scenarioModelMapper: ScenarioModelMapper by GlobalContext.get().inject()

    suspend operator fun invoke(documentUrl: URL): ScenarioModel {
        delay(1000)
        val document = googleDocsRepository.getGoogleDocsById(documentUrl.extractDocumentId())
        return scenarioModelMapper.to(from = document)
    }
}