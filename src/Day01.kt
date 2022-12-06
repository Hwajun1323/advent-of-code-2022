fun main() {
    fun caloriesCount(input: List<String>) = input.fold(mutableListOf(0)) { elves, snack ->
        if (snack.isEmpty()) elves.add(0)
        else elves[elves.lastIndex] = elves.last() + snack.toInt()
        elves
    }

    fun caloriesTopElf(input: List<String>) = caloriesCount(input).maxOf { it }

    fun caloriesTopThreeElves(input: List<String>) = caloriesCount(input).sorted().takeLast(3).sum()

    fun part1(input: List<String>): Int {
        return caloriesTopElf(input)
    }

    fun part2(input: List<String>): Int {
        return caloriesTopThreeElves(input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 14)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}