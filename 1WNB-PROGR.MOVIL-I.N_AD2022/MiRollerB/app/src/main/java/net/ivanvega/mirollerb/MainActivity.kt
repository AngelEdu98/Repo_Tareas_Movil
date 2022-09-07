package net.ivanvega.mirollerb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etiqueta: TextView
    lateinit var etiqueta2: TextView
    lateinit var boton : Button
    lateinit var dice1: ImageView
    lateinit var dice2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

        boton = findViewById(R.id.btnClick)
        etiqueta = findViewById(R.id.lblRoller)
        etiqueta2 = findViewById(R.id.lblRoller2)
        dice1= findViewById(R.id.imgViewDado1)
        dice2= findViewById(R.id.imgViewDado2)

        //forma larga de asignar listener
        /*
        boton.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,
                "Boton presionado", Toast.LENGTH_LONG ).show()
        })*/

        boton.setOnClickListener {
            /*Toast.makeText(applicationContext,
                "Boton presionado", Toast.LENGTH_LONG ).show()*/

            val aleatorio = diceRoller()


            val nom=when (aleatorio){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else ->{
                    R.drawable.empty_dice
                }
            }
            dice1.setImageResource(nom)
            etiqueta.text = "Aleatorio : ${aleatorio}"

            val segundo = diceRoller()

            val nom2=when (segundo){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else ->{
                    R.drawable.empty_dice
                }
            }
            dice2.setImageResource(nom2)
            etiqueta2.text = "Numero : ${segundo}"
        }
    }

    fun diceRoller(par: Int = 0): Int{
        return (1..6).random()
    }

}