package pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters

import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentNavigation
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IMainActivityVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.FragmentOne
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.FragmentScheduled
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.MainActivity
import java.lang.ClassCastException

class MainActivityPresenter(var mainView: MainActivity?) : IMainActivityVP.Presenter, IFragmentNavigation.Presenter {
    override fun getRandomFragment() {

    }

    override fun addFragment(fragment: BaseFragment) {

    }

    fun prepareDrawerHandle(item: MenuItem, sfm: FragmentManager, drawer: DrawerLayout) {
        var fragment: Fragment? = null
        val fragmentClass = when (item.itemId) {
            R.id.nav_start -> FragmentOne::class.java
            R.id.nav_scheduled -> FragmentScheduled::class.java
            else -> FragmentOne::class.java
        }
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
        replaceFragment(fragment, sfm)
        drawer.closeDrawer(GravityCompat.START)
    }

    private fun replaceFragment(fragment: Fragment?, fm: FragmentManager) {
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment!!)
        fragmentTransaction.commit()
    }
}