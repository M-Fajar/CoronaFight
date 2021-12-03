package id.alpine.coronainformation.ui.banyuwangi

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import id.alpine.coronainformation.R

class MyListAdapter(private val context: Activity, private val title: Array<String>, private val description: Array<String>)
    : ArrayAdapter<String>(context, R.layout.list_item, title) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_item, null, true)

        val titleText = rowView.findViewById(R.id.tv_rs) as TextView
        val subtitleText = rowView.findViewById(R.id.tv_phone) as TextView

        titleText.text = title[position]
        subtitleText.text = description[position]

        return rowView
    }
}