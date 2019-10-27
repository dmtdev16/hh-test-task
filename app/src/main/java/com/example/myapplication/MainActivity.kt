package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val regex = Regex("(-?[0-9]+ )+(-?[0-9]+)")
        val arraySearcher = ArraySearcher()

        buttonGetMaxIndex.setOnClickListener {
            textViewResult.text = if (regex.matches(editTextInputArray.text.toString()))
                getString(R.string.index_max_element) +
                        arraySearcher.getArrayMaxIndex(editTextInputArray.text.toString().split(" ").toTypedArray()).toString()
            else getString(R.string.wrong_format)
        }
    }
}
