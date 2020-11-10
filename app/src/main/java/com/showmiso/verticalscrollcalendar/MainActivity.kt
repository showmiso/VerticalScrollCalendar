package com.showmiso.verticalscrollcalendar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickView(view: View) {
        when (view.id) {
            R.id.btn_calendar -> {

            }
            R.id.btn_main -> {

            }
            R.id.btn_web_view -> {

            }
            R.id.btn_lock -> {
                
            }
        }
    }
}