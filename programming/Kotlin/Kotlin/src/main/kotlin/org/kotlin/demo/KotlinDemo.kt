package org.kotlin.demo

class KotlinDemo {
    fun say(): String {
        print("Exec")
        return "ELO";
    }

    fun add(a: Int, b: Int): Int {
        return a + b;
    }

    fun strTempl(a: Int): String {
        return "Given ${a}"
    }

    fun immutability(): Int {
        //val x=5
        var x = 5
        x = 3
        val c: Int
        c = x
        return c
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b;


    fun loop1(): Int {
        val items = listOf(1, 2, 3);
        for (i in items) {
            print(i)
        }
        return items.sum()
    }


    fun desc(o: Any): String =
        when (o) {
            1 -> "one"
            else -> "Unknown"
        }

    //RANGES
    fun inRange(a:Int) = a in 1..10

    fun filter(a: List<String>):Int {
        return a
            .filter { it.startsWith("x") }
            .map { it.uppercase() }
            .count()
    }

    fun optional(str:String):Int? = str.toIntOrNull();
}