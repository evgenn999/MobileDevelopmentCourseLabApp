package com.example.mobiledevelopmentcourselabapp.presentation.view.article

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null

    private var score = 0
        set(value) {
            field = value
            _binding?.likeResult?.text = score.toString()
        }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Обращайся к элементам View здесь
        Log.d("Log", "${this::class.simpleName} - onCreateView")
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Log", "${this::class.simpleName} - onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*score = savedInstanceState?.getInt("SCORE") ?: 0*/
        Log.d("Log", "${this::class.simpleName} - onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        score = savedInstanceState?.getInt("SCORE") ?: 0
        context?.let {
            Glide
                .with(it)
                .load("https://studzachet.ru/d2.jpg")
                .placeholder(AppCompatResources.getDrawable(it, R.drawable.baseline_school_24))
                .into(binding.mainPhoto)
        }
        binding.likeBtn.setOnClickListener { score++ }
        binding.dislikeBtn.setOnClickListener { score-- }

        Log.d("Log", "${this::class.simpleName} - onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Log", "${this::class.simpleName} - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Log", "${this::class.simpleName} - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Log", "${this::class.simpleName} - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Log", "${this::class.simpleName} - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Log", "${this::class.simpleName} - onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("Log", "${this::class.simpleName} - onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Log", "${this::class.simpleName} - onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("SCORE", score)
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val SCORE = "SCORE"
    }
}