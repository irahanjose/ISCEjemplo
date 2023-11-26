package com.example.iscejemplo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.iscejemplo.ui.theme.ISCEjemploTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
    // CajaContenido()
            Login()
        }
    }
}

@Composable
fun CajaContenido(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column {
           // Image(painter = painterResource(id = R.drawable.haland),
            //    contentDescription = "")
            AsyncImage(model = "https://i.imgur.com/WGO5bax.jpeg",
                contentDescription = "Imagen de Internet")
            Text(
                text =  "Scientists vs Programmers",
                fontSize = 27.sp,
                color = Color.Red,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif,
                letterSpacing = 3.sp,
                textAlign = TextAlign.Center,
                lineHeight = 2.em

                )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(){
  Column (modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center){

      var user by remember { mutableStateOf("") }
      var pass by remember { mutableStateOf("") }
      var resp by remember { mutableStateOf("No hay resultado") }

      OutlinedTextField(
          value = user ,
          onValueChange = {user = it},
          label = {
              Text(text = "Usuario: ")
          },
          modifier = Modifier
              .fillMaxWidth()
              .padding(10.dp),
          singleLine = true)

      OutlinedTextField(
          value = pass ,
          onValueChange = {pass = it},
          label = {
              Text(text = "Contraseña: ")
          },
          modifier = Modifier
              .fillMaxWidth()
              .padding(10.dp),
          singleLine = true,

          visualTransformation = PasswordVisualTransformation())
// contexto --------------
      val contextForToast = LocalContext.current.applicationContext
//---------------------
      Button(onClick = {
                       var cadena = ""
          if(user.length == 0){
              cadena = "No se puede dejar en blanco"
          }else{
              if(pass.length == 0 ){
                  cadena = "No puedes dejar la contraseña vacia"
              }
          }
          resp = cadena
          Toast.makeText(contextForToast, "Soy un Toast", Toast.LENGTH_LONG).show()
      },
          modifier = Modifier
              .padding(10.dp)
              .align(Alignment.CenterHorizontally)) {
          Text(text = "Iniciar Sesion")
      }
      Text(text = resp, modifier = Modifier.fillMaxWidth())
  }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ISCEjemploTheme {
      //  CajaContenido()
        Login()
    }
}