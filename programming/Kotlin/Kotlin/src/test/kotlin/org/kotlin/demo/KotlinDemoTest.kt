package org.kotlin.demo

import org.junit.jupiter.api.Assertions.assertNull
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class KotlinDemoTest {
    @Test
    fun aaa() {
        // TODO: ==, != - equality operators  (equals)
        // TODO: ===, !== - referential equality operators.
        


        val kotlinDemo = KotlinDemo()
        assertEquals("ELO", kotlinDemo.say())
        assertEquals(3, kotlinDemo.add(1,2))
        assertEquals("Given 2", kotlinDemo.strTempl(2))
        assertEquals(3, kotlinDemo.immutability())
        assertEquals(2, kotlinDemo.maxOf(1,2))
        assertEquals(6, kotlinDemo.loop1())
        assertEquals("one", kotlinDemo.desc(1))
        assertEquals(1, kotlinDemo.filter(listOf("x", "ax", "abc")))

        assertNull(kotlinDemo.optional("d"))
        assertNotNull(kotlinDemo.optional("1"))
    }
}