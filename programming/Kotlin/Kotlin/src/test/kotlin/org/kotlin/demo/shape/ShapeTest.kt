package org.kotlin.demo.shape

import kotlin.test.Test
import kotlin.test.assertEquals


class ShapeTest {

    @Test
    fun aaa() {
        val shape: Shape
        shape = Rec()
        assertEquals("Rec", shape.name());
    }
}