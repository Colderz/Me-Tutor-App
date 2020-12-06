package pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces

import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment

interface IMainActivityVP {
    interface View {
        fun setFragment(fragment: BaseFragment)
    }

    interface Presenter{
        fun getRandomFragment()
    }


}