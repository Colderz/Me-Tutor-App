package pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces

import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment

interface IFragmentNavigation {
    interface View {
        fun attachPresenter(presenter: Presenter)
    }

    interface Presenter {
        fun addFragment(fragment: BaseFragment)
    }
}