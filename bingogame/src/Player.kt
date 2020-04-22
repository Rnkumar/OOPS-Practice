class Player(var number: Int, private val table: Table) {
    fun strike(playerSelection: Int) {
        table.strike(playerSelection)
    }

    fun didWin(): Boolean {
        return table.validate()
    }
}