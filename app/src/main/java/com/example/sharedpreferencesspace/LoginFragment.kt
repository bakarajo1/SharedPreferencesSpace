package com.example.sharedpreferencesspace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferencesspace.AppContext.Companion.prefs
import com.example.sharedpreferencesspace.databinding.FragmentLoginBinding
import com.example.sharedpreferencesspace.databinding.RegisterFragmentBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {

        binding.buttonLogIn.setOnClickListener {
            if (binding.editTextUserName.text.isNotEmpty()&& binding.editTextPassword.text.isNotEmpty()){
                if(checkUser()){
                    prefs.saveSwitchState(true)
                    findNavController().navigate(R.id.action_loginFragment_to_calculatorFragment)

                }else{
                    Toast.makeText(requireContext(), "User Not Found", Toast.LENGTH_SHORT).show()


                }

            }else{
                //toast
                Toast.makeText(requireContext(), "Fill Fields", Toast.LENGTH_SHORT).show()
            }}
        }

    private fun checkUser(): Boolean {

        return if (binding.editTextUserName.text.toString()==prefs.getName()){
            binding.editTextPassword.text.toString()== prefs.getSurname()
        }else{
            false
        }
}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}