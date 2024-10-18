fun main() {
    // var s = "1337c0d3"
    // var s = "words and 987"
    // var s = "  -457 +hello"
    // var s = ""
    // var s = "  12    3   4   "
    var s = "2147483648"
    println(myAtoi(s))
}

enum class State {
    born,
    started,
    survived,
    dead
}

class StateMachine {
    var currrentState = State.born
    var sign = 1
    var result = 0

    fun toStarted(ch: Char) {
        sign = if (ch == '-') -1 else 1
        currrentState = State.started
    }
    
    fun toSurvived(digit: Int) {
        
        currrentState = State.survived
        appendDigit(digit)
    }
    
    fun toDead() {
        currrentState = State.dead
    }

    fun appendDigit(digit: Int) {
        if(Int.MAX_VALUE / 10 < result || (
            Int.MAX_VALUE / 10 == result && Int.MAX_VALUE % 10 < digit)) {
                if(sign == 1) {
                    result = Int.MAX_VALUE
                } else {
                    result = Int.MIN_VALUE
                    sign = 1
                }
                toDead()
        } else {
            result = result * 10 + digit

        }

    }

    fun transit(ch: Char) {
        when(currrentState) {
            State.born -> {
                when {
                    ch == ' ' -> {

                    }
                    ch == '+' || ch == '-' -> {
                        toStarted(ch)
                    }
                    ch.isDigit() -> {
                        toSurvived(ch - '0')
                    }
                    else -> {
                        toDead()
                    }
                }
            }
            State.started, State.survived -> {
                if (ch.isDigit()) {
                    toSurvived(ch - '0')                    
                } else {
                    toDead()
                }
            }
            else -> Unit
        }
    }
}


fun myAtoi(input: String): Int {
    val sm = StateMachine()

    for (ch in input) {
        if(sm.currrentState == State.dead) break
            sm.transit(ch)
    }
    return sm.sign * sm.result
}