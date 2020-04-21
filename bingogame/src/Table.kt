class Table(numbers: MutableList<Int>, private val shuffle: Boolean = false) {

    private val table = mutableListOf<MutableList<Cell>>()

    init {
        if (shuffle) numbers.shuffle()
        var index = 0
        for (i in 0 until 5) {
            table.add(mutableListOf())
            for (j in 0 until 5) {
                table[i].add(Cell(numbers[index++]))
            }
        }
    }

    fun strike(numberToStrike: Int) {
        for (row in table) {
            val filteredElement = row.filter { cell -> cell.number == numberToStrike }
            val isFound = filteredElement.count() == 1
            if (isFound) {
                filteredElement.first().strike()
                break
            }
        }
    }

    fun validate(): Boolean {
        var count = 0
        for (row in 0 until 5) {
            var rowCount = 0
            var columnCount = 0
            for (column in 0 until 5) {
                if (table[row][column].isStriked()) {
                    rowCount++
                }
                if (table[column][row].isStriked()) {
                    columnCount++
                }
            }
            if (isFullyStriked(rowCount)) {
                count += 1
            }
            if (isFullyStriked(columnCount)) {
                count += 1
            }
        }
        return count >= 5
    }

    private fun isFullyStriked(rowCount: Int) = rowCount == 5
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