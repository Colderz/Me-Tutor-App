package pakiet.arkadiuszzimny.extralessonappfragmentmvp

interface IMainActivityVP {
    interface View {
        fun setFragment(fragment: BaseFragment)
    }

    interface Presenter{
        fun getRandomFragment()
    }


}