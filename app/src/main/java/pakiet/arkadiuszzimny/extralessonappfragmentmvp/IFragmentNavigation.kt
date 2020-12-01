package pakiet.arkadiuszzimny.extralessonappfragmentmvp

interface IFragmentNavigation {
    interface View {
        fun attachPresenter(presenter: Presenter)
    }

    interface Presenter {
        fun addFragment(fragment: BaseFragment)
    }
}