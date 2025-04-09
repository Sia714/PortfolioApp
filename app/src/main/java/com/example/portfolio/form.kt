package com.example.portfolio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.portfolio.databinding.ActivityFormBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.example.portfolio.model.Feedback

class form : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val db = FirebaseFirestore.getInstance()

        binding.submitFeedbackButton.setOnClickListener {
            val name = binding.nameEditText.text.toString().trim()
            val email = binding.emailEditText.text.toString().trim()
            val message = binding.messageEditText.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && message.isNotEmpty()) {
                val feedback = Feedback(name, email, message)

                db.collection("feedback")
                    .add(feedback)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Feedback submitted successfully", Toast.LENGTH_SHORT).show()
                        binding.nameEditText.text.clear()
                        binding.emailEditText.text.clear()
                        binding.messageEditText.text.clear()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error submitting feedback", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.home.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}