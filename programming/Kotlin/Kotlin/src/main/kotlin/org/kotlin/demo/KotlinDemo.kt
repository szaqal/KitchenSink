package org.kotlin.demo

import java.io.File
import java.math.BigDecimal

class KotlinDemo {
    fun say(): String {
        print("Exec")
        return "ELO";
    }

    fun add(a: Int, b: Int): Int {
        return a + b;
    }

    // Function as expression
    fun sum(a: Int, b: Int) = a + b
    fun maxOf(a: Int, b: Int) = if (a > b) a else b;


    // String template
    fun strTempl(a: Int): String {
        return "Given ${a}"
    }

    // Immutable vars
    fun immutability(): Int {
        //val x=5
        var x = 5
        x = 3
        val c: Int
        c = x
        return c
    }


    fun loop1(): Int {
        val items = listOf(1, 2, 3);
        for (i in items) {
            print(i)
        }
        return items.sum()
    }


    // WHEN expression
    fun desc(o: Any): String =
        when (o) {
            1 -> "one"
            else -> "Unknown"
        }


    fun aaa() = {
        val coll = setOf("sss", "aaa")

        when {
            "sss" in coll -> println("Hello")
            "zzz" in coll -> println("ddd")
        }
    }

    //RANGES (checks if in range)
    fun inRange(a: Int): Boolean = a in 1..10

    fun filter(a: List<String>): Int {
        return a
            .filter { it.startsWith("x") }
            .map { it.uppercase() }
            .count()
    }

    //
    fun optional(str: String): Int? = str.toIntOrNull();

    fun equality(): Boolean = 2 == 2 && 2 === 2;

    //Read only list
    val list = listOf("a", "b", "c")
    //Read only map
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)

    // POJO DTO
    data class Customer(val name: String, val email: String)

    // Default values
    fun foo(a: Int = 0, b: String = "") { }

    // Filtering
    fun filetring() = {
        val positives = listOf(1,2,3).filter { x -> x > 0 }
        if (1 in positives) {  }
    }

    //Singleton
    object Resource {
        val name = "Name"
    }

    //Abstract class
    abstract class MyAbstractClass {
        abstract fun doSomething()
        abstract fun sleep()
    }

    fun nullcheck() {
        val files = File("Test").listFiles() //if != null
        println(files?.size)

        println(files?.size ?: "empty") // if files is null, this prints "empty"

        val value=null;
        value?.let {
            // exec if not null
        }
    }
    fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
}
