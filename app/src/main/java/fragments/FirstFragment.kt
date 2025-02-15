package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.ActivityFragmentBinding
import com.example.myapplication.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), firstInterface {
    lateinit var binding: FragmentFirstBinding
    lateinit var fragmentActivity: FragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       fragmentActivity= activity as FragmentActivity
        fragmentActivity.firstInterface=this
        arguments?.let{}
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?)
    : View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.fragButton1.setOnClickListener {
            fragmentActivity.createColor()
        }
        binding.btnSave.setOnClickListener {
         if(binding.etName.text.toString().isEmpty()){
             binding.etName.error  = " give some input"
         }else{
             fragmentActivity.createFun2(binding.etName.text.toString())
         }
        }
        return binding.root
    }

    override fun addText(txt: String) {
        binding.etName.setText(txt)
    }
}
