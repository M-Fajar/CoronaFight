package id.alpine.coronainformation.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import id.alpine.coronainformation.BaseApplication
import id.alpine.coronainformation.MainActivity
import id.alpine.coronainformation.R

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(R.id.btn_mulai)
        btnCategory.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if (v.id == R.id.btn_mulai) {
            val mCategoryFragment = TanyaFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_info, mCategoryFragment, TanyaFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }
    }

}


