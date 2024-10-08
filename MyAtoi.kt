fun main() {
    // var s = "1337c0d3"
    // var s = "words and 987"
    // var s = "+-12"
    // var s = ""
    // var s = "  12    3   4   "
    var s = "00123"
    myAtoi(s)
}

fun myAtoi(s: String): Int {
    var sign = ' '
    var start = 0
    var end = 0
    var str = s.trim()
    var i = str.length
    
    if(str.isNullOrEmpty()){
        return 0
    }
    
    if(str[0] == '-' || str[0] == '+') {
        sign = str[0]
        start = 1
        end = 1
    } else if (!str[0].isDigit()) {
        return 0
    }
    
    while(end < i && str[end].isDigit()){
        end++
    }
    
    if (start == end) {
        return 0
    }


    var result = try {
        str.substring(start,end).toInt()
    } catch (e: Exception) {
        if (sign == '-') {
            return Integer.MIN_VALUE
        } else {
            return Integer.MAX_VALUE
        }
    }
    if (sign == '-') {
        result = -result
    }

    println(result)
    return result
}
