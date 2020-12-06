package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.MainActivityPresenter
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IMainActivityVP

class MainActivity : AppCompatActivity(), IMainActivityVP.View {


    internal lateinit var mainPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment = FragmentOne::class.java.newInstance() as BaseFragment
        setFragment(fragment)

        mainPresenter = MainActivityPresenter(this)

    }

    override fun setFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


}