package generics

import Quiz
import enums.Difficulty
import printProgressBar
import progressText

fun main() {

    Quiz().printQuiz()


    println(Quiz.progressText)
    Quiz.printProgressBar()
}

/**
 * This class @Question is correct
 */

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


/**
 * This repetition is wrong, because we are rewriting the same attrs
 * and it´s redundant.
 */
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)