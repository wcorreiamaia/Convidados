package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.model.GuestModel
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewModel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var biding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(biding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)


        biding.btSave.setOnClickListener(this)
        biding.rbPresent.isChecked = true
    }

    override fun onClick(v: View) {
        if (v.id == R.id.bt_save){
            //convertendo o texto
            val name = biding.etName.text.toString()
            val presence = biding.rbPresent.isChecked

            val model = GuestModel(0, name, presence)
            viewModel.insert(model)

        }
    }
}