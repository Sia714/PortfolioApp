package com.example.portfolio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portfolio.model.Certification
import com.google.firebase.firestore.FirebaseFirestore

class CertificationsViewModel : ViewModel() {
    private val _certifications = MutableLiveData<List<Certification>>()
    val certifications: LiveData<List<Certification>> = _certifications

    fun loadCertifications() {
        FirebaseFirestore.getInstance()
            .collection("certifications")
            .get()
            .addOnSuccessListener { result ->
                _certifications.value = result.toObjects(Certification::class.java)
            }
            .addOnFailureListener {
                _certifications.value = emptyList()
            }
    }
}