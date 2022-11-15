package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Here we associate the button Id with the code and receive a name in variable not modifiable
        val rollButton: Button = findViewById(R.id.randomRoll)
        // Here is where the button is called to listen
        rollButton.setOnClickListener {
            //Here we call to show on the textview the result of the random dice
            val resultTextView: ImageView = findViewById(R.id.imageView)
            rollButton.setOnClickListener {
                rollDice()
            }
        }
        rollDice()
    }

    // Roll the dice and update the screen with the result.
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Determine which dreawable resource ID to use based on the dice roll
        val drawableResourse = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        // Update the ImageView with the correct drawable resource ID
        /*Acá el concepto importante que no conocia es el de setImageResource, este funciona
        para poder manejar distintas imagenes en una misma ImageView*/
        diceImage.setImageResource(drawableResourse)
        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

}

//Here we calculate the random number
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

