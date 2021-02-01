package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        *This function determines what happens on clicking on the button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            // Update the screen with the dice roll
            val diceImage: ImageView = findViewById(R.id.imageView)
            val drawableResource= when(Dice(6).roll()){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else-> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription= Dice(6).roll().toString()
        }
    }

    private fun rollDice(): Int {
        // Create new Dice object with 6 sides and roll it
        val myFirstDice = Dice(6)
        return myFirstDice.roll()
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}