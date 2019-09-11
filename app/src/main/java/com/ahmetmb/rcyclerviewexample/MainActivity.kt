package com.ahmetmb.rcyclerviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var allNaturalViewsData = ArrayList<NaturalViews>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataResourcePrepare()

        var adapterNaturalViews = NaturalViewsAdapter(allNaturalViewsData)
        recyclerView.adapter = adapterNaturalViews

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.home_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var id = item?.itemId

        when(id) {

            R.id.menuLinearViewHorizontal -> {
                var menuLinearViewHorizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                recyclerView.layoutManager = menuLinearViewHorizontal
            }
            R.id.menuLinearViewVertical -> {
                var menuLinearViewVertical = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recyclerView.layoutManager = menuLinearViewVertical
            }
            R.id.menuGrid -> {
                var menuGrid = GridLayoutManager(this, 2)
                recyclerView.layoutManager = menuGrid
            }
            R.id.menuStaggeredHorizontal -> {
                var menuStaggeredHorizontal = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
                recyclerView.layoutManager = menuStaggeredHorizontal
            }
            R.id.menuStaggeredVertical -> {
                var menuStaggeredVertical = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                recyclerView.layoutManager = menuStaggeredVertical
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun dataResourcePrepare(): ArrayList<NaturalViews> {

        var allImages = arrayOf(R.drawable.image_001, R.drawable.image_002, R.drawable.image_003, R.drawable.image_004, R.drawable.image_005,
            R.drawable.image_006, R.drawable.image_007, R.drawable.image_008, R.drawable.image_009, R.drawable.image_010, R.drawable.image_011,
            R.drawable.image_012, R.drawable.image_013, R.drawable.image_014, R.drawable.image_015, R.drawable.image_016, R.drawable.image_017,
            R.drawable.image_018, R.drawable.image_019, R.drawable.image_020, R.drawable.image_021, R.drawable.image_022, R.drawable.image_023,
            R.drawable.image_024, R.drawable.image_025, R.drawable.image_026, R.drawable.image_027, R.drawable.image_028, R.drawable.image_029,
            R.drawable.image_030, R.drawable.image_031, R.drawable.image_032, R.drawable.image_033, R.drawable.image_034, R.drawable.image_035,
            R.drawable.image_036, R.drawable.image_037, R.drawable.image_038, R.drawable.image_039, R.drawable.image_040, R.drawable.image_041)

        for (i in 0 until allImages.size) {

            var thisAddViews = NaturalViews("Title: $i", "Description: $i", allImages[i])
            allNaturalViewsData.add(thisAddViews)

        }
        return allNaturalViewsData
    }
}
