package com.example.roomsqlnavigation.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomsqlnavigation.REPOSITORY
import com.example.roomsqlnavigation.db.NoteDataBase
import com.example.roomsqlnavigation.db.repository.NoteRealization
import com.example.roomsqlnavigation.model.NoteModel

class StartViewModel(application: Application):AndroidViewModel(application) {
    val context=application

    fun initDataBase(){
        val daoNote=NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY=NoteRealization(daoNote)
    }
    fun getAllNotes():LiveData<List<NoteModel>>{
        return REPOSITORY.allNote

    }
}