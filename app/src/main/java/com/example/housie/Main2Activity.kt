package com.example.housie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    private val numbers = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        generate.setOnClickListener {
            numberGenerator(1, 9)
            numbers_random_1.text = numbers.toString()
            numbers.clear()
            numberGenerator(10, 19)
            numbers_random_2.text = numbers.toString()
            numbers.clear()
            numberGenerator(20, 29)
            numbers_random_3.text = numbers.toString()
            numbers.clear()
            numberGenerator(30, 39)
            numbers_random_4.text = numbers.toString()
            numbers.clear()
            numberGenerator(40, 49)
            numbers_random_5.text = numbers.toString()
            numbers.clear()
            numberGenerator(50, 59)
            numbers_random_6.text = numbers.toString()
            numbers.clear()
            numberGenerator(60, 69)
            numbers_random_7.text = numbers.toString()
            numbers.clear()
            numberGenerator(70, 79)
            numbers_random_8.text = numbers.toString()
            numbers.clear()
            numberGenerator(80, 90)
            numbers_random_9.text = numbers.toString()
            numbers.clear()
        }
    }

    //for every column generates three numbers
    private fun numberGenerator(randomMin: Int, randomMax: Int) {
        for (i in 1..3) {
            randomNmberGenerator(randomMin, randomMax)
        }
    }

    //for ticket number generator
    private fun randomNmberGenerator(randomMin: Int, randomMax: Int) {
        val randomGenerator = Random()
        if (numbers.size < 3) {
            val random = randomGenerator.nextInt(randomMax - randomMin+1) + randomMin
            if (!numbers.contains(random)) {
                numbers.add(random)
            } else {
                randomNmberGenerator(randomMin, randomMax)
            }
        }
    }
}
