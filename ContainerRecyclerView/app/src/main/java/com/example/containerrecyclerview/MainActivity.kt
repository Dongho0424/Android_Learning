package com.example.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.containerrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = loadData()
        val adapter = CustomAdapter()
        adapter.listData = data
        // connect adapter to recyclerView (= tableView)
        binding.recyclerView.adapter = adapter
        // connect adapter to layoutManager which determines how the recyclerView is displayed on the screen
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun loadData(): MutableList<Memo> {
        val list = mutableListOf<Memo>()
        for (no in 1..100) {
            val title = "This is Android $no"
            val date = System.currentTimeMillis()
            val memo = Memo(no, title, date)
            list.add(memo)
        }
        return list
    }

}