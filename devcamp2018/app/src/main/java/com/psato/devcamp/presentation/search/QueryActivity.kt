package com.psato.devcamp.presentation.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.psato.devcamp.R
import com.psato.devcamp.infrastructure.bindView

class QueryActivity : AppCompatActivity() {
    val searchButton: Button by bindView(R.id.search_button)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_content, com.psato.devcamp.presentation.search.QueryFragment())
                    .commit()
        }
    }
}
