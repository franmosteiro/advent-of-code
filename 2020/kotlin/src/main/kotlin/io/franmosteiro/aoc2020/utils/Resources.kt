package io.franmosteiro.aoc2020.utils

import java.io.File
import java.net.URI

internal object Resources {

    fun resourceAsText(fileName: String) : String =
            File(fileName.toURI()).readText()

    fun resourceAsList(fileName: String): List<String> =
            File(fileName.toURI()).readLines()

    private fun String.toURI(): URI =
            Resources.javaClass.classLoader.getResource(this)?.toURI() ?: throw IllegalArgumentException("Cannot find Resource: $this")

}