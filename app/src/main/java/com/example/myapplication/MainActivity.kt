package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object{
        const val EMAIL_INFO: String = "email"
        const val NAME_INFO : String = "name"
        const val AGE_INFO : String = "age"


    }

    var startAcrivity:ActivityResultLauncher<Intent>? = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
       result ->
        val editText : EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameEditText : EditText = findViewById(R.id.editTextText)
        val ageEditText :EditText = findViewById(R.id.editTextNumber)
        if (result.resultCode == RESULT_OK) {

            val tv : TextView = findViewById(R.id.textView)
            val tv2 : TextView = findViewById(R.id.textView3)
            val tv3 : TextView = findViewById(R.id.textView4)

            tv.visibility = VISIBLE
            tv2.visibility = VISIBLE
            tv3.visibility = VISIBLE

            val intent: Intent? = result.data
            val email: String? = intent?.getStringExtra(EMAIL_INFO)
            val name: String? = intent?.getStringExtra(NAME_INFO)
            val age: String? = intent?.getStringExtra(AGE_INFO)


            editText.setText(email)
            nameEditText.setText(name)
            ageEditText.setText(age)
        } else {
            editText.setText("Ошибка доступа")
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onButtonClick(view: View){
        var emailBox: EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameBox : EditText = findViewById(R.id.editTextText)
        val ageBox : EditText = findViewById(R.id.editTextNumber)


        val name : String = nameBox.text.toString()
        var email: String = emailBox.text.toString()
        var age: String = ageBox.text.toString()

        var intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)

        if (email == "" || name == "" || age == ""){
            Toast.makeText(this, "Заполните ваши данные!", Toast.LENGTH_SHORT).show()

        }
        else {
            intent.putExtra(EMAIL_INFO, email)
            intent.putExtra(NAME_INFO, name)
            intent.putExtra(AGE_INFO, age)


            startAcrivity?.launch(intent)
        }
    }

}