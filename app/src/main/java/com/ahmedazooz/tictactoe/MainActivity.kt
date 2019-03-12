package com.ahmedazooz.tictactoe

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buselect(view: View) {
        val BuChoice = view as Button
        var ButtonID = 0
        when (BuChoice.id) {
            R.id.b1 -> ButtonID = 1
            R.id.b2 -> ButtonID = 2
            R.id.b3 -> ButtonID = 3
            R.id.b4 -> ButtonID = 4
            R.id.b5 -> ButtonID = 5
            R.id.b6 -> ButtonID = 6
            R.id.b7 -> ButtonID = 7
            R.id.b8 -> ButtonID = 8
            R.id.b9 -> ButtonID = 9
        }
        Log.d("ButtonID", ButtonID.toString())
        playGame(ButtonID, BuChoice)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activeplayer = 1

    fun playGame(ButtonID: Int, ButtonChoice: Button) {
        if (activeplayer == 1) {
            ButtonChoice.setText("X")
            ButtonChoice.setBackgroundResource(R.color.choice)
            player1.add(ButtonID)
            activeplayer = 2
            AutoPlay()
        } else {
            ButtonChoice.setText("Y")
            ButtonChoice.setBackgroundResource(R.color.colorPrimary)
            player2.add(ButtonID)
            activeplayer = 1
        }
        ButtonChoice.isEnabled = false
        CheckWinner()
    }

    fun CheckWinner() {
        var winner = -1
        // Check Rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 2
        }
        //Check Cols
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 2
        }
        //check X cols
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 2
        }
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is winner", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Player 2 is winner", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun AutoPlay() {
        //Scan Empty Buttons
        val emptycell = ArrayList<Int>()
        for (ButtonID in 1..9) {
            if (!(player1.contains(ButtonID)) || (player2.contains(ButtonID))) {
                emptycell.add(ButtonID)
            }
        }
        //Select Random button
        val r=Random()
        val ranindex=r.nextInt(emptycell.size-0)+0
        val ButtonID=emptycell[ranindex]
        //Convert Random index to button
        var buselect:Button?
        when(ButtonID){
            1->buselect=b1
            2->buselect=b2
            3->buselect=b3
            4->buselect=b4
            5->buselect=b5
            6->buselect=b6
            7->buselect=b7
            8->buselect=b8
            9->buselect=b9
            else->{
                buselect=b1
            }

        }
        playGame(ButtonID,buselect)
    }

}
