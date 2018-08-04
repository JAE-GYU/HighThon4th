package kr.puze.highthon.Adapter

import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import kr.puze.highthon.Fragment.FeedFragment
import kr.puze.highthon.Fragment.HistoryFragment
import kr.puze.highthon.Fragment.SearchFragment


/**
 * Created by parktaejun on 2018. 1. 21..
 */
class TapLayoutAdapter(fm: FragmentManager, private val tapCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return FeedFragment()
                tapCount = position
            }
            1 -> {
                return SearchFragment()
                tapCount = position
            }
            2 -> {
                return HistoryFragment()
                tapCount = position
            }
            3 -> {
                return SearchFragment()
                tapCount = position
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tapCount
    }
}