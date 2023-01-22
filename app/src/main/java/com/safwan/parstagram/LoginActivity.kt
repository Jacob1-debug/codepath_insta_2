package com.safwan.parstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Check if there's a user logged in
        // If there is, take them to MainActivity

        if(ParseUser.getCurrentUser() != null) {
            goToMainActivity()
        }

        findViewById<Button>(R.id.login_button).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            loginUser(username, password)
        }

        findViewById<Button>(R.id.signupButton).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            signUpUser(username, password)
        }
    }

    private fun signUpUser(username: String, password: String){
        // Create the ParseUser
        val user = ParseUser()

        // Set fields for the user to be created
        user.setUsername(username)
        user.setPassword(password)

        user.signUpInBackground { e ->
            if (e == null) {
                // User has successfully signed created a new account

                // TODO: Navigate user to the MainActivity
                Toast.makeText(this,"Succesfully made account, press login to go to your account!",Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Show a toast to tell user sign up was not successful
                Toast.makeText(this,"Account sign up unsuccessful",Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
    private fun loginUser(username: String, password: String) {
        ParseUser.logInInBackground(username, password, ({ user, e ->
            if (user != null) {
                Log.i(TAG,"Successfully logged in user")
                goToMainActivity()
            } else {
                e.printStackTrace()
                Toast.makeText(this,"Error logging in", Toast.LENGTH_SHORT).show()
            }})
        )

    }

    private fun goToMainActivity(){
        val intent = Intent(this@LoginActivity,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    companion object {
        const val TAG = "LoginActivity"
    }
}

"""
The previous code is for an Android app in the Java programming language. 
The LoginActivity class is a class for a login activity in the app. It appears 
to handle the user login and signup process by using the Parse library to interact with a 
backend server. The onCreate method is called when the activity is created and it sets up 
click listeners for the login and signup buttons, and also checks if a user is already logged
in and if so, navigates the user to the main activity. The loginUser method logs the user in by 
using the Parse library to verify the username and password, and the signUpUser method creates a 
new user account. The goToMainActivity method is used to navigate the user to the main activity.
"""
