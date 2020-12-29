package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R

class FragmentScheduled : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var mView: View = inflater.inflate(R.layout.fragment_scheduled, container, false)
        return mView
    }
}