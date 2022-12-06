enum class RPS(val value: Int){
    ROCK(1),
    PAPER(2),
    SCISSORS(3),
}

object Score{
    const val WIN = 6
    const val LOOSE = 0
    const val DRAW = 3
}

fun main() {

    fun Char.toGameChoice():RPS =
        when(this) {
            'A', 'X' -> RPS.ROCK
            'B', 'Y' -> RPS.PAPER
            'C', 'Z' -> RPS.SCISSORS
            else -> throw IllegalArgumentException("Not available choice")
        }

    fun toGameChoice(input: String) : Pair<RPS, RPS> {
        return input[0].toGameChoice() to input[2].toGameChoice()
    }

    fun RPS.win(opponent: RPS): Boolean =
        when {
            this == RPS.ROCK && opponent == RPS.SCISSORS || this == RPS.PAPER && opponent == RPS.ROCK || this == RPS.SCISSORS && opponent == RPS.PAPER -> true
            else -> false
        }

    fun RPS.scoreAgainst(opponent: RPS) =
        when {
            this.win(opponent) -> Score.WIN
            this == opponent -> Score.DRAW
            else -> Score.LOOSE
        }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            if (it.isBlank()) 0
            else {
                val (opponent, mine) = toGameChoice(it)
                mine.scoreAgainst(opponent) + mine.value
            }
        }
    }

//    fun part2(input: List<String>): Int {
//        return input.size
//    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
//    println(part2(input))
}
