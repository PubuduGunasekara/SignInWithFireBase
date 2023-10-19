package com.example.signinwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signinwithfirebase.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings

class ForgotPassword : AppCompatActivity() {

    private lateinit var fpBinding: ActivityForgotPasswordBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fpBinding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(fpBinding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        fpBinding.btnSendEmail.setOnClickListener {
            val email = fpBinding.forgotPwEmail.text.toString()
            if (email.isNotEmpty()) {


                firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, ForgotPasswordDone::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this,
                                "Error sending the link, Please try again later",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_LONG).show()
            }

        }

    }

}