package com.example.sazanami.outofbusinesscards

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sazanami.outofbusinesscards.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pref: SharedPreferences = getSharedPreferences(
            Common.sharedPreferenceName,
            Context.MODE_PRIVATE
        )
        val company = pref.getString(Common.prefCompany, "")
        val postal = pref.getString(Common.prefPostal, "")
        val address= pref.getString(Common.prefAddress, "")
        val tel = pref.getString(Common.prefTel, "")
        val fax = pref.getString(Common.prefFax, "")
        val email = pref.getString(Common.prefEmail, "")
        val url = pref.getString(Common.prefUrl, "")
        val position = pref.getString(Common.prefPosition, "")
        val name = pref.getString(Common.prefName, "")

        binding.companyEdit.setText(company)
        binding.postalEdit.setText(postal)
        binding.addressEdit.setText(address)
        binding.telEdit.setText(tel)
        binding.faxEdit.setText(fax)
        binding.emailEdit.setText(email)
        binding.urlEdit.setText(url)
        binding.positionEdit.setText(position)
        binding.nameEdit.setText(name)

        binding.saveBtn.setOnClickListener {
            saveData()
            finish()
        }

        binding.cancelBtn.setOnClickListener {
            finish()
        }
    }

    private fun saveData() {
        val pref = getSharedPreferences(Common.sharedPreferenceName, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(Common.prefCompany, binding.companyEdit.text.toString())
            .putString(Common.prefPostal, binding.postalEdit.text.toString())
            .putString(Common.prefAddress, binding.addressEdit.text.toString())
            .putString(Common.prefTel, binding.telEdit.text.toString())
            .putString(Common.prefFax, binding.faxEdit.text.toString())
            .putString(Common.prefEmail, binding.emailEdit.text.toString())
            .putString(Common.prefUrl, binding.urlEdit.text.toString())
            .putString(Common.prefPosition, binding.positionEdit.text.toString())
            .putString(Common.prefName, binding.nameEdit.text.toString())
            .apply()
    }
}