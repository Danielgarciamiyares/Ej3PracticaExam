package com.pmdm.ej3practicaexam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.fragment.findNavController
import com.pmdm.ej3practicaexam.databinding.FragmentLoginBinding
data class usuarios(val name: String, val country: String)

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragmentManager.setFragmentResultListener("key",this, FragmentResultListener {
                requestKey, result ->

            val name:String=result.getString("user")!!
            val password:String=result.getString("password")!!
            userPassword[name] = password
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentLoginBinding.inflate(inflater,container,false)
        return(binding.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnlogin.setOnClickListener{
            if(binding.username.text.isNotBlank() && binding.password.text.isNotBlank()){
                binding.msjError.text = "Hay valores"
                val user=binding.username.text.toString()
                val password=binding.password.text.toString()
                /*si la contraseña coincide con la contraseña en la clave usuario*/
                if(userPassword[user]==password){
                    findNavController().navigate(R.id.action_loginFragment_to_citasFragment)
                }
                else{
                    binding.msjError.text="Usuario o contraseña incorrectos"
                }

            }
            else{
                binding.msjError.text = "Tanto usuario como contraseña deben tener valores, introdúzcalos"
            }
        }
        binding.btnvolver.setOnClickListener{
            /*Quita el último objeto de la pila*/
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }




    companion object{




        val userPassword:MutableMap<String,String> =
            mutableMapOf ("Adrian" to "adri","Luis" to "luis")
    //     =listOf(
   //         usuarios("Adrian","adri"),
  //          usuarios("Luis","luis")
  //      ).map { it.name ; it.country }

 //               =mapOf<String,String>("Adrian" to "adri","Luis" to "luis","" to "")
    }



}