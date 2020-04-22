class Game(numberOfPlayers: Int, validTableNumbers: MutableList<Int>) {

    private val players = mutableMapOf<Int, Player>()
    private var isOver = false
    private var winner: Player? = null
    private var recentPlayerNumber: Int = 0

    init {
        for (i in 1 until numberOfPlayers) {
            val table = Table(validTableNumbers, shuffle = true)
            players[i] = Player(i, table)
        }
    }

    fun proceed(): Boolean {
        return !isOver
    }

    fun getWinner(): Int {
        return winner!!.number
    }

    fun play(playerNumber: Int, playerSelection: Int) {
        if (playerNumber != recentPlayerNumber + 1) {
            print("Player ${recentPlayerNumber+1} has not played yet")
            return;
        }
        recentPlayerNumber = playerNumber
        for (playerEntry in players.entries) {
            val player = playerEntry.value
            player.strike(playerSelection)
            if (player.didWin()) {
                winner = player
                isOver = true
            }
        }
    }

}