package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.fragment_first.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentOneVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.FragmentOnePresenter

class FragmentOne : BaseFragment(), IFragmentOneVP.View {

    companion object {
        fun newInstance() = FragmentOne()
    }

    internal lateinit var fragmentOnePresenter: FragmentOnePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentOnePresenter = FragmentOnePresenter()
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onResume() {
        super.onResume()
        setImage(this, fragmentOneProgressBar, secondMainImage)
    }

    fun setImage(fragment: BaseFragment, progressBar: ProgressBar, imageView: ImageView) {
        fragmentOnePresenter.loadImageUsingGlide(fragment, progressBar, imageView)
    }


}