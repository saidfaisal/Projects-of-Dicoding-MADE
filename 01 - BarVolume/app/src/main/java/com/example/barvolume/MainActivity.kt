package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null) {
            tvResult.text = savedInstanceState.getString(STATE_RESULT) as String
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_calculate -> {
                val inputWidth = edtWidth.text.toString()
                val inputHeight = edtHeight.text.toString()
                val inputLength = edtLength.text.toString()

                var isEmptyFields = false
                if(inputWidth.isEmpty()) {
                    isEmptyFields = true
                    edtWidth.error = "Field ini harus diisi"
                }

                if(inputHeight.isEmpty()) {
                    isEmptyFields = true
                    edtHeight.error = "Field ini harus diisi"
                }

                if(inputLength.isEmpty()) {
                    isEmptyFields = true
                    edtLength.error = "Field ini harus diisi"
                }

                if(!isEmptyFields) {
                    val result = inputWidth.toDouble() * inputHeight.toDouble() * inputLength.toDouble()
                    tvResult.text = result.toString()
                }
            }
        }
    }
}
