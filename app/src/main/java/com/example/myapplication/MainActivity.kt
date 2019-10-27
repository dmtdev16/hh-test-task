package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val regex = Regex("((^| )-?([0]|[1-9][0-9]*))+")

        buttonGetMaxIndex.setOnClickListener {
            textViewResult.text = if (regex.matches(editTextInputArray.text.toString()))
                getString(R.string.index_max_element) +
                        Utils.getArrayMaxIndex(editTextInputArray.text.toString().split(" ").toTypedArray()).toString()
            else getString(R.string.wrong_format)
        }
    }
}
