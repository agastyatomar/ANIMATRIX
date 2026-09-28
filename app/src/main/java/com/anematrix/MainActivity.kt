package com.anematrix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animateBtn = findViewById<Button>(R.id.animateBtn)
        val animationView = findViewById<LottieAnimationView>(R.id.animationView)

        animateBtn.setOnClickListener {
            animationView.playAnimation()
            Toast.makeText(this, "ANIMATRIX - Animation Started", Toast.LENGTH_SHORT).show()
        }
    }
}