package com.example.exaoneagent.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.exaoneagent.databinding.ActivityLoginBinding
import com.example.exaoneagent.ui.main.MainActivity
import com.example.exaoneagent.ui.signup.SignUpActivity // 이 줄이 추가되었습니다.

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        viewModel.loginState.observe(this) { state ->
            when (state) {
                is LoginState.Loading -> {
                    binding.btnLogin.isEnabled = false
                    binding.btnLogin.alpha = 0.6f
                    binding.progressBar.visibility = android.view.View.VISIBLE
                }
                is LoginState.Success -> {
                    binding.progressBar.visibility = android.view.View.GONE
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                    navigateToMain()
                }
                is LoginState.Error -> {
                    binding.btnLogin.isEnabled = true
                    binding.btnLogin.alpha = 1f
                    binding.progressBar.visibility = android.view.View.GONE
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
                is LoginState.Idle -> {
                    binding.btnLogin.isEnabled = true
                    binding.btnLogin.alpha = 1f
                    binding.progressBar.visibility = android.view.View.GONE
                }
            }
        }
    }

    private fun setupListeners() {
        // 로그인 버튼 클릭 시
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            if (validateInput(email, password)) {
                viewModel.login(email, password)
            }
        }

        // 비밀번호 표시/숨기기 토글
        binding.ivPasswordToggle.setOnClickListener {
            togglePasswordVisibility()
        }

        // 회원가입 텍스트 클릭 시 (기존 "준비중" 토스트에서 화면 전환으로 수정)
        // 레이아웃의 ID가 tvForgotPassword로 되어 있으므로 이를 그대로 활용합니다.
        binding.tvForgotPassword.setOnClickListener {
            // 이제 SignUpActivity가 임포트되어 에러가 발생하지 않습니다.
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible

        if (isPasswordVisible) {
            binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
            binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        // 커서를 텍스트 끝으로 이동하여 사용자 경험 개선
        binding.etPassword.setSelection(binding.etPassword.text?.length ?: 0)
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
            binding.etEmail.requestFocus()
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "올바른 이메일 형식을 입력해주세요", Toast.LENGTH_SHORT).show()
            binding.etEmail.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            binding.etPassword.requestFocus()
            return false
        }

        return true
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}