package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.portfolio.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setSupportActionBar(binding.toolbar)

        binding.ibtn1.setOnClickListener {
            val intent = Intent(this, det2::class.java)
            intent.putExtra("TITLE", "Certifications")
            startActivity(intent)
        }

        binding.ibtn2.setOnClickListener {
            val intent = Intent(this, det2::class.java)
            intent.putExtra("TITLE", "Achievements")
            startActivity(intent)
        }

        binding.ibtn3.setOnClickListener {
            val intent = Intent(this, det2::class.java)
            intent.putExtra("TITLE", "Projects")
            startActivity(intent)
        }

        binding.ibtn4.setOnClickListener {
            val intent = Intent(this, details::class.java)
            intent.putExtra("TITLE", "Skills")
            startActivity(intent)
        }

        binding.ibtn5.setOnClickListener {
            val intent = Intent(this, det2::class.java)
            intent.putExtra("TITLE", "Education")
            startActivity(intent)
        }

        binding.ibtn6.setOnClickListener {
            val intent = Intent(this, details::class.java)
            intent.putExtra("TITLE", "Hobbies")
            startActivity(intent)
        }

        binding.darkModeToggle.setOnClickListener {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
        binding.exit.setOnClickListener{
            var g= AlertDialog.Builder(this)
            g.setTitle("Exit")
            g.setMessage("Do you  really want to exit?")
            g.setPositiveButton("Yes"){dialog, _-> finish() }
            g.setNegativeButton("Cancel"){dialog,_->dialog.dismiss()}
            g.create().show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_email -> {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("sayjan7777@gmail.com"))
                }
                startActivity(emailIntent)
                true
            }
            R.id.action_contact -> {
                val i = Intent(Intent.ACTION_DIAL)
                i.setData(Uri.parse("tel: +9877542077"))
                startActivity(i)
                true
            }
            R.id.action_feedback -> {
                val intent = Intent(this, form::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}