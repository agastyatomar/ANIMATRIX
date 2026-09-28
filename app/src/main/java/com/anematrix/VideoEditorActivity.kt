package com.anematrix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.seekbar.MaterialSeekBar
import android.widget.TextView
import android.widget.Toast

class VideoEditorActivity : AppCompatActivity() {

    private var currentFrame = 0
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_editor)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val seekFrame = findViewById<MaterialSeekBar>(R.id.seekFrame)
        val frameText = findViewById<TextView>(R.id.frameText)
        val playBtn = findViewById<MaterialButton>(R.id.playBtn)
        val exportBtn = findViewById<MaterialButton>(R.id.exportBtn)
        val backBtn = findViewById<MaterialButton>(R.id.btnBack)

        // Setup RecyclerView for frames
        val recyclerView = findViewById<RecyclerView>(R.id.framesRecycler)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        // TODO: Setup frame adapter

        seekFrame.max = 30
        seekFrame.setOnSeekBarChangeListener(object : MaterialSeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: MaterialSeekBar, progress: Int, fromUser: Boolean) {
                currentFrame = progress
                frameText.text = "Frame: $progress"
            }
            override fun onStartTrackingTouch(seekBar: MaterialSeekBar) {}
            override fun onStopTrackingTouch(seekBar: MaterialSeekBar) {}
        })

        playBtn.setOnClickListener {
            isPlaying = !isPlaying
            playBtn.text = if (isPlaying) "Pause" else "Play"
            Toast.makeText(this, if (isPlaying) "Playing animation" else "Paused", Toast.LENGTH_SHORT).show()
        }

        exportBtn.setOnClickListener {
            Toast.makeText(this, "Exporting animation as MP4/GIF...", Toast.LENGTH_SHORT).show()
            // TODO: Implement export using FFmpeg or Lottie export
        }

        backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}