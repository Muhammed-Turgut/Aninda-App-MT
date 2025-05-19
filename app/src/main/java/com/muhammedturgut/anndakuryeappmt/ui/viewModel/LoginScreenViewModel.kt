package com.muhammedturgut.anndakuryeappmt.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedturgut.anndakuryeappmt.data.entity.User
import com.muhammedturgut.anndakuryeappmt.data.repo.SaveRepostiory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val userRepository: SaveRepostiory
) : ViewModel() {

    // Kullanıcıyı gözlemlemek için LiveData
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    // Kayıt sonucu durumu
    private val _registerResult = MutableLiveData<Boolean>()
    val registerResult: LiveData<Boolean> get() = _registerResult

    init {
        loadUser()
    }

    // Room'dan kullanıcıyı çek
     fun loadUser() {
        viewModelScope.launch {
            _user.value = userRepository.getUserOrNull()
        }
    }

    // Kullanıcı silme
    fun delete(userId: Int) {
        viewModelScope.launch {
            userRepository.signOut(userId)
            loadUser()
        }
    }

    // Yeni kullanıcı kaydetme
    fun save(userName: String, userEmail: String, userPassword: String) {
        viewModelScope.launch {
            try {
                userRepository.save(userName, userEmail, userPassword)
                loadUser()
                _registerResult.value = true
            } catch (e: Exception) {
                _registerResult.value = false
            }
        }
    }

    // Kullanıcı güncelleme
    fun update(id: Int, userName: String, userEmail: String, userPassword: String) {
        viewModelScope.launch {
            userRepository.update(id, userName, userEmail, userPassword)
            loadUser()
        }
    }
}
