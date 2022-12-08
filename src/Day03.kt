fun main() {

    val priorities = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun findSharedItem(items: String): String {
        val (firstCompartment, secondCompartment) = items.chunked(items.length / 2)
        return firstCompartment.filter { c -> secondCompartment.contains(c) }.toSet().joinToString()
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            priorities.indexOf(findSharedItem(it))
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")

    val input = readInput("Day03")
    println(part1(input))
//    println(part2(input))
}
