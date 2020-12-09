package pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces

import android.widget.ImageView
import android.widget.ProgressBar
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment

interface IFragmentOneVP {
    interface View{

    }

    interface Presenter{
       fun loadImageUsingGlide(fragment: BaseFragment, progressBar: ProgressBar, imageView: ImageView)
       fun initData()
    }
}