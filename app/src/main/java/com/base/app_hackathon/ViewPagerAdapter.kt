package com.base.app_hackathon

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Relatos_Fragment()
            1 -> MapaFragment()
            2 -> BibliotecaFragment()
            3 -> BibliotecaFragment()
            4 -> JuegosFragment()
            else -> Relatos_Fragment()
        }
    }

}