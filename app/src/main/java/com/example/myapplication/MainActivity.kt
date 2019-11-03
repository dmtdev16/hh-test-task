package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val regex = Regex("((^| )-?([0]|[1-9][0-9]*))+")
        disposable = RxTextView.textChanges(editTextInputArray)
            .skipInitialValue()
            .debounce(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                textViewResult.text = if (regex.matches(editTextInputArray.text.toString()))
                    getString(R.string.index_max_element) + Utils.getArrayMaxIndex(
                        editTextInputArray.text.toString().split(" ").toTypedArray()
                    ).toString()
                else
                    getString(R.string.wrong_format)
            }
    }

    override fun onStop() {
        super.onStop()
        disposable?.dispose()
    }
}
