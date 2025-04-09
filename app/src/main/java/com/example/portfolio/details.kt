package com.example.portfolio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import com.example.portfolio.databinding.ActivityDetailsBinding

class details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        binding.head.text = title
        when (title) {
            "Skills" -> {
                binding.head.text="Technical Skills"
                setImageAndLink(binding.ibtn1, R.drawable.cpp, "https://github.com/Sia714")
                setImageAndLink(binding.ibtn2, R.drawable.c, "https://github.com/Sia714")
                setImageAndLink(binding.ibtn3, R.drawable.pyt, "https://github.com/Sia714")
                setImageAndLink(binding.ibtn4, R.drawable.sql, "https://github.com/Sia714")

                val titleView = findViewById<TextView>(R.id.head2)
                titleView.text = "Tools and libraries"
                setImageAndLink(binding.ibt1, R.drawable.mon, "https://github.com/Sia714")
                setImageAndLink(binding.ibt2, R.drawable.git, "https://github.com/Sia714")
                setImageAndLink(binding.ibt3, R.drawable.boo, "https://github.com/Sia714")
                setImageAndLink(binding.ibt4, R.drawable.ora, "https://github.com/Sia714")

                val tView = findViewById<TextView>(R.id.head3)
                tView.text = "Soft Skills"
                setImageAndLink(binding.ib1, R.drawable.man, null)
                setImageAndLink(binding.ib2, R.drawable.ada, null)
                setImageAndLink(binding.ib3, R.drawable.col, null)
                setImageAndLink(binding.ib4, R.drawable.psl, null)
            }

            "Hobbies" -> {
                setImageAndLink(binding.ibtn1, R.drawable.art, null)
                setImageAndLink(binding.ibtn2, R.drawable.mus, null)
                setImageAndLink(binding.ibtn3, R.drawable.com, "https://www.geeksforgeeks.org/user/sayjankc5n/")
            }
        }

        val ho=findViewById<Button>(R.id.home)
        ho.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setImageOrNull(imageButton: ImageButton, imageResource: Int?) {
        if (imageResource != null) {
            imageButton.setImageResource(imageResource)
            imageButton.visibility = View.VISIBLE
        } else {
            imageButton.setImageDrawable(null)
        }
    }
    private fun setImageAndLink(imageButton: ImageButton, imageResource: Int?, link: String?) {
        imageButton.setImageResource(imageResource ?: return)
        imageButton.visibility = View.VISIBLE
        imageButton.setOnClickListener {
            if (!link.isNullOrEmpty()) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
            }
        }
    }

}