package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.portfolio.databinding.ActivityDet2Binding
import com.example.portfolio.model.Certification
import com.example.portfolio.model.Project
import com.google.firebase.firestore.FirebaseFirestore

class det2 : AppCompatActivity() {
    private lateinit var binding: ActivityDet2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDet2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        binding.head.text = title

        when (title) {
            "Certifications" -> setCertifications()
            "Projects" -> setProjects()
            "Achievements" -> setAchievements()
            "Education" -> setEducation()
        }
        binding.home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setCertifications() {
        binding.certContainer.visibility = View.VISIBLE
        binding.ibtn1.visibility = View.GONE
        binding.ibtn2.visibility = View.GONE
        binding.ibtn3.visibility = View.GONE
        binding.ibtn4.visibility = View.GONE
        binding.ibtn5.visibility = View.GONE
        binding.t1.visibility = View.GONE
        binding.t2.visibility = View.GONE
        binding.t3.visibility = View.GONE
        binding.head.text = "Certifications"
        val db = FirebaseFirestore.getInstance()

        db.collection("certifications")
            .get()
            .addOnSuccessListener { result ->
                val certs = result.toObjects(Certification::class.java)
                binding.certContainer.removeAllViews()

                for (cert in certs) {
                    // Title
                    val titleView = TextView(this).apply {
                        text = cert.title
                        textSize = 18f
                        setPadding(0, 16, 0, 4)
                    }

                    // Platform
                    val platformView = TextView(this).apply {
                        text = "Platform: ${cert.platform}"
                        textSize = 14f
                    }

                    // Image
                    val imageView = ImageView(this).apply {
                        layoutParams = LinearLayout.LayoutParams(600, 400)
                        setPadding(0, 8, 0, 24)
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        setOnClickListener {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(cert.url)))
                        }
                    }

                    // Load image using Glide
                    Glide.with(this)
                        .load(cert.image)
                        .into(imageView)

//
//                    Glide.with(this)
//                        .load(cert.image)
//                        .placeholder(R.drawable.cert) // you can use any drawable
//                        .error(R.drawable.baseline_assignment_late_24) // in case image fails
//                        .into(imageView)

                    // Add views to the container
                    binding.certContainer.addView(titleView)
                    binding.certContainer.addView(platformView)
                    binding.certContainer.addView(imageView)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load certifications", Toast.LENGTH_SHORT).show()
            }

    }

    private fun setProjects() {
        binding.certContainer.visibility = View.VISIBLE
        binding.ibtn1.visibility = View.GONE
        binding.ibtn2.visibility = View.GONE
        binding.ibtn3.visibility = View.GONE
        binding.ibtn4.visibility = View.GONE
        binding.ibtn5.visibility = View.GONE
        binding.t1.visibility = View.GONE
        binding.t2.visibility = View.GONE
        binding.t3.visibility = View.GONE
        binding.certContainer.removeAllViews()

        val db = FirebaseFirestore.getInstance()

        db.collection("projects")
            .get()
            .addOnSuccessListener { result ->
                val projects = result.toObjects(com.example.portfolio.model.Project::class.java)

                for (project in projects) {
                    val titleView = TextView(this).apply {
                        text = project.title
                        textSize = 18f
                        setPadding(0, 16, 0, 4)
                    }

                    val imageView = ImageView(this).apply {
                        layoutParams = LinearLayout.LayoutParams(600, 400)
                        setPadding(0, 8, 0, 24)
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        setOnClickListener {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(project.url)))
                        }
                    }

                    Glide.with(this)
                        .load(project.image)
                        .placeholder(R.drawable.baseline_assignment_late_24)
                        .into(imageView)

                    binding.certContainer.addView(titleView)
                    binding.certContainer.addView(imageView)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load projects", Toast.LENGTH_SHORT).show()
            }
    }

private fun setAchievements() {
    setImageResourceWithLink(
        R.id.ibtn1,
        R.drawable.ps,
        "https://www.hackerrank.com/profile/sayjan7777"
    )
    setImageResourceWithLink(
        R.id.ibtn2,
        R.drawable.cg,
        "https://www.hackerrank.com/profile/sayjan7777"
    )
}

private fun setEducation() {
    setImageResourceWithLink(R.id.ibtn1, R.drawable.lov, "https://www.lpu.in/")
    setTextViewContent(R.id.t1, "CGPA: 8.63                 Duration: 2022-Pursuing")

    setImageResourceWithLink(R.id.ibtn2, R.drawable.apj, "https://www.apeejay.edu/jalandhar/")
    setTextViewContent(R.id.t2, "Grade: 87.6%               Duration: 2020-2022")

    setImageResourceWithLink(R.id.ibtn3, R.drawable.apj, "https://www.apeejay.edu/jalandhar/")
    setTextViewContent(R.id.t3, "Grade: 91.6%               Duration: 2019-2020")
}

private fun setImageResource(buttonId: Int, imageResource: Int) {
    val imageButton = findViewById<ImageButton>(buttonId)
    imageButton.setImageResource(imageResource)
    imageButton.visibility = View.VISIBLE
}

private fun setImageResourceWithLink(buttonId: Int, imageResource: Int, url: String) {
    val imageButton = when (buttonId) {
        R.id.ibtn1 -> binding.ibtn1
        R.id.ibtn2 -> binding.ibtn2
        R.id.ibtn3 -> binding.ibtn3
        R.id.ibtn4 -> binding.ibtn4
        R.id.ibtn5 -> binding.ibtn5
        else -> return
    }
    imageButton.setImageResource(imageResource)
    imageButton.setOnClickListener {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
    imageButton.visibility = View.VISIBLE
}


private fun setTextViewContent(textViewId: Int, text: String) {
    when (textViewId) {
        R.id.t1 -> binding.t1.text = text
        R.id.t2 -> binding.t2.text = text
        R.id.t3 -> binding.t3.text = text
    }
}

}