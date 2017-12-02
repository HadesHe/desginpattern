package com.hzjytech.hades.kedditbystep

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.hzjytech.hades.kedditbystep.fatures.news.NewsFragment

/**
 * Created by Hades on 2017/12/2.
 */
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(NewsFragment())
    }

    private fun changeFragment(fragment: Fragment) {
        val ft=supportFragmentManager.beginTransaction();
        ft.replace(R.id.fl_container,fragment);
        ft.commit();
    }

}