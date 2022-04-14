package cinema

const val MINIMUN_SEAT=60
const val LOW_PRICE = 8
const val NORMAL_PRICE = 10
fun main()
{

    print("Enter the number of rows: ")
    val rows = readLine()!!.toInt()
    print("Enter the number of seats in each row: ")
    val seatsPerRow = readLine()!!.toInt()
    val price = if (seatsPerRow * rows <= MINIMUN_SEAT)
        NORMAL_PRICE
    else
        LOW_PRICE

    var prices: Int
    if (price == LOW_PRICE) {
        val halfRows = rows / 2
        prices = (halfRows * seatsPerRow) * NORMAL_PRICE
        prices += (rows - halfRows) * seatsPerRow * LOW_PRICE

    }
    else
    {
        prices = rows * seatsPerRow * NORMAL_PRICE
    }
    println("Total income: $$prices")

}


fun createScreen() {
    // write your code here
    val rows = 7
    val columns = 8

    println("Cinema:")
    Array(rows+1) {
        row-> Array(columns+1) {

            if (it ==0 && row ==0)
                print("  ")
            else if (row ==0)
                print(" ${it}")
            else
                if (it==0 && row !=0)
                    print("${row} ")
                else
                    print(" S")

        }
        println("")

    }
}

