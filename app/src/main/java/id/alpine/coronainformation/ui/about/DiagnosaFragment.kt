package id.alpine.coronainformation.ui.about

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import id.alpine.coronainformation.BaseApplication

import id.alpine.coronainformation.R
import kotlinx.android.synthetic.main.fragment_diagnosa.*
import kotlinx.android.synthetic.main.fragment_negara.view.*

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class DiagnosaFragment : Fragment() , View.OnClickListener {


    private var progressBar: ProgressBar? = null
    private var i = 2
    private var posisi = -1
    private var txtView: TextView? = null
    private var txtTanya: TextView? = null
    private var rb1: RadioButton? = null
    private var rb0: RadioButton? = null
    val jawab = hashMapOf<Int, Int>()
    val soal = arrayOf(
        "Apakah anda memiliki riwayat/gejala demam dalam 14 hari terakhir ?",
        "Apakah Anda merasakan batuk, hidung tersumbat atau nyeri tenggorokan ?",
        "Apakah nafas Anda terasa sesak?",
        "Dalam 14 hari terakhir, apakah Anda memiliki riwayat perjalanan ke luar negeri ?",
        "Dalam 14 hari terakhir, apakah Anda memiliki riwayat perjalanan atau berada diwilayah di indonesia yang dikategorikan terjangkit COVID-19 dengan transmisi lokal ?",
        "Dalam 14 hari terakhir, apakah Anda pernah bertemu/merawat/tinggal serumah/bekerja bersama dengan penderita positif COVID-19 ?",
        "Dalam 14 hari terakhir, apakah Anda pernah bekerja atau mengunjungi fasilitas layanan kesehatan dengan kasus terkonfirmasi atau suspek infeksi COVID-19 diwilayah/negara terjangkit ?",
        "Dalam 14 hari terakhir, apakah Anda pernah merawat/tinggal serumah/kontak langsung dengan pasien ISPA(infeksi saluran pernapasan akut) berat yang tidak diketahui penyebab penyakit ?",
        "Apakah Anda memiliki demam lebih 38 Derajat Calcius atau ada riwayat demam, memiliki riwayat perjalanan ke luar negeri atau kontak dengan orang yang memiliki riwayat perjalanan ke luar negeri ?"
    )
    val jawab1 = arrayOf("Ya", "Ya", "Ya", "Ya", "Ya", "Pernah", "Ya", "Ya", "Ya")
    val jawab0 = arrayOf(
        "Tidak",
        "Tidak",
        "Tidak",
        "Tidak",
        "Tidak",
        "Belum pernah",
        "Tidak",
        "Tidak",
        "Tidak"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diagnosa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.proggres_diagnosa) as ProgressBar
        txtView = view.findViewById(R.id.tv_nodiag) as TextView
        txtTanya = view.findViewById(R.id.tv_diagnosa) as TextView
        rb1 = view.findViewById(R.id.rb_1)
        rb0 = view.findViewById(R.id.rb_0)

        val btnNext = view.findViewById(R.id.btn_next2) as Button
        val btnBack = view.findViewById(R.id.btn_back2) as Button



        i = progressBar!!.progress
        btnNext.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v != null) {
            if (v.id == R.id.btn_next2) {
                var id: Int = rg_diagnosa.checkedRadioButtonId
                rg_diagnosa.clearCheck()
                if (id != -1) {
                    posisi += 1
                    if (id == R.id.rb_1) {
                        jawab[posisi] = 1
                    } else {
                        jawab[posisi] = 0
                    }
                    i += 1
                    if (posisi < 9) {


                        progressBar!!.progress = i
                        txtView!!.text = i.toString()
                        txtTanya!!.text = soal[posisi]
                        rb1!!.text = jawab1[posisi]
                        rb0!!.text = jawab0[posisi]
                    } else {
                        val mHasilFragment = HasilFragment()
                        val mFragmentManager = fragmentManager

                        val mBundle = Bundle()
                        mBundle.putSerializable("hasil", jawab)
                        mHasilFragment.arguments = mBundle

                        mFragmentManager?.beginTransaction()?.apply {
                            replace(
                                R.id.frame_diagnosa,
                                mHasilFragment,
                                HasilFragment::class.java.simpleName
                            )
                            addToBackStack(null)
                            commit()
                        }
                    }
                } else {
                    Toast.makeText(
                        activity, "Silahkan jawab pertanyaan !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            if (v.id == R.id.btn_back2) {
                rg_diagnosa.clearCheck()
                i -= 1
                posisi -= 1
                if (posisi >= 0) {
                    progressBar!!.progress = i
                    txtView!!.text = i.toString()
                    txtTanya!!.text = soal[posisi]
                    rb1!!.text = jawab1[posisi]
                    rb0!!.text = jawab0[posisi]
                } else if (posisi == -1) {
                    progressBar!!.progress = 2
                    txtView!!.text = "2"
                    txtTanya!!.text = "Apa jenis kelamin Anda ?"
                    rb1!!.text = "Laki - laki"
                    rb0!!.text = "Perempuan"
                } else {

                    val mDiagnosaFragment = TanyaFragment()
                    val mFragmentManager = fragmentManager
                    mFragmentManager?.beginTransaction()?.apply {
                        replace(
                            R.id.frame_diagnosa,
                            mDiagnosaFragment,
                            TanyaFragment::class.java.simpleName
                        )
                        commit()
                    }

                }

            }
        }

    }
}

