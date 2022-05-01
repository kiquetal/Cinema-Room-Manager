package cinema

const val MINIMUN_SEAT = 60
const val LOW_PRICE = 8
const val NORMAL_PRICE = 10
fun main() {

    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readLine()!!.toInt()
    var choice = -1
    val purchasedSeats = mutableMapOf<Pair<Int,Int>,Int>()
    val cinema: Array<Array<String>> = Array(rows + 1) { row ->
        Array(seatsPerRow + 1) {
            if (it == 0 && row == 0)
                "  "
            else if (row == 0)
                "${it} "
            else
                if (it == 0)
                    "$row "
                else
                    "S "
        }
    }

    while (choice != 0) {

        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        choice = readLine()!!.toInt()

        when (choice) {
            1 -> showSeats(rows = rows, seatsPerRow = seatsPerRow, cinema = cinema)
            2 -> buyTicket(rows, seatsPerRow, cinema,purchasedSeats)
            3 -> statistics(rows, seatsPerRow,purchasedSeats)
        }
    }


}

fun statistics(rows: Int, seatsPerRow: Int, purchasedSeat: MutableMap<Pair<Int, Int>, Int>) {

    println("Number of purchased tickets: ${purchasedSeat.size}")
    var total = 0
    purchasedSeat.entries.forEach() {
        total += it.value.toInt()
    }
    val percentage = purchasedSeat.size / (rows * seatsPerRow.toDouble()) * 100
    val formatPercentage = "%.2f".format(percentage)
    println("Percentage: $formatPercentage%")
    println("Current income: $${total}")
    val totalIncome = calculateTotalIncome(rows,seatsPerRow)
    println("Total income: $${totalIncome}")

}


fun buyTicket(seatsPerRow: Int, rows: Int, cinema: Array<Array<String>>, purchasedSeat: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()) {


    var isValid = false

    do {
        println("Enter a row number: ")
        val selectedRow = readLine()!!.toInt()
        println("Enter a seat number in that row:")
        val selectedSeat = readLine()!!.toInt()
        var price = if (seatsPerRow * rows <= MINIMUN_SEAT)
            NORMAL_PRICE
        else
            LOW_PRICE

        if (LOW_PRICE == price) {
            price = if (selectedRow in 1..rows / 2)
                NORMAL_PRICE
            else
                LOW_PRICE
        }

        if (selectedRow > rows || selectedSeat > seatsPerRow) {
            println("Wrong input!")

        } else {
            if (cinema[selectedRow][selectedSeat] == "S ") {
                cinema[selectedRow][selectedSeat] = "B "
                isValid = true
                println("Ticket price: $${price}")
                purchasedSeat[Pair(selectedRow, selectedSeat)] = price
            } else {
                println("That ticket has already been purchased!")

            }
        }

    } while (!isValid)
}

fun calculateTotalIncome(rows:Int,columns:Int):Int {

    return if ( rows * columns < MINIMUN_SEAT) {
        NORMAL_PRICE * rows * columns
    } else {

        val midRows = rows/2
        var price = midRows * columns * NORMAL_PRICE
        price += (rows - midRows) * columns * LOW_PRICE
        price
    }

}

fun showSeats(rows: Int, seatsPerRow: Int, cinema: Array<Array<String>>) {
    println("Cinema:")

    for (i in 0..rows) {
        for (j in 0..seatsPerRow) {
            print(cinema[i][j])
        }
        println()
    }

    println()
}
