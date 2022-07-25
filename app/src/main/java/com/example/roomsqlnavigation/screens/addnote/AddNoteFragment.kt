package com.example.roomsqlnavigation.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomsqlnavigation.APP
import com.example.roomsqlnavigation.R
import com.example.roomsqlnavigation.databinding.FragmentAddNoteBinding


class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unitAdd()
    }


    private fun unitAdd(){
        val viewModel = viewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnDetailBack.setOnClickListener {
            viewModel.insert()
        }
        binding.btnDetailBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }
}