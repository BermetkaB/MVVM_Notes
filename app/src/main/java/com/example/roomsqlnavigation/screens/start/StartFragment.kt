package com.example.roomsqlnavigation.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomsqlnavigation.APP
import com.example.roomsqlnavigation.R
import com.example.roomsqlnavigation.adapter.NoteAdapter
import com.example.roomsqlnavigation.databinding.ActivityMainBinding
import com.example.roomsqlnavigation.databinding.FragmentStartBinding


class StartFragment : Fragment() {

lateinit var binding: FragmentStartBinding
lateinit var recyclerView: RecyclerView
lateinit var adapter: NoteAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


private  fun init(){
    val viewModel=ViewModelProvider(this).get(StartViewModel::class.java)
    viewModel.initDataBase()
    recyclerView=binding.rvNotes
    adapter= NoteAdapter()
    recyclerView.adapter=adapter
    viewModel.getAllNotes().observe(viewLifecycleOwner,{listNotes -> listNotes.asReversed()
    adapter.setList(listNotes)
    })

    binding.btnClick.setOnClickListener {
        APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
    }
}

}