package com.example.signinwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signinwithfirebase.databinding.ActivityForgotPasswordBinding
import com.example.signinwithfirebase.databinding.ActivityForgotPasswordDoneBinding
import com.example.signinwithfirebase.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordDone : AppCompatActivity() {

    private lateinit var fpdBinding: ActivityForgotPasswordDoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fpdBinding = ActivityForgotPasswordDoneBinding.inflate(layoutInflater)
        setContentView(fpdBinding.root)

        //navigate to forgot sign in
        fpdBinding.btnFPDmoveSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }


    }
}