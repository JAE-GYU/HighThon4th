package kr.puze.highthon.Fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.actionbar_main.view.*
import kotlinx.android.synthetic.main.activity_feed_fragment.view.*
import kr.puze.highthon.Adapter.MainRecyclerViewAdapter
import kr.puze.highthon.Adapter.RecommendRecyclerViewAdapter
import kr.puze.highthon.Data.RecyclerItem
import kr.puze.highthon.R

class FeedFragment : Fragment() {

    var items_top: ArrayList<RecyclerItem> = ArrayList()
    var items_bottom: ArrayList<RecyclerItem> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.activity_feed_fragment, container, false)
        view.actionbar.logo.text = "추천모임"
        val adapter_top = MainRecyclerViewAdapter(items_top, this!!.context!!)
        items_top.add(RecyclerItem("ㅇㅇ", "그냥 산책", "#꿀잠 #제발", "2000.08.05"))
        view.recycler_feed_top.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.recycler_feed_top.adapter = adapter_top
        adapter_top.itemClick = object : MainRecyclerViewAdapter.ItemClick {
            override fun onItemClick(view: View?, position: Int) {
//                startActivity<CreditorDetailActivity>()
            }
        }
        val adapter_bottom = RecommendRecyclerViewAdapter(items_bottom, this!!.context!!)
        items_bottom.add(RecyclerItem("ㅇㅇ", "다시 산책", "#꿀잠 #제발", "2000.08.05"))
        view.recycler_feed_bottom.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.recycler_feed_bottom.adapter = adapter_bottom
        adapter_bottom.itemClick = object : RecommendRecyclerViewAdapter.ItemClick {
            override fun onItemClick(view: View?, position: Int) {
//                startActivity<CreditorDetailActivity>()
            }
        }
        return view
    }

    companion object {
        fun newInstance(): FeedFragment = FeedFragment()
    }
}
