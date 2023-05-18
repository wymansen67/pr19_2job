package com.example.pr19_2job

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var adapter:ArrayAdapter<User>
    lateinit var name:String
    var age:Int = 0
    lateinit var user:ArrayList<User>
    lateinit var listview:ListView

    lateinit var nametxt:EditText
    lateinit var agetxt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nametxt = findViewById(R.id.editText2)
        agetxt = findViewById(R.id.editText)
        listview=findViewById(R.id.listView)
        user = ArrayList()
        adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,user)
        listview.adapter=adapter as ArrayAdapter<*>
    }
    fun addUser(view: View) {
        val name = nametxt.text.toString()
        val age = agetxt.text.toString().toInt()
        val userss = User(name, age)
        user.add(userss)
        adapter.notifyDataSetChanged()
    }

    fun save(view: View) {
        val result = JSONHelper.exportToJSON(this, user)
        if (result) {
            Toast.makeText(this, "Данные сохранены",
                Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Не удалось сохранить данные",
                Toast.LENGTH_LONG).show()
        }
    }

    fun open(view: View) {
        user = JSONHelper.importFromJSON(this) as ArrayList<User>
        if (user != null) {
            adapter.clear()
            adapter.addAll(user)
            Toast.makeText(this, "Данные восстановлены",
                Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Не удалось открыть данные",
                Toast.LENGTH_LONG).show()
        }
    }
}