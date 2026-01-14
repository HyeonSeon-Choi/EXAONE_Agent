package com.example.exaoneagent.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.exaoneagent.databinding.ActivityLoginBinding
import com.example.exaoneagent.ui.main.MainActivity

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
        // 로그인 버튼
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            if (validateInput(email, password)) {
                viewModel.login(email, password)
            }
        }

        // 패스워드 토글
        binding.ivPasswordToggle.setOnClickListener {
            togglePasswordVisibility()
        }

        // 회원가입 텍스트
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "회원가입 기능은 준비중입니다", Toast.LENGTH_SHORT).show()
        }
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible

        if (isPasswordVisible) {
            binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
            binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        // 커서를 텍스트 끝으로 이동
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
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}