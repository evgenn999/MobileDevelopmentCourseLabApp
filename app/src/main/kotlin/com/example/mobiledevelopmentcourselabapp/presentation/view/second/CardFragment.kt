package com.example.mobiledevelopmentcourselabapp.presentation.view.second

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.PluralsRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentCardBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.StudentUiModel

class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null

    private val binding get() = _binding!!

    private val student by lazy { arguments?.getSerializable(CARD_STUDENT_KEY) as? StudentUiModel }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Обращайся к элементам View здесь
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.card_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareStudentText()
                true
            }

            else -> true
        }
    }

    private fun shareStudentText() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, student.toString())
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        student?.let { student ->
            binding.name.text = student.name
            binding.number.text = student.number.toString()
            binding.ageValue.text = student.age.toString()
            binding.positionValue.text = student.position.rusName
            binding.teamValue.text = student.team

            Glide
                .with(this)
                .load(student.photoUrl)
                .circleCrop()
                .into(binding.icon)

            binding.fiveGrade.text = student.formattedFiveGrade
            binding.fourGrade.text = student.formattedFourGrade
            binding.threeGrade.text = student.formattedThreeGrade
            binding.twoGrade.text = student.formattedTwoGrade
            binding.oneGrade.text = student.formattedOneGrade

        }

    }

    private fun setStat(view: TextView, count: Int, @PluralsRes plural: Int) {
        view.text =
            resources.getString(
                R.string.count_pattern,
                count,
                resources.getQuantityString(plural, count)
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val CARD_STUDENT_KEY = "STUDENT"
    }

}