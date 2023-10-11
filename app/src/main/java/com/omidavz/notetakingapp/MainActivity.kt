package com.omidavz.notetakingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import com.omidavz.notetakingapp.database.NoteDatabase
import com.omidavz.notetakingapp.databinding.ActivityMainBinding
import com.omidavz.notetakingapp.repository.NoteRepository
import com.omidavz.notetakingapp.viewmodel.NoteViewModel
import com.omidavz.notetakingapp.viewmodel.NoteViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()

    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val factory = NoteViewModelFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)
    }


}