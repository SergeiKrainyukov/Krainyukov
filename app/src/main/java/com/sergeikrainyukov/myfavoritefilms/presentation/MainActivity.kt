package com.sergeikrainyukov.myfavoritefilms.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sergeikrainyukov.myfavoritefilms.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFilmsFragment()
    }

    private fun openFilmsFragment() {
        Navigator.navigateReplace(FilmsListFragment(), supportFragmentManager)
    }
}