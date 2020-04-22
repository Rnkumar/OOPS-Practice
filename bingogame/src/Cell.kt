class Cell(val number: Int) {

    private var striked = false

    override fun toString(): String {
        return "$number $striked"
    }

    fun strike() {
        striked = true
    }
}