package pakiet.arkadiuszzimny.extralessonappfragmentmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.IMainPresenter
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.FirstFragment
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.IMainView
import java.lang.ClassCastException

class MainActivity : AppCompatActivity(), IMainView {

    internal lateinit var mainPresenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(R.id.fragmentContainer)

    }

    override fun showFragment(containerViewID: Int) {
        var fragment: Fragment? = null
        var fragmentClass = FirstFragment::class.java
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewID, fragment!!)
        fragmentTransaction.commit()
    }


}