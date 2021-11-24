package com.skai7ami.runtimethemeselector.custom_views

import android.content.Context
import android.content.res.Configuration
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.skai7ami.runtimethemeselector.R
import com.skai7ami.runtimethemeselector.databinding.ResThemeSelectorBinding

class ThemeSelector @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    private val binding = ResThemeSelectorBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        //gets the current theme
        val uiMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        //checks if night mode is active using uiMode information
        val isNightMode: Boolean = when (uiMode) {
            Configuration.UI_MODE_NIGHT_YES -> true
            Configuration.UI_MODE_NIGHT_NO -> false
            else -> false
        }

        //sets the button image according to the context theme
        binding.imageView.setImageResource(
            if (isNightMode) {
                R.drawable.ic_round_nights_stay_24
            } else {
                R.drawable.ic_round_wb_sunny_24
            }
        )

        //it changes the button click, if the theme is night the button click will allow you to activate light theme
        binding.imageView.setOnClickListener {
            if (isNightMode) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                Toast.makeText(context, "Modo claro ativado", Toast.LENGTH_SHORT).show()
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                Toast.makeText(context, "Modo escuro ativado", Toast.LENGTH_SHORT).show()
            }
        }
    }

}