package com.project.pamokot.ui.theme.pages

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.pamokot.R
import com.project.pamokot.ui.theme.pages.data.QuizModel
object Question{
    const val positive = true
    const val negative = false

}

@Composable
fun Quiz() {
    var index by remember { mutableStateOf(0) }
    var answerSelected =  remember { mutableStateOf(false) }
    val mQuizQuestion: Int
    var mQuestionIndex: Int = 0
    val questions = listOf(
        QuizModel(R.string.q1, false),
        QuizModel(R.string.q2, false),
        QuizModel(R.string.q3, false),
        QuizModel(R.string.q4, false),
        QuizModel(R.string.q5, false),
        QuizModel(R.string.q6, false),
    )
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                Row {

                    val q1 = questions[index]
                    Column(modifier = Modifier.padding(5.dp)) {
                        Text(text = stringResource(id = q1.mQuestion))
                        Row(){
                            RadioButton(selected = answerSelected.value == Question.positive,
                                onClick = { answerSelected.value =Question.positive },
                                colors = RadioButtonDefaults.colors(Color.Green))
                            Spacer(modifier = Modifier.size(16.dp))
                            Text(Question.positive.toString())
                            Spacer(modifier = Modifier.size(16.dp))
                            RadioButton(selected = answerSelected.value == Question.negative,
                                onClick = { answerSelected.value =Question.negative },
                                colors = RadioButtonDefaults.colors(Color.Green))
                            Spacer(modifier = Modifier.size(16.dp))
                            Text(Question.negative.toString())

                        }
                        Spacer(modifier = Modifier.size(16.dp))
                        Button(onClick = { ++index }, shape = RoundedCornerShape(8.dp),
                            content = {
                                Text(
                                    text = "Click me to see next question",
                                    color = Color.White
                                )
                                Toast.makeText(LocalContext.current, "" + answerSelected.value, Toast.LENGTH_LONG).show()
                            }
                        )
                    }


                }

            }
        }
    }
    Log.i("val", mQuestionIndex.toString())
}






@Composable
@Preview
fun seeIt2() {
    Quiz()
}