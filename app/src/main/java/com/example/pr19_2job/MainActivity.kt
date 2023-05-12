package com.example.pr19_2job

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Adapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var adapter:Adapter
    lateinit var name:String
    var age:Int=0
    lateinit var user:List<User>
    lateinit var listview:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listview=findViewById(R.id.ListView)
        user = ArrayList()
        adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,user)
        listview.adapter=adapter as ArrayAdapter<User>
    }
}