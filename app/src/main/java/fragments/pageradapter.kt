package fragments

import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

class pageradapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)   {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentnameList = ArrayList<String>()





    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {

        return mFragmentList[position]

       /* when(position){

            0 -> return home_frag()
            1 -> return science_frag()
            2 -> return tech_frag()
        }
        return home_frag()*/
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentnameList[position]
    }
    fun  addFragment(fragment: Fragment,title:String){
        mFragmentList.add(fragment)
        mFragmentnameList.add(title)

    }
}