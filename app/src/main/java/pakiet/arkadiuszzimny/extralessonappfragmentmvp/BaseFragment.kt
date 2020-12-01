package pakiet.arkadiuszzimny.extralessonappfragmentmvp

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), IFragmentNavigation.View {

    protected lateinit var navigationPresenter: IFragmentNavigation.Presenter

    override fun attachPresenter(presenter: IFragmentNavigation.Presenter) {
        navigationPresenter = presenter
    }


}