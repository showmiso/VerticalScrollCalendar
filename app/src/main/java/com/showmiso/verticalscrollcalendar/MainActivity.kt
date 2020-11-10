package com.showmiso.verticalscrollcalendar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.showmiso.verticalscrollcalendar.blog.WebViewActivity
import com.showmiso.verticalscrollcalendar.calendar.CalendarActivity
import com.showmiso.verticalscrollcalendar.lock.LockActivity
import com.showmiso.verticalscrollcalendar.today.TodayActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickView(view: View) {
        when (view.id) {
            R.id.btn_calendar -> {
                startActivity(Intent(this@MainActivity, CalendarActivity::class.java))
            }
            R.id.btn_main -> {
                startActivity(Intent(this@MainActivity, TodayActivity::class.java))
            }
            R.id.btn_web_view -> {
                startActivity(Intent(this@MainActivity, WebViewActivity::class.java))
            }
            R.id.btn_lock -> {
                startActivity(Intent(this@MainActivity, LockActivity::class.java))
            }
        }
    }
}