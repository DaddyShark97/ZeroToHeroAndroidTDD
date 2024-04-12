package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)
        layout = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            layout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removeTextView = layout.childCount == 1
        outState.putBoolean("key", removeTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextView = savedInstanceState.getBoolean("key")
        if (removedTextView)
            layout.removeView(textView)
    }
}
