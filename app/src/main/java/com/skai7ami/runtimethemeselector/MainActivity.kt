package com.skai7ami.runtimethemeselector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skai7ami.runtimethemeselector.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainViewBinding.root)
    }
}