fun main() {

    fun convertToSection(Elf: String): IntRange {
        val (start, end) = Elf.split("-")
        return start.toInt()..end.toInt()
    }

    fun checkContain(firstSection: IntRange, secondSection: IntRange): Boolean{
        return (firstSection.first >= secondSection.first && firstSection.last <= secondSection.last)
    }

    fun part1(input: List<String>): Int {
        return input.count {
            val (firstElf, secondElf) = it.split(",")
            checkContain(convertToSection(firstElf),convertToSection(secondElf))
                    || checkContain(convertToSection(secondElf), convertToSection(firstElf))
        }
    }

//    fun part2(input: List<String>): Int {
//        return input.count{
//        }
//    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")

    val input = readInput("Day04")
    println(part1(input))
//    println(part2(input))
}
