package com.omidavz.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidavz.notetakingapp.model.Note
import com.omidavz.notetakingapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val repository: NoteRepository) :
    AndroidViewModel(app) {

    fun addNote(note: Note) =
        viewModelScope.launch {
            repository.insertNote(note)
        }

    fun updateNote(note: Note) =
        viewModelScope.launch {
            repository.updateNote(note)
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            repository.deleteNote(note)
        }

    fun searchNote(query: String) = repository.searchNote(query)

    fun getAllNotes() = repository.getAllNotes()


}