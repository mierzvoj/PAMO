package com.project.pamokot.ui.theme.pages.data

data class QuizModel(
    val mQuestion: Int,
    val mAnswer: Boolean

)
{
    internal data class QuizModel(private var mQuestion: Int, private var mAnswer: Boolean) {
        fun getmQuestion(): Int {
            return mQuestion
        }

        fun setmQuestion(mQuestion: Int) {
            this.mQuestion = mQuestion
        }

        fun ismAnswer(): Boolean {
            return mAnswer
        }

        fun setmAnswer(mAnswer: Boolean) {
            this.mAnswer = mAnswer
        }
    }

}
