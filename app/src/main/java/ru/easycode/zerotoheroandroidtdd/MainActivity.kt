package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private val count = Count.Base(step = 2)

    private lateinit var textView: TextView
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            val result = count.increment(textView.text.toString())
            textView.text = result

        }
    }
}