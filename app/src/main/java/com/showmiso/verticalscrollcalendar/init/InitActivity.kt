package com.showmiso.verticalscrollcalendar.init

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.showmiso.verticalscrollcalendar.R

class InitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)
    }

    fun onClickView(view: View) {
        when (view.id) {
            R.id.btn_next -> {
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
            }
        }

    }
}