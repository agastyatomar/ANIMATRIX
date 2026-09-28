package com.anematrix

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class VideoEditorActivity : AppCompatActivity() {

    private var currentFrame = 0
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_editor)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val seekFrame = findViewById<SeekBar>(R.id.seekFrame)
        val frameText = findViewById<TextView>(R.id.frameText)
        val playBtn = findViewById<MaterialButton>(R.id.btnPlay)
        val exportBtn = findViewById<MaterialButton>(R.id.btnExport)
        val backBtn = findViewById<MaterialButton>(R.id.btnBack)

        seekFrame.max = 30
        seekFrame.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(bar: SeekBar?, progress: Int, fromUser: Boolean) {
                currentFrame = progress
                frameText.text = "Frame $progress / 30"
            }
            override fun onStartTrackingTouch(bar: SeekBar?) = Unit
            override fun onStopTrackingTouch(bar: SeekBar?) = Unit
        })

        playBtn.setOnClickListener {
            isPlaying = !isPlaying
            playBtn.text = if (isPlaying) "Pause" else "Play"
            Toast.makeText(this, if (isPlaying) "Preview playing" else "Preview paused", Toast.LENGTH_SHORT).show()
        }

        exportBtn.setOnClickListener {
            Toast.makeText(this, "Export pipeline is ready for the next render module", Toast.LENGTH_SHORT).show()
        }

        backBtn.setOnClickListener { finish() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
