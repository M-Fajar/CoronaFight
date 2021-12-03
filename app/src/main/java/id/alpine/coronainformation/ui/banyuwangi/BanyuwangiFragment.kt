package id.alpine.coronainformation.ui.banyuwangi

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import id.alpine.coronainformation.R
import id.alpine.coronainformation.ui.banyuwangiimport.CustomExpandableListAdapter
import kotlinx.android.synthetic.main.fragment_banyuwangi.*

/**
 * A simple [Fragment] subclass.
 */
class BanyuwangiFragment : Fragment(){
    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val aceh = ArrayList<String>()
            aceh.add("RSUD Dr Zainoel Abidin, Banda Aceh \n (0651 -34562)")
            aceh.add("RSUD Cut Meutia, Lhokseumawe \n (0645) 46334")
            val sumbar = ArrayList<String>()
            sumbar.add("RSUP dr M Djamil, Padang \n (0751) 32371")
            sumbar.add("RSUD Dr Achmad Mochtar, Bukittinggi \n  (0752) 2172")
            val sumsel = ArrayList<String>()
            sumsel.add("RSUP Dr Mohammad Hoesin, Palembang \n (0711) 354088")
            sumsel.add("RS Dr Rivai Abdullah, Kab Banyuasin \n  (0711) 7537201")
            val bengkulu = ArrayList<String>()
            bengkulu.add("RSUD Dr M Yunus, Bengkulu \n (0736) 52004")
            bengkulu.add("RSUD Arga Makmur, Kabupaten Bengkulu Utara \n (0737) 521118")
            bengkulu.add("RSUD Hasanuddin Damrah Manna, Kabupaten Bengkulu Selatan \n 085381637684")
            val Bangka= ArrayList<String>()
            Bangka.add("RSUD Dr H Marsidi Judono, Tanjungpandang, Kabupaten Belitung \n (0719) 22190")
            Bangka.add("RSUD Depati Hamzah,  Pangkal Pinang \n (0717) 438660")

            val riau = ArrayList<String>()
            riau.add("RSUD Embung Fatimah, Batu Aji, Kota Batam \n (0778) 364446")
            riau.add("RSBP Batam, Sekupang, Batam \n (0778) 322046")
            riau.add("RSUD Muhammad Sani, Tanjung Balai Karimun, Kabupatan Karimun \n (0777) 327808")
            riau.add("RSUD Provinsi Kepulauan Riau, Tanjungpinang \n (0771) 7335203")
            val sumut = ArrayList<String>()
            sumut.add("RSUP H Adam Malik, Medan \n  (061) 8360051")
            sumut.add("RSUD Kabanjahe \n (0628) 20012")
            sumut.add("RSUD Dr Djasamen Saragih, Pematang Siantar \n (0622) 22959")
            sumut.add("RSUD Dr Djasamen Saragih, Pematang Siantar \n (0633) 21303, 20450")
            sumut.add("RSUD Kota Padang Sidempuan \n  (0634) 21780")
            val jambi = ArrayList<String>()
            jambi.add("RSUD Raden Mattaher, Kota Jambi \n (0741) 61692")
            val lampung = ArrayList<String>()
            lampung.add("RSUD Dr H Abdul Moeloek, Bandar Lampung \n (0721) 703312")
            lampung.add("RSUD Dr H Bob Bazar SKM, Kabupaten Lampung Selatan \n (0727) 322159")
            lampung.add("RSUD Jend Ahmad Yani, Kota Metro \n (0725) 41820")
            lampung.add("RSD May Jend HM Ryacudu, Kotabumi \n (0724) 22095")
            val Riau = ArrayList<String>()
            Riau.add("RSUD Arifin Achmad, Pekanbaru \n (0761) 23418")
            Riau.add("RSUD Kota Dumai \n (0765) 440992")
            Riau.add("RSUD Puri Husada, Tembilahan \n (0768) 24563")

            listData["Aceh"] = aceh
            listData["Sumatra Barat"] = sumbar
            listData["Sumatra Selatan"] = sumsel
            listData["Bengkulu"] = bengkulu
            listData["Lampung"] = lampung
            listData["Bangka Belitung"] = Bangka
            listData["Jambi"] = jambi
            listData["Kepulauan Riau"] = riau
            listData["Sumatera Utara"] = sumut
            listData["Riau"]= Riau


