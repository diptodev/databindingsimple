package com.excitedbroltd.codingchallange

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.excitedbroltd.codingchallange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isClicked = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.person = Person()
        binding.button.setOnClickListener {
            buttonClick()
        }
    }

    private fun Person(): Person {
        return Person("Dipankar", 27)
    }

    private fun buttonClick() {

        binding.apply {
            isClicked = if (isClicked) {
                progressBar.visibility = View.VISIBLE
                button.text = "Stop"
                false
            } else {
                progressBar.visibility = View.GONE
                button.text = "Start"
                true
            }
        }
        Toast.makeText(this, "$isClicked", Toast.LENGTH_SHORT).show()

    }
}