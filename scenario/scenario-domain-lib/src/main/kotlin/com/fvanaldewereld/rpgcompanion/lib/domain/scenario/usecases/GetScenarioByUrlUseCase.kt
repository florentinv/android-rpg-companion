package com.fvanaldewereld.rpgcompanion.lib.domain.scenario.usecases

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.repositories.GoogleDocsRepository
import org.koin.core.context.GlobalContext
import java.net.URL

class GetScenarioByUrlUseCase {
    private val googleDocsRepository: GoogleDocsRepository by GlobalContext.get().inject()

    suspend operator fun invoke(documentUrl: URL): ScenarioModel = googleDocsRepository.getScenarioByGdocsUrl(documentUrl)

}
