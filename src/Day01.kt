fun main() {
    fun part1(input: List<String>): Int {
        var answer = 0
        var max = 0
        var sum = 0

        for (i in input) {
            if (i.isEmpty()) {
                if(max < sum){
                    max = sum
                }
                sum = 0
            } else {
                sum+=i.toInt()
            }
            answer = max
        }
        return answer
    }


    fun part2(input: List<String>): Int {
        var answer = 0
        var max1 = 0
        var max2 = 0
        var max3 = 0
        var sum = 0

        for (i in input) {
            if (i.isEmpty()) {
                if(max < sum){
                    max = sum
                }
                sum = 0
            } else {
                sum+=i.toInt()
            }
            answer = max
        }
        return answer    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 14)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}