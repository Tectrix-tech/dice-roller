package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the results on the app screen
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        //Roll dice when app starts
        rollDice()
    }
    /**j
     *
     */
    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //Create a new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Display the roll result on the screen
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when(diceRoll){
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        //Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    //Roll function of the Dice Class
    fun roll(): Int {
        return (1..numSides).random()
    }
}
