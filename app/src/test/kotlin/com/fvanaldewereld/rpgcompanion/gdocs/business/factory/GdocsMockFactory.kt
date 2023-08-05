package com.fvanaldewereld.rpgcompanion.gdocs.business.factory

import com.fvanaldewereld.rpgcompanion.gdocs.business.data.model.GdocsModel
import com.fvanaldewereld.rpgcompanion.gdocs.business.data.source.to.GdocsTO

object GdocsMockFactory {

    val gdocsUrl =
        "https://docs.google.com/document/d/1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os/edit#heading=h.6srcydx8zv6e"

    val gdocsDocumentId = "1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os"

    val gdocsTO = GdocsTO(title = "Le prix du sang")

    val gdocsModel = GdocsModel(title = "Le prix du sang")

}