package com.example.hw1_4.ui.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.hw1_4.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    val mGetContent: ActivityResultLauncher<String> =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->
            binding.ivProfile.setImageURI(uri)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(LayoutInflater.from(context), container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.ivProfile.setOnClickListener{
            mGetContent.launch("image/*");
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}