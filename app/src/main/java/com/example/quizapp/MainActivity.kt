package com.example.quizapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun QuizApp() {
    val languages = listOf("Kotlin", "Python", "Java", "Swift")
    var selectedLanguages by remember { mutableStateOf<String?>(null) }

    var q2Column by remember { mutableStateOf(false) }
    var q2TextField by remember { mutableStateOf(false) }
    var q2Row by remember { mutableStateOf(false) }
    var q2Button by remember { mutableStateOf(false) }

    var q3Answer by remember { mutableStateOf("") }

    var score by remember { mutableIntStateOf(0) }

    var validation by remember { mutableStateOf(false) }
    var quizReset by remember { mutableStateOf(true) }

    fun reset() {
        selectedLanguages = null
        q2Column = false
        q2TextField = false
        q2Row = false
        q2Button = false
        q3Answer = ""
        score = 0
        validation = false
        quizReset = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(25.dp)
    )
    {
        Text(
            text = "Android Quiz",
            fontSize = 30.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(15.dp))
        Canvas(modifier = Modifier.fillMaxWidth().height(3.dp)) {
            drawLine(
                color = Color.Black,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f),
                strokeWidth = 3f
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Question 1 : Single Choice",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Which language is officially supported for Android development ?",
            fontSize = 16.sp,
            color = Color.Black
        )
        Column {
            languages.forEach { language ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (selectedLanguages == language),
                        onClick = { selectedLanguages = language }
                    )
                    Text(text = language)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (validation) {
            if (selectedLanguages == "Kotlin") {
                Text(
                    text = "Good Answer !",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green
                )
            } else {
                Text(
                    text = "False : The good answer was 'Kotlin'",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Canvas(modifier = Modifier.fillMaxWidth().height(3.dp)) {
            drawLine(
                color = Color.Black,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f),
                strokeWidth = 3f
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Question 2 : Multiple Choice",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Which of the following are Jetpack Compose layout components ?",
            fontSize = 16.sp,
            color = Color.Black
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = q2Column,
                onCheckedChange = { isChecked -> q2Column = isChecked }
            )
            Text(text = "Column")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = q2TextField,
                onCheckedChange = { isChecked -> q2TextField = isChecked }
            )
            Text(text = "TextField")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = q2Row,
                onCheckedChange = { isChecked -> q2Row = isChecked }
            )
            Text(text = "Row")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = q2Button,
                onCheckedChange = { isChecked -> q2Button = isChecked }
            )
            Text(text = "Button")
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (validation) {
            if (q2Column && !q2TextField && q2Row && !q2Button) {
                Text(
                    text = "Good Answer !",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green
                )
            } else {
                Text(
                    text = "False : The good answers were 'Column' and 'Row'",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Canvas(modifier = Modifier.fillMaxWidth().height(3.dp)) {
            drawLine(
                color = Color.Black,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f),
                strokeWidth = 3f
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Question 3 : ShortAnswer",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Which annotation is used to declare a composable function in Jetpack Compose ?",
            fontSize = 16.sp,
            color = Color.Black
        )
        OutlinedTextField(
            value = q3Answer,
            onValueChange = { newText -> q3Answer = newText },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Answer",
                    color = Color.Gray,
                    fontSize = 20.sp
                )
            },
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        if (validation) {
            if (q3Answer == "Composable") {
                Text(
                    text = "Good Answer !",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Green
                )
            } else {
                Text(
                    text = "False : The good answer was 'Composable'",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Canvas(modifier = Modifier.fillMaxWidth().height(3.dp)) {
            drawLine(
                color = Color.Black,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f),
                strokeWidth = 3f
            )
        }
        Button(
            onClick = {
                score = calculScore(
                    selectedLanguages,
                    q2Column,
                    q2TextField,
                    q2Row,
                    q2Button,
                    q3Answer
                )
                quizReset = false
                validation = true
            },
            shape = RoundedCornerShape(12.dp),
            enabled = quizReset,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(
                text = "Submit Answers",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (validation) {
            Text(
                text = "Your Score : $score / 3",
                fontSize = 28.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Question 1 : ${
                    if (selectedLanguages == "Kotlin") "Correct" else "False"
                }",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = "Question 2 : ${
                    if (q2Column && !q2TextField && q2Row && !q2Button) "Correct" else "False"
                }",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = "Question 3 : ${
                    if (q3Answer == "Composable") "Correct" else "False"
                }",
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { reset() },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.LightGray
                ),
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text(
                    text = "Reset Quiz",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


fun calculScore (selectedLanguages : String?, q2a1 : Boolean, q2a2 : Boolean, q2a3 : Boolean, q2a4 : Boolean, q3Answer : String) : Int {
    var score = 0
    if(selectedLanguages == "Kotlin"){score += 1}
    if(q2a1 && !q2a2 && q2a3 && !q2a4){score += 1}
    if(q3Answer == "Composable"){score += 1}
    return score
}