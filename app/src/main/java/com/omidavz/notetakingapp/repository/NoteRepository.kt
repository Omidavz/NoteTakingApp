package com.omidavz.notetakingapp.repository

import com.omidavz.notetakingapp.database.NoteDatabase
import com.omidavz.notetakingapp.model.Note

class NoteRepository(private val db: NoteDatabase) {


    suspend fun insertNote(note: Note) =
        db.getNoteDao().insertNote(note)


    suspend fun updateNote(note: Note) =
        db.getNoteDao().updateNote(note)


    suspend fun deleteNote(note: Note) =
        db.getNoteDao().deleteNote(note)


    fun searchNote(query: String) =
        db.getNoteDao().searchNote(query)


    fun getAllNotes() =
        db.getNoteDao().getAllNotes()


}