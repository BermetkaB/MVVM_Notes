package com.example.roomsqlnavigation.db.repository

import androidx.lifecycle.LiveData
import com.example.roomsqlnavigation.model.NoteModel

interface NoteRepository {
    val allNote:LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel,onSuccess:()->Unit)
    suspend fun deleteNote(noteModel: NoteModel,onSuccess:()->Unit)
}