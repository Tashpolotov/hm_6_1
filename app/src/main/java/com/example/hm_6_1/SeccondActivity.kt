package com.example.hm_6_1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hm_6_1.MainActivity.Companion.DATA_KEY
import com.example.hm_6_1.databinding.ActivitySeccondBinding

class SeccondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeccondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeccondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() = with(binding) {
        et.setText(intent.getStringExtra(DATA_KEY))
        btn.setOnClickListener {
            setResult(
                RESULT_OK,Intent().putExtra(
                    DATA_KEY, et.text.toString()
                )
            )
            finish()

        }

    }
}
