package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //lateinit=late initialise
    private lateinit var binding: ActivityMainBinding
    //Create an instance of the contact class
    private var myContact: Contact = Contact("See", "1234")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.contact = myContact

        binding.buttonDone.setOnClickListener {
            updateName()
        }
    }

    fun updateName() {
        //apply=multiple setter on a single object
        binding.apply {
            contact?.name = editTextName.text.toString()
            this.invalidateAll()
        }

    }

}
