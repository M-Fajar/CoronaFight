package id.alpine.coronainformation.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

import id.alpine.coronainformation.R
import kotlinx.android.synthetic.main.fragment_hasil.*

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class HasilFragment : Fragment() ,View.OnClickListener {

    var hasil = hashMapOf<Int,Int>()
    companion object{
        var hasil = hashMapOf<Int,Int>()
    }
    var result = 0
    private var txtSaran: TextView? = null
    private var txtEdu: TextView? = null
    private var txtStatus: TextView? = null
    private var imgStatus: ImageView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hasil, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtSaran = view.findViewById(R.id.tv_saran)
        txtEdu =  view.findViewById(R.id.tv_edu)
        txtStatus =  view.findViewById(R.id.tv_status)
        imgStatus = view.findViewById(R.id.img_status)
        val btnDone = view.findViewById<Button>(R.id.btn_done)
        btnDone.setOnClickListener(this)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getSerializable("hasil")
            hasil = descFromBundle as HashMap<Int, Int>
        }

        if (arguments != null) {
            val map = arguments?.getSerializable("hasil")
            hasil = map as HashMap<Int, Int>

        }

        if (hasil[1] == 1 && hasil[2] == 1 && hasil[3] == 1) {
            if ((hasil[4] == 1 || hasil[5] == 1)|| hasil[6] == 1 || hasil[7] == 1 || hasil[8] == 1 || hasil[9] == 1) {
                result = 1;
            } else {
                result = 3;
            }
        } else if (hasil[1] == 1 && hasil[2] == 0 && hasil[3] == 0) {
            if ((hasil[4] == 1 || hasil[5] == 1)|| hasil[6] == 1 || hasil[7] == 1 || hasil[8] == 1 || hasil[9] == 1) {
                result = 2;
            } else {
                result = 3;
            }
        } else if (hasil[1] == 0 && hasil[2] == 1 && hasil[3] == 0) {
            if ((hasil[4] == 1 || hasil[5] == 1)|| hasil[6] == 1 || hasil[7] == 1 || hasil[8] == 1 || hasil[9] == 1) {
                result = 2;
            } else {
                result = 3;
            }
        } else if (hasil[1] == 0 && hasil[2] == 0 && hasil[3] == 1) {
            if ((hasil[4] == 1 || hasil[5] == 1)|| hasil[6] == 1 || hasil[7] == 1 || hasil[8] == 1 || hasil[9] == 1) {
                result = 1;
            } else {
                result = 3;
            }
        } else if (hasil[1] == 1 && hasil[2] == 1 && hasil[3] == 0) {
            if ((hasil[4] == 1 || hasil[5] == 1)|| hasil[6] == 1 || hasil[7] == 1 || hasil[8] == 1 || hasil[9] == 1) {
                result = 2;
            } else {
                result = 3;
            }
        } else if (hasil[1] == 0 && hasil[2] == 0 && hasil[3] == 0) {
            if ((hasil[4] == 1 || hasil[5] == 1)|| hasil[6] == 1 || hasil[7] == 1 || hasil[8] == 1 || hasil[9] == 1) {
                result = 4;
            } else {
                result = 3;
            }
        } else {
            result = 3;
        }

        if (result == 1){
            imgStatus!!.setImageResource(R.drawable.pdp)
            txtStatus!!.text = "Pasien Dalam Pengawasan (PDP)"
            txtSaran!!.text = "HUBUNGI SEGERA nomor kontak layanan kesehatan yang tersedia / terdekat dan ikuti instruksi selanjutnya."
            txtEdu!!.text = "Terapkan Perilaku Hidup Bersih dan Sehat (PHBS), rajin cuci tangan sesuai standar kesehatan, istirahat jika kondisi tidak sehat, hindari keramaian, jaga jarak 1 meter dari orang disekitar dan memakai masker jika terkena batuk dan pilek."
        }
        else if (result ==2 ){
            imgStatus!!.setImageResource(R.drawable.odp)
            txtStatus!!.text = "Orang Dalam Pemantauan (ODP)"
            txtSaran!!.text = "LAPORKAN melalui kontak layanan kesehatan yang tersedia dan WAJIB ISOLASI DIRI MANDIRI DI RUMAH"
            txtEdu!!.text = "Terapkan Perilaku Hidup Bersih dan Sehat (PHBS), rajin cuci tangan sesuai standar kesehatan, istirahat jika kondisi tidak sehat, hindari keramaian, jaga jarak 1 meter dari orang disekitar dan memakai masker jika terkena batuk dan pilek."
        }else if (result == 3){

            imgStatus!!.setImageResource(R.drawable.sehat)
            txtStatus!!.text = "Bukan ODP / PDP"
            txtSaran!!.text = "Alhamdulillah Anda sehat dan bukan kategori terpapar Virus COVID-19."
            txtEdu!!.text = "Terapkan Perilaku Hidup Bersih dan Sehat (PHBS), rajin cuci tangan sesuai standar kesehatan, istirahat jika kondisi tidak sehat, hindari keramaian, jaga jarak 1 meter dari orang disekitar dan memakai masker jika terkena batuk dan pilek. Tingkatkan rasa syukur kepada Allah SWT karena sudah diberi kesehatan."
        }else {
            imgStatus!!.setImageResource(R.drawable.otg)
            txtStatus!!.text = "Orang Tanpa Gejala (OTG)"
            txtSaran!!.text = "WAJIB ISOLASI DIRI MANDIRI DI RUMAH setidaknya 14 hari dan lakukan pemantauan kesehatan mandiri jika terjadi perburukan kondisi dan muncul gejala segera laporkan ke nomor kontak layanan yang tersedia."
            txtEdu!!.text = "Terapkan Perilaku Hidup Bersih dan Sehat (PHBS), rajin cuci tangan sesuai standar kesehatan, istirahat jika kondisi tidak sehat, hindari keramaian, jaga jarak 1 meter dari orang disekitar dan memakai masker jika terkena batuk dan pilek. Tingkatkan rasa syukur kepada Allah SWT karena sudah diberi kesehatan."
        }


    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_done) {
                val selesaiFragment = AboutFragment()
                val mFragmentManager = fragmentManager

                mFragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.frame_hasil,
                        selesaiFragment,
                        AboutFragment::class.java.simpleName
                    )

                    commit()
                }
            }
        }
    }
}
