package com.pmdm.ej3practicaexam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pmdm.ej3practicaexam.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {
    private var _binding: FragmentRegistroBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentRegistroBinding.inflate(inflater,container,false)
        return(binding.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnlogin.setOnClickListener{
            var bundle:Bundle= Bundle()
            bundle.putString("user",binding.username.text.toString())
            bundle.putString("password",binding.password.text.toString())
            bundle.putString("mail",binding.correo.text.toString())
            parentFragmentManager.setFragmentResult("key",bundle)

            findNavController().navigate(R.id.action_registroFragment_to_loginFragment2)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}