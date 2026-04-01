package org.kotlin.demo

import kotlin.test.Asserter
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinDemoTest {
    @Test
    fun aaa() {
        assertEquals("ELO", KotlinDemo().say()) ;
    }
}