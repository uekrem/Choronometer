package com.example.chronometer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.example.chronometer.R
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timekeeper:Long = 0
        val btnStart: Button = findViewById(R.id.btnStart)
        val btnPause: Button = findViewById(R.id.btnPause)
        val btnReset: Button = findViewById(R.id.btnReset)
        val imagevw: ImageView = findViewById(R.id.imageView)
        val crono: Chronometer = findViewById(R.id.crono)

        btnStart.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                crono.base = SystemClock.elapsedRealtime() + timekeeper
                crono.start()
                btnStart.visibility = View.GONE
                btnPause.visibility = View.VISIBLE
                imagevw.setImageDrawable(getDrawable(R.drawable.pause))
            }
        })

        btnPause.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                timekeeper = crono.base-SystemClock.elapsedRealtime()
                crono.stop()
                btnStart.visibility = View.VISIBLE
                btnPause.visibility = View.GONE
                imagevw.setImageDrawable(getDrawable(R.drawable.start))
            }
        })

        btnReset.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                crono.base = SystemClock.elapsedRealtime()
                timekeeper = 0
                crono.stop()
                btnPause.visibility = View.GONE
                btnStart.visibility = View.VISIBLE
                imagevw.setImageDrawable(getDrawable(R.drawable.start))
            }
        })

    }
}
