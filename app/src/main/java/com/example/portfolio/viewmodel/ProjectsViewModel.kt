package com.example.portfolio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portfolio.model.Project
import com.google.firebase.firestore.FirebaseFirestore

class ProjectsViewModel : ViewModel() {
    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>> = _projects

    fun loadProjects() {
        FirebaseFirestore.getInstance()
            .collection("projects")
            .get()
            .addOnSuccessListener { result ->
                _projects.value = result.toObjects(Project::class.java)
            }
            .addOnFailureListener {
                _projects.value = emptyList()
            }
    }
}
