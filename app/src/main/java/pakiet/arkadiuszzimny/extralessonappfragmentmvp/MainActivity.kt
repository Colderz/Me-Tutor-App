package pakiet.arkadiuszzimny.extralessonappfragmentmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

class MainActivity : AppCompatActivity(), IMainActivityVP.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment = FirstFragment::class.java.newInstance() as BaseFragment
        setFragment(fragment)

    }

    override fun setFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


}