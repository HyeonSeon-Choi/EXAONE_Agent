package com.example.exaoneagent.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<LoginState>(LoginState.Idle)
    val loginState: LiveData<LoginState> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                _loginState.value = LoginState.Loading

                // 시뮬레이션: 네트워크 호출 대기
                delay(1500)

                // 간단한 검증 (실제로는 API 호출)
                if (email == "test@test.com" && password == "1234") {
                    _loginState.value = LoginState.Success("로그인 성공")
                } else {
                    _loginState.value = LoginState.Error("이메일 또는 비밀번호가 잘못되었습니다")
                }

            } catch (e: Exception) {
                _loginState.value = LoginState.Error(
                    e.message ?: "로그인 중 오류가 발생했습니다"
                )
            }
        }
    }
}
