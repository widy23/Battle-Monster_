package com.example.dude.reperesentation.views.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dude.databinding.FragmentUsernameBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class UsernameFragment : Fragment() {

    private lateinit var binding: FragmentUsernameBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUsernameBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.)
//        }
    }

}