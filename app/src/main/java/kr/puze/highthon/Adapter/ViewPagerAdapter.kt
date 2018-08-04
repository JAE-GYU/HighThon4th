package kr.puze.highthon.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kr.puze.highthon.Fragment.FeedFragment
import kr.puze.highthon.Fragment.HistoryFragment
import kr.puze.highthon.Fragment.ProfileFragment
import kr.puze.highthon.Fragment.SearchFragment

/**
 * Created by parktaejun on 2018. 1. 21..
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FeedFragment.newInstance()
            1 -> SearchFragment.newInstance()
            2 -> HistoryFragment.newInstance()
            3 -> ProfileFragment.newInstance()
            else -> FeedFragment.newInstance()
        }
    }
    override fun getCount(): Int = 4
}