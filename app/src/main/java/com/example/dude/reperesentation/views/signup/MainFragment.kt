package com.example.dude.reperesentation.views.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dude.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var biding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        biding= FragmentMainBinding.inflate(layoutInflater, container, false)
        setUpFragmentView()
        return biding.root
    }

    private fun setUpFragmentView() {
        val fragmentList = arrayListOf<Fragment>(
            GenderFragment(),
            UsernameFragment(),
            DecksFragment()
        )
        val adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
        biding.signupViewPager.adapter=adapter
    }

}