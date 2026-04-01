package org.kotlin.demo.shape

//open makes it non final
open class Shape {
    open fun name(): String {
        return "Shape";
    }
}

class Rec(): Shape() {

    override fun name(): String {
        return "Rec"
    }

}

