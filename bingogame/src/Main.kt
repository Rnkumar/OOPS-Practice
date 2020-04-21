
fun main(){

    val numberOfPlayers : Int = readLine()!!.toInt()
    val validTableNumbers : IntArray = IntArray(5)

    for (i in 1 until 5){
        val split = readLine()!!.split(" ")
    }

    val game = Game(numberOfPlayers, validTableNumbers)

    while(game.proceed()){
        val (playerNumber, playerSelection) = readLine()!!.split(" ")
        game.play(playerNumber.toInt(), playerSelection.toInt())
    }

}