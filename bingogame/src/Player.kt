class Player(private var number: Int, private val table: Table) {

    fun strike(playerSelection: Int): Boolean {
        return table.strike(playerSelection)
    }
}