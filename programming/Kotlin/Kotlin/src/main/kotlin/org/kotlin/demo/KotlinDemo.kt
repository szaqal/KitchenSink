package org.kotlin.demo

class KotlinDemo {
    fun say(): String {
        print("Exec")
        return "ELO";
    }

    fun add(a: Int, b:Int): Int {
        return a+b;
    }

    fun strTempl(a: Int): String {
        return "Given ${a}"
    }

    fun immutability(): Int {
        //val x=5
        var x = 5
        x=3
        val c:Int
        c = x
        return c
    }

 }