            val banten = ArrayList<String>()
            banten.add("RSU Kabupaten Tangerang, Kota Tangerang \n (021) 5523507")
            banten.add("RS Siloam, Kelapa Dua, Tangerang \n (021) 80524900")
            banten.add("RSUD Dr Drajat Prawiranegara, Kota Serang \n " )
            val jakarta = ArrayList<String>()
            jakarta.add("RSPI Sulianti Saroso, Sunter, Jakarta Utara \n (021) 6506559")
            jakarta.add("RSPAD Gatot Soebroto, Jakarta Pusat \n (021) 3440693")
            jakarta.add("Rumah Sakit Umum Daerah (RSUD) Tarakan, Cideng, Gambir, Jakarta Pusat \n (021) 3503003")
            jakarta.add("RSAL Mintoharjo, Bendungan Hilir, Jakarta Pusat \n  (021) 5703081")
            jakarta.add("RSUD Cengkareng, Cengkareng, Jakarta Barat \n (021) 54372874")
            jakarta.add("Rumah Sakit Pelni, Slipi, Jakarta Barat \n (021) 5306901")
            jakarta.add("RSUD Pasar Minggu, Jakarta Selatan \n (021) 29059999")
            jakarta.add("RSUP Fatmawati, Jakarta Selatan \n (021) 7501524")
            jakarta.add("RS Umum Bhayangkara Tk 1 R Said Sukanto (RS Polri), Jakarta Timur \n (021) 8093288")
            jakarta.add("Rumah Sakit Khusus Daerah (RSKD) Duren Sawit, Jakarta Timur \n (021) 86552365")
            jakarta.add("SUP Persahabatan, Jakarta Timur \n (021) 4891708")
            val jabar = ArrayList<String>()
            jabar.add("RSUP Dr Hasan Sadikin, Kota Bandung \n (022) 203495355")
            jabar.add("RS Paru Dr H A Rotinsulu, Kota Bandung \n (022) 3034446")
            jabar.add("RS Mitra Keluarga Pratama Jatiasih, Jatimekar, Kota Bekasi \n (021) 85511000")
            jabar.add("RS Paru Dr M Goenawan Partowidigdo, Cisarua, Bogor \n (0251) 8253630")
            jabar.add("RS TK II 03.05.01 Dustira, Kota Cimahi \n (022) 6652207")
            val jateng = ArrayList<String>()
            jateng.add("RSUP dr Kariadi, Semarang \n (024) 8413476")
            jateng.add("RSUD KRMT Wongsonegoro, Kota Semarang \n (024) 6711500")
            jateng.add("RSUD Tugurejo, Semarang \n (024) 7605297")
            jateng.add("RSUD Tidar Kota, Magelang \n (0293) 362260")
            jateng.add("RSUD Kraton Kabupaten, Pekalongan \n (0285) 421621")
            jateng.add("RSUD Dr Moewardi, Solo \n (0271) 634634")
            val jatim = ArrayList<String>()
            jatim.add("RSUD Dr Soebandi, Kabupaten Jember \n (0331) 487441")
            jatim.add("RSUD Kabupaten Kediri \n  (0354) 391718")
            jatim.add("RSUD Dr Soetomo, Surabaya \n (031) 5501001")
            jatim.add("RSUD Dr Soedono, Madiun \n (0351) 464325")
            jatim.add("RSUD Dr Saiful Anwar, Malang \n (0341) 362101")
            jatim.add("RSUD dr R Koesma, Kabupaten Tuban \n (0356) 321010,")
            val jogja = ArrayList<String>()
            jogja.add("RSUP dr Sardjito, Sleman \n (0274) 631190")
            jogja.add("RSUD Panembahan Senopati, Bantul \n (0274) 367381")
            jogja.add("RSUD Kota Yogyakarta \n (0274) 371195, 386691")
            jogja.add("RSUD Wates \n (0274) 773169")

            listData["Banten"] = banten
            listData["DKI Jakarta"] = jakarta
            listData["Jawa Barat"] = jabar
            listData["Jawa Tengah"] =jateng
            listData["Jawa Timur"] =jatim
            listData["DI Yokyakarta"] = jogja



            return listData
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_banyuwangi, container, false)
        expandableListView = view?.findViewById<ExpandableListView>(R.id.expandableListView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys.sorted())
            adapter = CustomExpandableListAdapter(activity!!, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)

           // expandableListView!!.setOnGroupExpandListener { groupPosition -> Toast.makeText(activity, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show() }

            //expandableListView!!.setOnGroupCollapseListener { groupPosition -> Toast.makeText(activity, (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                Toast.makeText(activity, "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition), Toast.LENGTH_SHORT).show()
                true
            }
        }

    }

}

