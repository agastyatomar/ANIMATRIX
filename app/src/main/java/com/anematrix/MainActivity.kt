package com.anematrix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.button.MaterialButton
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val animateBtn = findViewById<MaterialButton>(R.id.animateBtn)
        val animationView = findViewById<LottieAnimationView>(R.id.animationView)
        val saveBtn = findViewById<MaterialButton>(R.id.saveBtn)
        val editBtn = findViewById<MaterialButton>(R.id.editBtn)

        animateBtn.setOnClickListener {
            animationView.playAnimation()
            Toast.makeText(this, "ANIMATRIX - Animation Started", Toast.LENGTH_SHORT).show()
        }

        saveBtn.setOnClickListener {
            // TODO: Implement character saving
            Toast.makeText(this, "Saving character...", Toast.LENGTH_SHORT).show()
        }

        editBtn.setOnClickListener {
            // Navigate to video editor
            val intent = android.content.Intent(this, VideoEditorActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                Toast.makeText(this, "Character saved", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_export -> {
                val intent = android.content.Intent(this, VideoEditorActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}