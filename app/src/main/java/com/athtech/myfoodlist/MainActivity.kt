package com.athtech.myfoodlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val data = arrayOf<String>("One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Eleven","Twelve","Thirteen","Fourteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty")

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        getAllData()

    }

        fun getAllData() {
            Api.retrofitService.getAllData().enqueue(object : Callback<List<Data>> {
                override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                    if (response.isSuccessful) {
                        recyclerView = findViewById<RecyclerView>(R.id.food_recycler_view).apply {
                            myAdapter = RecyclerAdapter(response.body()!!)
                            layoutManager = manager
                            adapter = myAdapter
                        }
                    }
                }
                override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
}