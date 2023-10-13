package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val extras : Bundle? = intent.extras
        val em : EditText = findViewById(R.id.editTextTextEmailAddress)
        val na : EditText = findViewById(R.id.editTextText2)
        val ag : EditText = findViewById(R.id.editTextNumber2)


        if (extras != null){
            var email: String? = extras.getString(MainActivity.EMAIL_INFO)
            val name : String? = extras.getString(MainActivity.NAME_INFO)
            val age : String? = extras.getString(MainActivity.AGE_INFO)

            if (email!= null){
                em.setText("$email")

            }


            if (name != null){
                na.setText(name)

            }

            if (age != null){
                ag.setText(age)

            }
         //   email_info.setText(intent.extras?.getString(MainActivity.EMAIL_INFO))

        }
    }

    fun sendMessage(email: String?, name: String?, age : String?){
            val data = Intent()

            data.putExtra(MainActivity.EMAIL_INFO, email)
            data.putExtra(MainActivity.NAME_INFO, name)
            data.putExtra(MainActivity.AGE_INFO, age)

            setResult(RESULT_OK, data)

            finish()
    }

    fun btclickagain(view: View) {
        val Email_BOX: EditText = findViewById(R.id.editTextTextEmailAddress)
        val Name_BOX: EditText = findViewById(R.id.editTextText2)
        val Age_BOX: EditText = findViewById(R.id.editTextNumber2)



        val email: String? = Email_BOX.text.toString()
        val name: String? = Name_BOX.text.toString()
        val age: String? = Age_BOX.text.toString()
        if (email == "" || name == "" || age == ""){
            Toast.makeText(this, "Проверьте ваши данные и заполните их!", Toast.LENGTH_SHORT).show()

        }
        else {
            sendMessage(email, name, age)
        }

    }


}