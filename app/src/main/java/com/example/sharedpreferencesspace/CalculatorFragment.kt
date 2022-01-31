package com.example.sharedpreferencesspace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferencesspace.AppContext.Companion.prefs
import com.example.sharedpreferencesspace.databinding.FragmentCalculatorBinding
import com.example.sharedpreferencesspace.databinding.FragmentLoginBinding



class CalculatorFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding?=null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentCalculatorBinding.inflate(inflater,container,false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retoreState()
        setListenereMinusButton()
        setListenerPlusButton()

    }

    private fun setListenerPlusButton() {
        binding.buttonPlus.setOnClickListener {
            with(binding){
                if (editTextNumber1.text.isNotEmpty()&&editTextNumber2.text.isNotEmpty()){
                    sumTextView.text=(editTextNumber1.text.toString().toInt() + editTextNumber2.text.toString().toInt()).toString()
                    prefs.saveCalculatorAnswer(sumTextView.text.toString().toInt())
                }else{
                    Toast.makeText(requireContext(), "Fill Gaps", Toast.LENGTH_SHORT).show()
                }

            }
        }    }

    private fun retoreState() {
        binding.sumTextView.text= prefs.getCalculatorAnswer().toString()
    }

    private fun setListenereMinusButton() {

        binding.buttonMinus.setOnClickListener {
            with(binding){
                if (editTextNumber1.text.isNotEmpty()&&editTextNumber2.text.isNotEmpty()){
                    sumTextView.text=(editTextNumber1.text.toString().toInt()-editTextNumber2.text.toString().toInt()).toString()
                    prefs.saveCalculatorAnswer(sumTextView.text.toString().toInt())
                }else{
                    Toast.makeText(requireContext(), "Fill Gaps", Toast.LENGTH_SHORT).show()

                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
    private fun setLogOutListener() {
        binding.logOutbutton.setOnClickListener {
            prefs.deleteAll()
            findNavController().navigate(R.id.action_calculatorFragment_to_registerFragment)
        }
    }


}