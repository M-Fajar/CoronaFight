package id.alpine.coronainformation.ui.about

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import id.alpine.coronainformation.BaseApplication
import id.alpine.coronainformation.MainActivity

import id.alpine.coronainformation.R
import kotlinx.android.synthetic.main.fragment_tanya.*

/**
 * A simple [Fragment] subclass.
 */
class TanyaFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tanya, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnNext = view.findViewById(R.id.btn_next) as Button
        val btnBack = view.findViewById(R.id.btn_back) as Button


        btnNext.setOnClickListener(this)
        btnBack.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_next) {
                if (rg_tanya.checkedRadioButtonId != -1) {
                    val mDiagnosaFragment = DiagnosaFragment()
                    val mFragmentManager = fragmentManager
                    mFragmentManager?.beginTransaction()?.apply {
                        replace(
                            R.id.frame_tanya,
                            mDiagnosaFragment,
                            DiagnosaFragment::class.java.simpleName
                        )
                        addToBackStack(null)
                        commit()
                    }

                } else {
                    Toast.makeText(
                        activity, "On button click : nothing selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }


            if (v.id == R.id.btn_back) {

                val mDiagnosaFragment = AboutFragment()
                val mFragmentManager = fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.frame_tanya,
                        mDiagnosaFragment,
                        AboutFragment::class.java.simpleName
                    )
                    commit()
                }

            }
        }
    }
}


