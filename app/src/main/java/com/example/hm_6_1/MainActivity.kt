package com.example.hm_6_1
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hm_6_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() = with(binding) {
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.et.setText(result.data?.getStringExtra(DATA_KEY))
            }
        }
        et.setText(intent.getStringExtra(DATA_KEY))
        btn.setOnClickListener {
            if (et.text.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SeccondActivity::class.java)
                intent.putExtra(DATA_KEY, et.text.toString())
                result.launch(intent)

            } else {
                Toast.makeText(this@MainActivity, "text empty", Toast.LENGTH_SHORT).show()
            }
        }

    }
    companion object {
        const val DATA_KEY = "data"
    }
}