package com.pmdm.ej3practicaexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.pmdm.ej3practicaexam.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*Ponemos los botones*/
        binding.btnLogin.setOnClickListener{
            val action =
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.btnRegistro.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_registroFragment)
        }

        binding.btnSalir.setOnClickListener{
            activity?.finish()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}