package com.avtocontrol.viewmodelactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.avtocontrol.viewmodelactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /**
     * Подключение viewBinding в Activity
     */
    private lateinit var binding: ActivityMainBinding
    /**
     * Инициализация viewModel
     */
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Продолжение инициализации viewModel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        updateUI()
        binding.btnResult.setOnClickListener {
            okResult()
        }
    }
    //Функуия обновления UI
    private fun updateUI() {
        binding.tv.text = mainViewModel.inText
    }
    //Функция получения результата в tv
    private fun okResult() {
        mainViewModel.inText = binding.etInput.text.toString()
        binding.tv.text = mainViewModel.inText
    }
}