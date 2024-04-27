package com.example.mobiledevelopmentcourselabapp.presentation.view.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentListBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter.StudentsAdapter
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.generator.Generator
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.StudentUiModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    private val adapter by lazy { StudentsAdapter(::onPlayerClicked) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Обращайся к элементам View здесь
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.StudentsList.adapter = adapter
        adapter.updateItems(Generator.generate())
    }

    private fun onPlayerClicked(Student: StudentUiModel) {
        val bundle = bundleOf(CardFragment.CARD_STUDENT_KEY to Student)
        view?.findNavController()?.navigate(R.id.action_navigation_list_to_cardFragment, bundle)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}