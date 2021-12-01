package io.franmosteiro.aoc2020.utils

import io.franmosteiro.aoc2020.utils.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ResourcesTest {

    @Test
    fun `reads lines`() {
        assertThat(resourceAsList("testFile01.in"))
                .hasSize(6)
                .containsExactly("1721", "979", "366", "299", "675", "1456")
    }

    @Test
    fun `throws exception when file does not exist`() {
        assertThatThrownBy {
            resourceAsList("testFileDoesNotExist.in")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}