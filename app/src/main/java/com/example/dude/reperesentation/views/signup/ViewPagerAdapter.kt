package com.example.dude.reperesentation.views.signup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    list :ArrayList<Fragment>,
    fragment :FragmentManager,
    lifecycle: Lifecycle) :FragmentStateAdapter(fragment,lifecycle) {
    private val  arrayList :ArrayList<Fragment> =list
    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun createFragment(position: Int): Fragment {
       return arrayList[position]
    }

}