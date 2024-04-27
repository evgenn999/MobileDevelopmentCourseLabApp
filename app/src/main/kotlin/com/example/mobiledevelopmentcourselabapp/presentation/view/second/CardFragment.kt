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

    private val Student by lazy { arguments?.getSerializable(CARD_STUDENT_KEY) as? StudentUiModel }

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
            putExtra(Intent.EXTRA_TEXT, Student.toString())
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        Student?.let { Student ->
            binding.name.text = Student.name
            binding.number.text = Student.number.toString()

            setStat(binding.ageValue, Student.age, R.plurals.age)
            binding.positionValue.text = Student.position.rusName
            binding.teamValue.text = Student.team

            Glide
                .with(this)
                .load(Student.photoUrl)
                .circleCrop()
                .into(binding.icon)

            setStat(binding.fiveGrade, Student.fiveGrade, R.plurals.games)
            setStat(binding.fourGrade, Student.fourGrade, R.plurals.goals)
            setStat(binding.threeGrade, Student.threeGrade, R.plurals.assists)
            setStat(binding.twoGrade, Student.twoGrade, R.plurals.yellows)
            setStat(binding.oneGrade, Student.oneGrade, R.plurals.reds)

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