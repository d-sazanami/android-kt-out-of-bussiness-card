package com.example.sazanami.outofbusinesscards

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sazanami.outofbusinesscards.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private val sharedPreferenceName = "BussinessCard"

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pref: SharedPreferences = getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE)
        val company = pref.getString("company", "")
        val postal = pref.getString("postal", "")
        val address= pref.getString("address", "")
        val tel = pref.getString("tel", "")
        val fax = pref.getString("fax", "")
        val email = pref.getString("email", "")
        val url = pref.getString("url", "")
        val position = pref.getString("position", "")
        val name = pref.getString("name", "")

        binding.companyEdit.setText(company)
        binding.postalEdit.setText(postal)
        binding.addressEdit.setText(address)
        binding.telEdit.setText(tel)
        binding.faxEdit.setText(fax)
        binding.emailEdit.setText(email)
        binding.urlEdit.setText(url)
        binding.positionEdit.setText(position)
        binding.nameEdit.setText(name)

        binding.saveBtn.setOnClickListener() {
            saveData()
            finish()
        }

        binding.cancelBtn.setOnClickListener() {
            finish()
        }
    }

    private fun saveData() {
        val pref = getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("company", binding.companyEdit.text.toString())
            .putString("postal", binding.postalEdit.text.toString())
            .putString("address", binding.addressEdit.text.toString())
            .putString("tel", binding.telEdit.text.toString())
            .putString("fax", binding.faxEdit.text.toString())
            .putString("email", binding.emailEdit.text.toString())
            .putString("url", binding.urlEdit.text.toString())
            .putString("position", binding.positionEdit.text.toString())
            .putString("name", binding.nameEdit.text.toString())
            .apply()
    }
}