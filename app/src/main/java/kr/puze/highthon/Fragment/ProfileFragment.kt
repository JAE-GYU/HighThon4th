package kr.puze.highthon.Fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.actionbar_main.view.*
import kotlinx.android.synthetic.main.activity_profile_fragment.view.*
import kr.puze.highthon.Adapter.RecommendRecyclerViewAdapter
import kr.puze.highthon.Data.RecyclerItem
import kr.puze.highthon.R

class ProfileFragment : Fragment() {

    var items: ArrayList<RecyclerItem> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.activity_profile_fragment, container, false)
        view.actionbar.logo.text = "프로필"
        val adapter = RecommendRecyclerViewAdapter(items, this!!.context!!)
        items.add(RecyclerItem("ㅇㅇ", "그냥 산책", "#꿀잠 #제발", "2000.08.05"))
        view.recycler_profile.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.recycler_profile.adapter = adapter
        adapter.itemClick = object : RecommendRecyclerViewAdapter.ItemClick {
            override fun onItemClick(view: View?, position: Int) {
//                startActivity<CreditorDetailActivity>()
            }
        }
        return view
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
}
