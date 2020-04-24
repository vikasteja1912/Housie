package com.example.housie

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val numbers = ArrayList<Int>()
    private val list = ArrayList<Int>()
    private lateinit var adapter: RecyclerMainAdapter
    private val numbersTicket = java.util.ArrayList<Int>()
    private val randomGeneratorTicket = Random()
    private lateinit var array: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..90) {
            list.add(i)
        }

        generate_number.setOnClickListener {
            numberGenerator()
        }

        click.setOnClickListener {
            val slideUp = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_out)
            val slideDown =
                    AnimationUtils.loadAnimation(applicationContext, R.anim.slide_down_from_top)
            if (rv.visibility == View.INVISIBLE) {
                rv.startAnimation(slideDown)
                rv.visibility = View.VISIBLE
                rv1.visibility = View.INVISIBLE
            } else {
                rv.startAnimation(slideUp)
                rv.visibility = View.INVISIBLE
                rv1.visibility = View.VISIBLE
            }
        }
        adapter = RecyclerMainAdapter(this, list, 0)
        rv.adapter = adapter
        rv.layoutManager = GridLayoutManager(this, 10, GridLayoutManager.VERTICAL, false)

        generate.setOnClickListener {
            getArray15()
            numbersTicket.clear()
            numberGeneratorTicket(0, 9)
            numberGeneratorTicket(10, 19)
            numberGeneratorTicket(20, 29)
            numberGeneratorTicket(30, 39)
            numberGeneratorTicket(40, 49)
            numberGeneratorTicket(50, 59)
            numberGeneratorTicket(60, 69)
            numberGeneratorTicket(70, 79)
            numberGeneratorTicket(80, 90)
            numbersTicket.sort()
            generateFifteen()
            rv1.adapter = GridAdapter(this, numbersTicket)
            rv1.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false)
        }
    }

    //for 90 numbers generator
    private fun numberGenerator() {
        val randomGenerator = Random()
        if (numbers.size < 91) {
            val random = randomGenerator.nextInt(91)
            if (!numbers.contains(random)) {
                numbers.add(random)
                result.text = random.toString()
                adapter.sample(random)
            } else {
                numberGenerator()
            }
        } else {
            Toast.makeText(this, "Numbers completed", Toast.LENGTH_LONG).show()
        }
    }

    private fun getArray15() {
        array = when (randomGeneratorTicket.nextInt(4)) {
            1 -> arrayOf(1, 3, 5, 7, 11, 12, 16, 18, 20, 22, 24, 26)
            2 -> arrayOf(0, 4, 5, 6, 10, 11, 12, 16, 17, 18, 23, 25)
            else -> arrayOf(0, 2, 7, 8, 9, 12, 13, 17, 20, 21, 22, 25)

        }
    }

    //Removes 12 numbersTicket from the list of 27
    private fun generateFifteen() {
        for (i in 0 until 11) {
            numbersTicket[array[i]] = 0
        }
    }

    //for every column generates three numbersTicket
    private fun numberGeneratorTicket(randomMin: Int, randomMax: Int) {
        for (i in 1..3) {
            randomNmberGenerator(randomMin, randomMax)
        }
    }

    //for ticket number generator
    private fun randomNmberGenerator(randomMin: Int, randomMax: Int) {
        if (numbersTicket.size < 27) {
            val random = randomGeneratorTicket.nextInt(randomMax - randomMin + 1) + randomMin
            if (!numbersTicket.contains(random)) {
                numbersTicket.add(random)
            } else {
                randomNmberGenerator(randomMin, randomMax)
            }
        }
    }
}
