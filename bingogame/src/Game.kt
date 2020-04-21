class Game(numberOfPlayers: Int, validTableNumbers: MutableList<Int>) {

    private val players = mutableMapOf<Int, Player>()
    private var isDone = false
    private var winner: Player? = null
    private var lastPlayed: Int = 0

    init {
        for (i in 1 until numberOfPlayers) {
            val table = Table(validTableNumbers, shuffle = true)
            players[i] = Player(i, table)
        }
    }

    fun proceed(): Boolean {
        return !isDone
    }

    fun getWinner(): Int {
        return winner!!.number
    }

    fun play(playerNumber: Int, playerSelection: Int) {
        if (playerNumber != lastPlayed + 1) {
            print("Player ${lastPlayed+1} has not played yet")
            return;
        }
        lastPlayed = playerNumber
        for (playerEntry in players.entries) {
            val player = playerEntry.value
            player.strike(playerSelection)
            if (player.didWin()) {
                winner = player
                isDone = true
            }
        }
    }

}