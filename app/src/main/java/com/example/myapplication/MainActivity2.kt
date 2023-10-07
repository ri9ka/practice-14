package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val extras : Bundle? = intent.extras
        val em : EditText = findViewById(R.id.editTextTextEmailAddress)

        if (extras != null){
            var email: String? = extras.getString(MainActivity.EMAIL_INFO)
            if (email!= null){
                em.setText("$email")

            }
         //   email_info.setText(intent.extras?.getString(MainActivity.EMAIL_INFO))

        }
    }

    fun sendMessage(message: String){
        var data: Intent = Intent()
        data.putExtra(MainActivity.ACCESS_MESSAGE, message)
        setResult(RESULT_OK, data)

        finish()
    }

}