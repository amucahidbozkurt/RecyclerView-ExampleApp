package com.ahmetmb.rcyclerviewexample

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.one_line_layout.view.*

class NaturalViewsAdapter(allNaturalViewsData: ArrayList<NaturalViews>): RecyclerView.Adapter<NaturalViewsAdapter.NaturalViewHolder>() {

    public var naturalViews = allNaturalViewsData

    override fun getItemCount(): Int {
        return naturalViews.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaturalViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var oneLineViews = inflater.inflate(R.layout.one_line_layout, parent, false)

        return NaturalViewHolder(oneLineViews)
    }

    // p0: Holder p1: position
    override fun onBindViewHolder(p0: NaturalViewHolder, p1: Int) {

        var nowNaturalView = naturalViews.get(p1)
        p0.setData(nowNaturalView, p1)

    }

    inner class NaturalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var oneLineItems = itemView as CardView

        var viewsTitle = oneLineItems.textNaturalViewTitle
        var viewsDescription = oneLineItems.textNaturalViewDescription
        var viewsImage = oneLineItems.imageNaturalView
        var buttonDuplicate = oneLineItems.imgDuplicateButton
        var buttonDelete = oneLineItems.imgDeleteButton

        fun setData(nowNaturalViews: NaturalViews, p1: Int) {

            viewsTitle.text = nowNaturalViews.naturalViewsTitle
            viewsDescription.text = nowNaturalViews.naturalViewsDescription
            viewsImage.setImageResource(nowNaturalViews.naturalViewsImage)

            buttonDuplicate.setOnClickListener {

                naturalViews.add(p1, nowNaturalViews)
                notifyItemInserted(p1)
                notifyItemRangeChanged(p1, naturalViews.size)

            }

            buttonDelete.setOnClickListener {

                naturalViews.removeAt(p1)
                notifyItemRemoved(p1)
                notifyItemRangeChanged(p1, naturalViews.size)

            }

        }
    }

}