import kotlin.math.min

enum class RPS(val value: Int){
    ROCK(1),
    PAPER(2),
    SCISSORS(3),
}

object WinScore{
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

    fun Char.toEndResult() =
        when(this){
            'X' -> WinScore.LOOSE
            'Y' -> WinScore.DRAW
            else -> WinScore.WIN
        }

    fun toFigureShape(input: String) : Pair<RPS, Int> {
        return input[0].toGameChoice() to input[2].toEndResult()
    }

    fun Int.decideChoice(opponent: RPS) : Int{
        return when (this) {
            // loose
            0 -> when (opponent)
            {   RPS.ROCK -> 3
                RPS.PAPER -> 1
                else -> 2
            }
            // draw
            3 -> when (opponent)
            {   RPS.ROCK -> 1
                RPS.PAPER -> 2
                else -> 3
            }
            // win
            else -> when (opponent)
            {
                RPS.ROCK -> 2
                RPS.PAPER -> 3
                else -> 1
            }
        }
    }

    // win case of RPS
    fun RPS.win(opponent: RPS): Boolean =
        when {
            this == RPS.ROCK && opponent == RPS.SCISSORS || this == RPS.PAPER && opponent == RPS.ROCK || this == RPS.SCISSORS && opponent == RPS.PAPER -> true
            else -> false
        }

    fun RPS.getScore(opponent: RPS) =
        when {
            this.win(opponent) -> WinScore.WIN
            this == opponent -> WinScore.DRAW
            else -> WinScore.LOOSE
        }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            if (it.isBlank()) 0
            else {
                val (opponent, mine) = toGameChoice(it)
                mine.getScore(opponent) + mine.value
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            if(it.isBlank()) 0
            else {
                val (opponent, mine) = toFigureShape(it)
                mine.decideChoice(opponent) + mine
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
