package com.anematrix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class VideoEditorActivity : AppCompatActivity() {

    private var currentFrame = 0
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_editor)

        val seekFrame = findViewById<SeekBar>(R.id.seekFrame)
        val frameText = findViewById<TextView>(R.id.frameText)
        val playBtn = findViewById<Button>(R.id.playBtn)
        val exportBtn = findViewById<Button>(R.id.exportBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)

        seekFrame.max = 30
        seekFrame.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                currentFrame = progress
                frameText.text = "Frame: $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        playBtn.setOnClickListener {
            isPlaying = !isPlaying
            playBtn.text = if (isPlaying) "Pause" else "Play"
            Toast.makeText(this, if (isPlaying) "Playing animation" else "Paused", Toast.LENGTH_SHORT).show()
        }

        exportBtn.setOnClickListener {
            Toast.makeText(this, "Exporting animation as MP4/GIF...", Toast.LENGTH_SHORT).show()
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}