package com.fvanaldewereld.rpgcompanion.common.mapper

fun interface Mapper<FROM, TO> {

    fun to(from: FROM): TO

}