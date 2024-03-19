package com.example.mobiledevelopmentcourselabapp.presentation.view.second

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentListBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter.PlayerAdapter
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.generator.Generator

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    private val adapter by lazy {PlayerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        Log.d("Log","${this::class.simpleName} - onCreateView")
        // Обращайся к элементам View здесь
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playersList.adapter = adapter
        adapter.updateItems(Generator.generate())

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Log","${this::class.simpleName} - onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Log","${this::class.simpleName} - onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("Log","${this::class.simpleName} - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Log","${this::class.simpleName} - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Log","${this::class.simpleName} - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Log","${this::class.simpleName} - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Log","${this::class.simpleName} - onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("Log","${this::class.simpleName} - onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Log","${this::class.simpleName} - onDetach")
    }
}