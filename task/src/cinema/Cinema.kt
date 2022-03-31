package cinema

fun main() {
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

