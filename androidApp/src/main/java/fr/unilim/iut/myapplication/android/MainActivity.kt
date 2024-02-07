package fr.unilim.iut.myapplication.android

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.unilim.iut.myapplication.Greeting

const val NAME = "name"
const val AGE = "age"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp)
                , horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(100.dp)
            ) {
                greeting(resources.getString(R.string.greeting))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    input()
                }

            }

        }
    }

    @Composable
    fun greeting(text:String){
        Text(text, fontWeight = FontWeight.Bold, fontSize = 30.sp)
    }

    @Composable
    fun input(){
        var nameText by remember { mutableStateOf("") }
        var birthyearText by remember { mutableStateOf("") }

        Text(nameText)
        TextField(label = { Text(text = resources.getString(R.string.name_input_label))}, value = nameText, onValueChange = {
            nameText = it
        })
        TextField(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), label = { Text(text = resources.getString(R.string.birthyear_input_label))}, value = birthyearText, onValueChange = {
            birthyearText = it
        })
        val birthyear = birthyearText.toIntOrNull() ?: 0
        validate_button(nameText, birthyear)
    }

    @Composable
    fun validate_button(name:String, birthyear:Int){
        Button(onClick = {
            if(name.isEmpty()) {
                Toast.makeText(this, resources.getString(R.string.no_name_error_message), Toast.LENGTH_SHORT).show()
            }else{
                val ageCalculator = AgeCalculator()
                val age = ageCalculator.computeAge(birthyear)

                val activity2Intent = Intent(this, Activity2::class.java)
                activity2Intent.putExtra(NAME, name)
                activity2Intent.putExtra(AGE, age)

                startActivity(activity2Intent)
            }
        }, shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(resources.getColor(R.color.teal_200, null)))
        ) {
            Text(text = resources.getString(R.string.validate_button_label))
        }
    }
}
