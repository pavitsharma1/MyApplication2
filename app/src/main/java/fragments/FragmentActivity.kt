package fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFragmentBinding
import com.example.myapplication.databinding.FragmentFirstBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentBinding
    lateinit var firstInterface: firstInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    binding.btnSaveReverse.setOnClickListener {
        if (
            binding.fraget1.text.toString().isEmpty()){
                binding.fraget1.error="give some value"

            }
        else{
             firstInterface.addText(binding.fraget1.text.toString())
        }

    }
    }

    fun createColor(){
        binding.main.setBackgroundColor(resources.getColor(R.color.black))
    }
    fun createFun2(t:String){
       binding.fraget1.setText(t)
    }
}