import kotlin.math.sqrt

class Table(numbers: MutableList<Int>, shuffle: Boolean = false) {

    private val dimension = sqrt(numbers.size.toDouble()).toInt()
    private val tableData = mutableListOf<MutableList<Cell>>()
    private val rowStrikeCount = mutableListOf<Int>()
    private val colStrikeCount = mutableListOf<Int>()

    init {
        if (shuffle) numbers.shuffle()
        initializeTableAndStrikeLists(numbers)
    }

    fun strike(numberToStrike: Int) {
        for ((index, row) in tableData.withIndex()) {
            val filteredList = row.filter { cell -> cell.number == numberToStrike }
            if (filteredList.size == 1) {
                filteredList.first().strike()
                rowStrikeCount[index] += 1
                colStrikeCount[index] += 1
                break
            }
        }
    }

    fun validate(): Boolean {
        val rows = getStrikedCount(rowStrikeCount)
        val columns = getStrikedCount(colStrikeCount)
        val total = rows + columns
        return total >= 5
    }

    private fun initializeTableAndStrikeLists(numbers: MutableList<Int>) {
        var numbersIndex = 0
        for (row in 0 until dimension) {
            tableData.add(mutableListOf())
            for (column in 0 until dimension) {
                tableData[row].add(Cell(numbers[numbersIndex++]))
            }
        }
        for(index in 0 until dimension){
            rowStrikeCount.add(0)
            colStrikeCount.add(0)
        }
    }

    private fun getStrikedCount(strikeCellCount: MutableList<Int>): Int =
        strikeCellCount.count { number -> number == dimension }
}

fun main() {
    val table = Table(
        mutableListOf(
            1, 2, 3, 4, 5,
            6, 7, 8, 9, 10,
            11, 12, 13, 14, 15,
            16, 17, 18, 19, 20,
            21, 22, 23, 24, 25
        ),
        shuffle = false
    )
    for (i in 1 until 26)
        table.strike(i)
    print(table.validate())
}
