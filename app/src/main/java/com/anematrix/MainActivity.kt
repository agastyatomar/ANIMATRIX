package com.anematrix

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.anematrix.database.CharacterDatabase
import com.anematrix.model.Character
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var database: CharacterDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = CharacterDatabase.getDatabase(this)

        findViewById<com.google.android.material.button.MaterialButton>(R.id.animateBtn).setOnClickListener {
            findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.animationView).playAnimation()
            Toast.makeText(this, "Animation preview started", Toast.LENGTH_SHORT).show()
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.saveBtn).setOnClickListener {
            lifecycleScope.launch {
                database.characterDao().insertCharacter(Character())
                Toast.makeText(this@MainActivity, "Character saved", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.editBtn).setOnClickListener {
            startActivity(Intent(this, VideoEditorActivity::class.java))
        }
    }
}
