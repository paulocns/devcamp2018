package com.psato.devcamp.presentation.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.psato.devcamp.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_content, HomeFragment())
                    .commit()
        }
    }
}
