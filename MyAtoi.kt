fun main() {
    var s = "1337c0d3"
    myAtoi(s)
}

fun myAtoi(s: String): Int {
    var str = s.replace(" ", "")
    for (i in str) {
        println(isNumeric(i))
    }
    return -1
}
