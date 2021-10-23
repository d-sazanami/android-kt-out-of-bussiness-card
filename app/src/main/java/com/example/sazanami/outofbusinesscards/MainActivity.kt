package com.example.sazanami.outofbusinesscards

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sazanami.outofbusinesscards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        val pref: SharedPreferences = getSharedPreferences(Common.sharedPreferenceName, Context.MODE_PRIVATE)
        val company = pref.getString(Common.prefCompany, "")
        val postal = pref.getString(Common.prefPostal, "")
        val address = pref.getString(Common.prefAddress, "")
        val tel = pref.getString(Common.prefTel, "")
        val fax = pref.getString(Common.prefFax, "")
        val email = pref.getString(Common.prefEmail, "")
        val url = pref.getString(Common.prefUrl, "")
        val position = pref.getString(Common.prefPosition, "")
        val name = pref.getString(Common.prefName, "")

        binding.companyText.text = company
        binding.postalText.text = postal
        binding.addressText.text = address
        binding.telText.text = tel
        binding.faxText.text = fax
        binding.emailText.text = email
        binding.urlText.text = url
        binding.positionText.text = position
        binding.nameText.text = name
    }
}