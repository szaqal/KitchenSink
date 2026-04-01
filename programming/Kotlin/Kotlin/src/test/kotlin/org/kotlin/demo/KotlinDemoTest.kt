package org.kotlin.demo

import kotlin.test.Asserter
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinDemoTest {
    @Test
    fun aaa() {
        val kotlinDemo = KotlinDemo()
        assertEquals("ELO", kotlinDemo.say())
        assertEquals(3, kotlinDemo.add(1,2))
        assertEquals("Given 2", kotlinDemo.strTempl(2))
        assertEquals(3, kotlinDemo.immutability())
    }
}