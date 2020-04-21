fun main() {

    val numberOfPlayers: Int = readLine()!!.toInt()
    val validTableNumbers = mutableListOf<Int>()

    for (i in 1 until 5) {
        val tableRow = readLine()!!.split(" ").map(String::toInt)
        validTableNumbers.addAll(tableRow)
    }

    val game = Game(numberOfPlayers, validTableNumbers)

    while (game.proceed()) {
        val (playerNumber, playerSelection) = readLine()!!.split(" ").map(String::toInt)
        game.play(playerNumber, playerSelection)
    }

    print("The winner is ${game.getWinner()}")

}