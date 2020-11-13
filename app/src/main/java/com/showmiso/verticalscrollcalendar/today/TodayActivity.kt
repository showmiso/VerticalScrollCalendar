package com.showmiso.verticalscrollcalendar.today

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.showmiso.verticalscrollcalendar.R
import kotlinx.android.synthetic.main.activity_today.*

class TodayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)

        val navController = findNavController(R.id.fragment)
        nav_bottom_view.setupWithNavController(navController)
    }
}