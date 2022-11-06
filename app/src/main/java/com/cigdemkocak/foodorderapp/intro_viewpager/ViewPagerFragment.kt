package com.cigdemkocak.foodorderapp.intro_viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.intro_viewpager.screens.FirstScreen
import com.cigdemkocak.foodorderapp.intro_viewpager.screens.SecondScreen
import com.cigdemkocak.foodorderapp.intro_viewpager.screens.ThirdScreen
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        view.imageSlider.adapter = adapter

        return view
    }

}