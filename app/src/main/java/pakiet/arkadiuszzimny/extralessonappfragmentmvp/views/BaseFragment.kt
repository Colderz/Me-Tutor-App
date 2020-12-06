package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import androidx.fragment.app.Fragment
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentNavigation

abstract class BaseFragment : Fragment(), IFragmentNavigation.View {

    protected lateinit var navigationPresenter: IFragmentNavigation.Presenter

    override fun attachPresenter(presenter: IFragmentNavigation.Presenter) {
        navigationPresenter = presenter
    }


}