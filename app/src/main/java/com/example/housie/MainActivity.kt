package com.example.housie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val numbers = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generate_number.setOnClickListener {
            numberGenerator()
            if (result.text == "1") {
                one.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
            }
            if (result.text == "2") {
                two.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
            }
            if (result.text == "3") {
                three.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
            }
        }

        click.setOnClickListener {
           val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun numberGenerator() {

        val randomGenerator = Random()
        if (numbers.size < 10) {
            val random = randomGenerator.nextInt(10)
            if (!numbers.contains(random)) {
                numbers.add(random)
                result.text = random.toString()
            } else {
                numberGenerator()
            }
        }
    }
}
