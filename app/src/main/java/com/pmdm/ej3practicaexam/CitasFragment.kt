package com.pmdm.ej3practicaexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmdm.ej3practicaexam.adapter.RecyclerCitasAdater
import com.pmdm.ej3practicaexam.data.CitasSource
import com.pmdm.ej3practicaexam.databinding.FragmentCitasBinding

class CitasFragment : Fragment() {
    private var _binding: FragmentCitasBinding?=null
    private val binding get()=_binding!!
    private val args: CitasFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentCitasBinding.inflate(inflater,container,false)
        return(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setearTextoTitulo()
        inicializarRecycler()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    private fun setearTextoTitulo(){
        binding.tvTituloCitas.text=getString(R.string.fragment_citas_title)
    }

    private fun inicializarRecycler(){
        binding.recyclerCitas.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.recyclerCitas.adapter=RecyclerCitasAdater(CitasSource.citasRandom)
    }
}