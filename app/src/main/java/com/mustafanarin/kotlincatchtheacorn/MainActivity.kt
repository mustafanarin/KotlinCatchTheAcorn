package com.mustafanarin.kotlincatchtheacorn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Objects
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    var imageArray = ArrayList<ImageView>()
    var score = 0
    var runnable = Runnable{}
    var handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)

        hideImages()

        object : CountDownTimer(15500,1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeTEXT.text= "Time: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                handler.removeCallbacks(runnable)
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                timeTEXT.text= "Time: 0"
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart the game?")

                alert.setPositiveButton("YES") {dialog, wich ->
                    var intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("NO") {dialog, wich ->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

        }.start()
    }

    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                var random = java.util.Random()
                var randomNumber = random.nextInt(16)
                imageArray[randomNumber].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)

    }

    fun acorn(view: View){

        scoreText.text = "Score: ${score++}"
    }
}