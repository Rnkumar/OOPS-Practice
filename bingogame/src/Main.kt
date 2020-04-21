
fun main(){

    val numberOfPlayers : Int = readLine()!!.toInt()
    val validTableNumbers = arrayOf<IntArray>()


    for (i in 1 until 5){
        val tableRow = readLine()!!.split(" ").map(String::toInt)
        validTableNumbers[i] = tableRow.toIntArray()
    }

    val game = Game(numberOfPlayers, validTableNumbers)

    while(game.proceed()){
        val (playerNumber, playerSelection) = readLine()!!.split(" ").map(String::toInt)
        game.play(playerNumber, playerSelection)
    }

}