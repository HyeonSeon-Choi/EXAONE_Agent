package com.example.exaoneagent.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class SignUpState {
    object Idle : SignUpState()
    object Loading : SignUpState()
    data class Success(val message: String) : SignUpState()
    data class Error(val message: String) : SignUpState()
}

class SignUpViewModel : ViewModel() {
    private val _signUpState = MutableLiveData<SignUpState>(SignUpState.Idle)
    val signUpState: LiveData<SignUpState> = _signUpState

    fun signUp(id: String, name: String, pw: String, dept: String, position: String) {
        viewModelScope.launch {
            _signUpState.value = SignUpState.Loading

            // 실제 API 호출 대신 1.5초 지연 (Mock)
            delay(1500)

            // 성공 시나리오
            _signUpState.value = SignUpState.Success("회원가입 신청이 완료되었습니다. 관리자 승인을 기다려주세요.")
        }
    }
}