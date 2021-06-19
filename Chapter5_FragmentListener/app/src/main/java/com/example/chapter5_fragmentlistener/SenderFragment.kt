package com.example.chapter5_fragmentlistener

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.example.chapter5_fragmentlistener.databinding.FragmentSenderBinding

class SenderFragment: Fragment() {

    lateinit var binding: FragmentSenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonYes.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("valueKey", "Yes")
            setFragmentResult("request", bundle)
        }

        binding.buttonNo.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("valueKey", "No")
            setFragmentResult("request", bundle)
        }
    }
}