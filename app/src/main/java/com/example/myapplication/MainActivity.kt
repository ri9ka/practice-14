package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object{
        const val EMAIL_INFO: String = "email"
        const val ACCESS_MESSAGE: String = "ACCESS_MESSAGE"
    }

    var startAcrivity:ActivityResultLauncher<Intent>? = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
       result ->
        val editText : EditText = findViewById(R.id.editTextTextEmailAddress)
        if (result.resultCode == RESULT_OK) {

            val intent: Intent? = result.data
            val email: String? = intent!!.getStringExtra(ACCESS_MESSAGE)
            editText.setText(email)
        }
        else {
            editText.setText("Ошибка доступа")
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View){
        var emailBox: EditText = findViewById(R.id.editTextTextEmailAddress)
        var email: String = emailBox.text.toString()
        var intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra(EMAIL_INFO, email)
        startAcrivity?.launch(intent)
    }

}