package com.anciar.tech.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager
import com.anciar.tech.databinding.ActivityMainBinding
import com.anciar.tech.epoxycontroller.ImagesEpoxyController
import com.anciar.tech.model.ResponseModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var responseString: String
    private var dataList: ArrayList<ResponseModel.Datum> = ArrayList()
    private lateinit var imagesEpoxyController: ImagesEpoxyController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getResponseString()
        makeListData()
        setEpoxyController()
        setEpoxyData()
    }

    private fun getResponseString() {
        responseString = applicationContext.assets.open("response.json").bufferedReader().use { it.readText() }
    }

    private fun setEpoxyData() {
        imagesEpoxyController.setData(dataList)
    }

    private fun setEpoxyController() {
        val linearFilterLayoutManager = StickyHeaderLinearLayoutManager(this)
        imagesEpoxyController = ImagesEpoxyController()
        binding.epoxyRecyclerView.layoutManager = linearFilterLayoutManager
        binding.epoxyRecyclerView.setController(imagesEpoxyController)
        try {
            imagesEpoxyController.isDebugLoggingEnabled = true
            imagesEpoxyController.setFilterDuplicates(true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun makeListData() {
        val responseModel = Gson().fromJson(responseString, ResponseModel::class.java)
        dataList.clear()
        dataList.addAll(responseModel.data!!)
    }
}