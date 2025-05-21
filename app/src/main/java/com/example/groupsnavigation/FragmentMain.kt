package com.example.groupsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.groupsnavigation.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMain.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMain : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRP1.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentRP1)
        }
        binding.btnRP2.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentRP2)
        }
        binding.btnRP3.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentRP3)
        }
    }
}