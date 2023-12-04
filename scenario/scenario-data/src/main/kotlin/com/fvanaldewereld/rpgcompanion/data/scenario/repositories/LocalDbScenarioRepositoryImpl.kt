package com.fvanaldewereld.rpgcompanion.data.scenario.repositories

import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.repositories.DbScenarioRepository
import com.fvanaldewereld.rpgcompanion.data.scenario.mappers.dbObjectMappers.ScenarioMapper
import com.fvanaldewereld.rpgcompanion.data.scenario.sources.localDatabase.dao.ScenarioDao
import org.koin.core.context.GlobalContext

class LocalDbScenarioRepositoryImpl : DbScenarioRepository {

    private val scenarioDao: ScenarioDao by GlobalContext.get().inject()
    private val scenarioMapperImpl: ScenarioMapper by GlobalContext.get().inject()

    override suspend fun addScenario(scenarioModel: ScenarioModel): Long = scenarioDao.insertScenario(scenarioMapperImpl.from(scenarioModel))

    override suspend fun getAllScenarios(): List<ScenarioModel> = scenarioDao.getAllScenarios().map { scenarioMapperImpl.to(it) }

    override suspend fun getScenarioByDocumentName(documentName: String): ScenarioModel = scenarioMapperImpl.to(scenarioDao.getScenarioByDocumentName(documentName))

    override suspend fun getScenarioById(id: Long): ScenarioModel = scenarioMapperImpl.to(scenarioDao.getScenarioById(id))

    override suspend fun deleteById(id: Long): Long = scenarioDao.deleteScenario(scenarioDao.getScenarioById(id))
}