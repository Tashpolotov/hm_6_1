package com.example.hm_6_1
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
        binding.et.setText(intent.getStringExtra("go"))
        btn.setOnClickListener {
            if (et.text.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SeccondActivity::class.java)
                intent.putExtra("go", binding.et.text.toString())
                result.launch(intent)

            } else {
                Toast.makeText(this@MainActivity, "Edit text empty", Toast.LENGTH_SHORT).show()
            }
        }
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            }
    }
}