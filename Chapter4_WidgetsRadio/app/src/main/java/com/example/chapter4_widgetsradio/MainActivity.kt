package com.example.chapter4_widgetsradio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.example.chapter4_widgetsradio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val listener by lazy {
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when(buttonView.id){
                    R.id.checkApple -> Log.d("CheckBox", "사과가 선택되었습니다.")
                    R.id.checkBanana -> Log.d("CheckBox", "banana가 선택되었습니다.")
                    R.id.checkOrange -> Log.d("CheckBox", "orange is selected.")
                }
            } else {
                when(buttonView.id){
                    R.id.checkApple -> Log.d("CheckBox", "사과가 선택해제되었습니다.")
                    R.id.checkBanana -> Log.d("CheckBox", "banana가 선택해제되었습니다.")
                    R.id.checkOrange -> Log.d("CheckBox", "orange is deselected.")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                // 안드로이드가 리소스를 관리하는 R이라는 클래스를 생성하고, 그 안에 리소스 아이디를 관리하는
                // id 가 출력 됨
                R.id.radioApple -> Log.d("RadioButton", "apple is checked!")
                R.id.radioBanana -> Log.d("RadioButton", "banana is checked!")
                R.id.radioOrange -> Log.d("RadioButton", "orange is checked!")
            }
        }

        binding.checkApple.setOnCheckedChangeListener(listener)
        binding.checkBanana.setOnCheckedChangeListener(listener)
        binding.checkOrange.setOnCheckedChangeListener(listener)
    }
}