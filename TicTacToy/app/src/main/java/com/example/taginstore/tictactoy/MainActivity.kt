package com.example.taginstore.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var Player1List=ArrayList<Int>()
    var Player2List=ArrayList<Int>()
    var ActivePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btClick(view:View){



        val btSelected = view as Button
        var cellID=0
        when (btSelected.id){
            R.id.bt1 -> cellID = 1
            R.id.bt2 -> cellID = 2
            R.id.bt3 -> cellID = 3
            R.id.bt4 -> cellID = 4
            R.id.bt5 -> cellID = 5
            R.id.bt6 -> cellID = 6
            R.id.bt7 -> cellID = 7
            R.id.bt8 -> cellID = 8
            R.id.bt9 -> cellID = 9
        }
        PlayGame(cellID,btSelected)
    }

    fun PlayGame(cellID:Int, btSelected:Button){
    if (ActivePlayer == 1){
        btSelected.text = "X"
        btSelected.setBackgroundColor(Color.GREEN)
        Player1List.add(cellID)
        ActivePlayer = 2
        AutoPlay()
    }else
        if (ActivePlayer == 2){
            btSelected.text = "O"
            btSelected.setBackgroundColor(Color.BLUE)
            Player2List.add(cellID)
            ActivePlayer = 1
        }
     btSelected.isEnabled=false
        CheckWinner()
    }

    fun CheckWinner(){
        var winner = -1
        //row 1
        if (Player1List.contains(1) && Player1List.contains(2) && Player1List.contains(3)) {winner = 1}
        if (Player2List.contains(1) && Player2List.contains(2) && Player2List.contains(3)) {winner = 2}
        //row 2
        if (Player1List.contains(4) && Player1List.contains(5) && Player1List.contains(6)) {winner = 1}
        if (Player2List.contains(4) && Player2List.contains(5) && Player2List.contains(6)) {winner = 2}
        //row 3
        if (Player1List.contains(7) && Player1List.contains(8) && Player1List.contains(9)) {winner = 1}
        if (Player2List.contains(7) && Player2List.contains(8) && Player2List.contains(9)) {winner = 2}

        //Column 1
        if (Player1List.contains(1) && Player1List.contains(4) && Player1List.contains(7)) {winner = 1}
        if (Player2List.contains(1) && Player2List.contains(4) && Player2List.contains(7)) {winner = 2}
        //Column 2
        if (Player1List.contains(2) && Player1List.contains(5) && Player1List.contains(8)) {winner = 1}
        if (Player2List.contains(2) && Player2List.contains(5) && Player2List.contains(8)) {winner = 2}
        //Column 3
        if (Player1List.contains(3) && Player1List.contains(6) && Player1List.contains(9)) {winner = 1}
        if (Player2List.contains(3) && Player2List.contains(6) && Player2List.contains(9)) {winner = 2}

        //Diagonal 1
        if (Player1List.contains(1) && Player1List.contains(5) && Player1List.contains(9)) {winner = 1}
        if (Player2List.contains(1) && Player2List.contains(5) && Player2List.contains(9)) {winner = 2}
        //Diagonal 2
        if (Player1List.contains(3) && Player1List.contains(5) && Player1List.contains(7)) {winner = 1}
        if (Player2List.contains(3) && Player2List.contains(5) && Player2List.contains(7)) {winner = 2}

        if (winner!=-1)
            Toast.makeText(this, "Player $winner win the game",Toast.LENGTH_LONG).show()
    }

    fun AutoPlay(){
        //Thread.Sleep
        var emptyCells=ArrayList<Int>()

        for (cellID in 1..9){
            if ( !( Player1List.contains(cellID) ||Player2List.contains(cellID)))
                emptyCells.add(cellID)
        }
        val r = Random()
        val ranIndex = r.nextInt(emptyCells.size -0) + 0
        val cellID = emptyCells[ranIndex]
        var btSelected:Button?
        when (cellID){
            1-> btSelected = bt1
            2-> btSelected = bt2
            3-> btSelected = bt3
            4-> btSelected = bt4
            5-> btSelected = bt5
            6-> btSelected = bt6
            7-> btSelected = bt7
            8-> btSelected = bt8
            9-> btSelected = bt9
            else -> {
                btSelected = bt1
            }

        }
        PlayGame(cellID,btSelected)
    }
}
