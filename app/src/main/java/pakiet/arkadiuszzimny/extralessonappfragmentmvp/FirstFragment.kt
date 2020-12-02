package pakiet.arkadiuszzimny.extralessonappfragmentmvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FirstFragment : BaseFragment(){

    companion object {
        fun newInstance() = FirstFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun attachPresenter(presenter: IFragmentNavigation.Presenter) {
        super.attachPresenter(presenter)
    }

}