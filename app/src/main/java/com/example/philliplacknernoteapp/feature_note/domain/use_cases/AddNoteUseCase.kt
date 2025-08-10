package com.example.philliplacknernoteapp.feature_note.domain.use_cases

import com.example.philliplacknernoteapp.feature_note.domain.model.InvalidNoteException
import com.example.philliplacknernoteapp.feature_note.domain.model.Note
import com.example.philliplacknernoteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("the title cannot be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("the content cannot be empty.")
        }
        repository.insertNote(note)
    }
}