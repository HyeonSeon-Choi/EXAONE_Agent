package com.example.exaoneagent.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.exaoneagent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupCardClickListeners()
        observeViewModel()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "EXAONE AI Agent"
            setDisplayHomeAsUpEnabled(false)
        }
    }

    private fun setupCardClickListeners() {
        // NL-to-SQL 카드
        binding.cardNlToSql.setOnClickListener {
            Toast.makeText(
                this,
                "NL-to-SQL 조회 기능을 시작합니다",
                Toast.LENGTH_SHORT
            ).show()
            // TODO: NL-to-SQL 화면으로 이동
        }

        // 자동 리포팅 카드
        binding.cardAutoReport.setOnClickListener {
            Toast.makeText(
                this,
                "자동 리포팅 & 요약 기능을 시작합니다",
                Toast.LENGTH_SHORT
            ).show()
            // TODO: 리포팅 화면으로 이동
        }

        // Voice Interface 카드
        binding.cardVoice.setOnClickListener {
            Toast.makeText(
                this,
                "Voice Interface 기능을 시작합니다",
                Toast.LENGTH_SHORT
            ).show()
            // TODO: 음성 인터페이스 화면으로 이동
        }
    }

    private fun observeViewModel() {
        viewModel.messages.observe(this) { messages ->
            // TODO: RecyclerView 어댑터 업데이트
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) {
                android.view.View.VISIBLE
            } else {
                android.view.View.GONE
            }
        }
    }
}
