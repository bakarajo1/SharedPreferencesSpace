package com.example.sharedpreferencesspace

import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferencesspace.AppContext.Companion.prefs
import com.example.sharedpreferencesspace.databinding.UserFragmentBinding

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }
    private var _binding: UserFragmentBinding?=null
    private val binding
        get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= UserFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.switch1.isChecked= prefs.getSwitchState()

        setListeners()


    }

    private fun setListeners() {

        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->  prefs.saveSwitchState(b) }

        binding.showButton.setOnClickListener{
            if (binding.editTextTextPersonName.text.isNotEmpty()&& binding.editTextTextPersonSurname.text.isNotEmpty()){
            prefs.saveName(binding.editTextTextPersonName.text.toString())
            prefs.saveSurname(binding.editTextTextPersonSurname.text.toString())
            binding.nameTextView.text= prefs.getName()
            binding.surnameTextView.text= prefs.getSurname()
        }else{
            //toast
                Toast.makeText(requireContext(), "Fill Fields", Toast.LENGTH_SHORT).show()
        }}
        binding.deleteButton.setOnClickListener {
            prefs.deleteAll()
            binding.nameTextView.text= prefs.getName()
            binding.surnameTextView.text= prefs.getSurname()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}