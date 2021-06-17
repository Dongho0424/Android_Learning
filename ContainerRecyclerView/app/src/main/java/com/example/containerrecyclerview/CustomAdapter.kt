package com.example.containerrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.containerrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

// adapter == cell
// viewHolder == each UI components of cell
class CustomAdapter : RecyclerView.Adapter<MyHolder>() {

    var listData = mutableListOf<Memo>()

    // 아이템 레이아웃을 생성하는 부분.
    // 스마트폰의 한 화면에 보이는 개수만큼 안드로이드가 이 메서드를 호출함.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemRecyclerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    // 생성된 뷰홀더를 화면에 보여주는 메서드
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val memo = listData[position]
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class MyHolder(private val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "selected item : ${binding.textTitle.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
        Log.d("binding.root", binding.root.toString())
    }

    fun setMemo(memo: Memo) {
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = memo.vartitle

        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd")
        val formattedDate = simpleDateFormat.format(memo.timestamp)
        binding.textDate.text = formattedDate
    }
}