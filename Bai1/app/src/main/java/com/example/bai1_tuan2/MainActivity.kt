package com.example.bai1_tuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bai1_tuan2.ui.theme.Bai1_Tuan2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai1_Tuan2Theme {
                AgeCheckerScreen()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AgeCheckerScreen() {
    var name by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun classifyAge(age: Int): String {
        return when {
            age > 65 -> "Người già"
            age in 6..65 -> "Người lớn"
            age in 2..5 -> "Trẻ em"
            age >= 0 -> "Em bé"
            else -> "Tuổi không hợp lệ"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("THỰC HÀNH 01", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Họ và tên") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text("Tuổi") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val age = ageInput.toIntOrNull()
            result = if (age != null) {
                "$name là ${classifyAge(age)}"
            } else {
                "Vui lòng nhập tuổi hợp lệ!"
            }
        }) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(result, fontSize = 18.sp)
    }
}
