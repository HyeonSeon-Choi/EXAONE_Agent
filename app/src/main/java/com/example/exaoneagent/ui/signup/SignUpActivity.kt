package com.example.exaoneagent.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exaoneagent.databinding.ActivitySignUpBinding
import com.example.exaoneagent.ui.login.LoginActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDropdownMenus()
        setupListeners()
    }

    private fun setupDropdownMenus() {
        // 부서 목록 데이터
        val departments = arrayOf("AI 연구소", "경영지원팀", "플랫폼개발팀", "영업본부", "기획팀")
        val deptAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, departments)
        binding.spinnerDept.setAdapter(deptAdapter)

        // 직급 목록 데이터
        val positions = arrayOf("사원", "대리", "과장", "차장", "부장", "이사")
        val posAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, positions)
        binding.spinnerPosition.setAdapter(posAdapter)
    }

    private fun setupListeners() {
        // 돌아가기 버튼
        binding.tvBack.setOnClickListener {
            finish()
        }

        // 로그인하기 링크
        binding.tvLoginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        // 가입 완료 버튼 클릭 시
        binding.btnSignUp.setOnClickListener {
            handleSignUp()
        }
    }

    private fun handleSignUp() {
        val id = binding.etId.text.toString().trim()
        val name = binding.etName.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val dept = binding.spinnerDept.text.toString()
        val pos = binding.spinnerPosition.text.toString()

        // 유효성 검사
        if (id.isEmpty() || name.isEmpty() || password.isEmpty() || dept.isEmpty() || pos.isEmpty()) {
            Toast.makeText(this, "모든 정보를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.length < 8) {
            Toast.makeText(this, "비밀번호는 8자 이상이어야 합니다.", Toast.LENGTH_SHORT).show()
            return
        }

        // 백엔드 연동을 위한 데이터 전달 (현재는 로그 및 메시지만 표시)
        // TODO: 다른 팀원의 백엔드 API와 연동
        val signUpMessage = "사번: $id\n이름: $name\n부서: $dept\n직급: $pos\n회원가입 요청이 전송되었습니다."
        Toast.makeText(this, signUpMessage, Toast.LENGTH_LONG).show()

        // 가입 요청 후 메인 또는 로그인 화면으로 이동
        finish()
    }
}