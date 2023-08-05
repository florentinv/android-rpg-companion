package com.fvanaldewereld.rpgcompanion.common.mapper

interface Mapper<FROM, TO> {

    fun to(from: FROM): TO

    fun from(to: TO): FROM {
        throw UnsupportedOperationException()
    }
}