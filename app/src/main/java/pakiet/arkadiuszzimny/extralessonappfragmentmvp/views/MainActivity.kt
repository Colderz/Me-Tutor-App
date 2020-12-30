package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.MainActivityPresenter
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IMainActivityVP
import java.lang.ClassCastException

class MainActivity : AppCompatActivity(), IMainActivityVP.View {

    private lateinit var mainPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment = FragmentOne::class.java.newInstance() as BaseFragment
        setFragment(fragment)
        mainPresenter = MainActivityPresenter(this)

        navigationView.setNavigationItemSelectedListener{
            selectDrawerItem(it, supportFragmentManager, drawerLayout)
            true
        }

    }

    override fun setFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun selectDrawerItem(item: MenuItem, sfm: FragmentManager, drawer: DrawerLayout) {
        mainPresenter.prepareDrawerHandle(item, sfm, drawer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }




}