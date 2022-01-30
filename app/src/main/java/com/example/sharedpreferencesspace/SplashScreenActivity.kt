package com.example.sharedpreferencesspace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferencesspace.AppContext.Companion.prefs


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        if (prefs.getSwitchState()){
            val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(i)
            // close this activity
            finish()

        }else{
            Handler().postDelayed(Runnable { //This method will be executed once the timer is over
                // Start your app main activity
                val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(i)
                // close this activity
                finish()
            }, 3000)

        }


    }
}