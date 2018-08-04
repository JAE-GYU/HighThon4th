package kr.puze.highthon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kr.puze.highthon.Adapter.TapLayoutAdapter
import kr.puze.highthon.Adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val tabLayout = TapLayoutAdapter(supportFragmentManager, tab_layout.tabCount)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_feed).setTag("feed"), 0)
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_search).setTag("search"), 1)
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_history).setTag("history"), 2)
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_profile).setTag("profile"), 3)
        tab_layout.tabGravity = TabLayout.GRAVITY_FILL

        main_viewPager.adapter = tabLayout
        main_viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        main_viewPager.adapter = viewPagerAdapter
        main_viewPager.addOnPageChangeListener(viewPageChangeListener)

        tab_layout.setupWithViewPager(main_viewPager)
        initTabLayout()
    }

    private val viewPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            offTabLayout()
            for (index in 0..4) {
                when (index) {
                    0 -> if(index==position)tab_layout.getTabAt(position)!!.setIcon(R.drawable.ic_feed)
                    1 -> if(index==position)tab_layout.getTabAt(position)!!.setIcon(R.drawable.ic_search)
                    2 -> if(index==position)tab_layout.getTabAt(position)!!.setIcon(R.drawable.ic_history)
                    3 -> if(index==position)tab_layout.getTabAt(position)!!.setIcon(R.drawable.ic_profile)
                }
            }
        }
    }

    private fun initTabLayout() : Unit {
        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_feed)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_search_unselected)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_history_unselected)
        tab_layout.getTabAt(3)?.setIcon(R.drawable.ic_profile_unselected)
    }

    fun offTabLayout() : Unit {
        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_feed_unselected)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_search_unselected)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_history_unselected)
        tab_layout.getTabAt(3)?.setIcon(R.drawable.ic_profile_unselected)
    }
}
