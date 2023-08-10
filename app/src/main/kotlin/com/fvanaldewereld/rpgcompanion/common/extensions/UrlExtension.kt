package com.fvanaldewereld.rpgcompanion.common.extensions

import java.net.URL

fun URL.extractDocumentId(): String {
    val regex = "/d/(.*?)/edit".toRegex()
    val matchResult = regex.find(this.path)
    return matchResult?.groups?.get(1)?.value
        ?: throw NoSuchElementException("No DocumentID in this URL.")
}
