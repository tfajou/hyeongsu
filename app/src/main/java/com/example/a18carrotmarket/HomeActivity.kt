package com.example.a18carrotmarket

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a18carrotmarket.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        window.statusBarColor = ContextCompat.getColor(this,R.color.stausbar)



        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Mydata = mutableListOf<MyItem>()
        Mydata.add(MyItem(R.drawable.sample1,"산진 한달된 선풍기 팝니다", "서울 서대문구 창천동",1000,25,13))
        Mydata.add(MyItem(R.drawable.sample2,"김치냉장고", "인천 계양구 귤현동",20000,28,8))
        Mydata.add(MyItem(R.drawable.sample3,"샤넬 카드지갑", "동래구 온천제2동",10000,5,23))
        Mydata.add(MyItem(R.drawable.sample4,"금고", "수성구 범어동",10000,5,23))
        Mydata.add(MyItem(R.drawable.sample5,"갤럭시Z플립3 팝니다", "해운대구 우제2동",10000,17,14))
        Mydata.add(MyItem(R.drawable.sample6,"프라다 복조리백", "연제구 연산제8동",150000,9,22))
        Mydata.add(MyItem(R.drawable.sample7,"울산 동해오션뷰 60평 복층 펜트하우스\n 1일 숙박권 펜션 힐링 숙소 별장", "수원시 영통구 원천동",150000,54,142))
        Mydata.add(MyItem(R.drawable.sample8,"샤넬 탑핸들 가방\n", "남구 옥동",18000,7,31))
        Mydata.add(MyItem(R.drawable.sample9,"4행정 엔진분무기 판매합니다.", "원주시 명륜2동",30000,28,7))
        Mydata.add(MyItem(R.drawable.sample10,"셀린느 버킷 가방.", "중구 동화동",190000,6,40))


        val adapter = MyAdapter(Mydata)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedItem = Mydata[position]

                val intent = Intent(this@HomeActivity, DetailActivity::class.java)
                intent.putExtra("Item_Name", selectedItem.Name)
                intent.putExtra("Item_Price", selectedItem.Price)
                intent.putExtra("Item_Locate", selectedItem.Locate)
                startActivity(intent)
            }
        }




    }
    override fun onBackPressed() {
        showExitDialog()
    }

    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("종료 확인")
        builder.setMessage("종료하시겠습니까?")

        builder.setPositiveButton("확인") { _: DialogInterface, _: Int ->
            finish()
        }

        builder.setNegativeButton("취소") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}