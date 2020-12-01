package pakiet.arkadiuszzimny.extralessonappfragmentmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

class MainActivity : AppCompatActivity(), IMainActivityVP.View, IMainView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(R.id.fragmentContainer)

    }

    override fun setFragment(fragment: BaseFragment) {

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