package com.fvanaldewereld.rpgcompanion.home.feature.di

import android.content.Intent
import com.fvanaldewereld.rpgcompanion.home.feature.ui.activity.HomeActivity
import com.fvanaldewereld.rpgcompanion.home.feature.ui.activity.HomeActivity.Companion.HOME_INTENT
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val HOME_FEATURE_MODULE = module {
    // Mappers

    // ViewModels

    // Intent
    factory<Intent>(named(HOME_INTENT)) { HomeActivity.intent(androidContext()) }
}
