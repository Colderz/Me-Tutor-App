package pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters

import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentNavigation
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IMainActivityVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.MainActivity

class MainActivityPresenter(var mainView: MainActivity?) : IMainActivityVP.Presenter, IFragmentNavigation.Presenter {
    override fun getRandomFragment() {

    }

    override fun addFragment(fragment: BaseFragment) {

    }
}