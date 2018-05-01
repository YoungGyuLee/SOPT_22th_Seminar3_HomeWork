package woo.sopt22.seminar3

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.kakao_item.*
import woo.sopt22.seminar3.Adapter.KaKaoAdapter
import woo.sopt22.seminar3.Data.KaKaoData

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

        val index : Int = main_recyclerview.getChildAdapterPosition(v!!) // 몇번째를 클릭했는지에 대한 정보를 index가 가지고 있다.
        val name : String = kakaoItems[index].name
        val profile : Int = kakaoItems[index].profile


        val intent : Intent = Intent(applicationContext, ChatActivity::class.java)
        intent.putExtra("name",name)
        intent.putExtra("profile",profile)
        startActivity(intent)






        // 리사이클러뷰의 몇번째를 클릭했는지 처리할 것


    }

    lateinit var kakaoItems : ArrayList<KaKaoData>
    var kakaoItems2 : ArrayList<KaKaoData> = ArrayList()
    var kakaoItems3 : ArrayList<KaKaoData>?=null
    // 3가지 방법이 있음
    var context : Context = this

    lateinit var kakaoAdapter: KaKaoAdapter
    /*FIXME
    * lateinit : 초기화를 지금하지 않고 나중에 초기화를 진행할 수 있도록 하는 방법
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kakaoItems = ArrayList()
        kakaoItems.add(KaKaoData(R.drawable.pic1,"09의 바나나 안드로이드","낰낰","오후 4:07"))
        kakaoItems.add(KaKaoData(R.drawable.pic2," 이돌이의 차근차근 기",":D ><","오후 6:05"))
        kakaoItems.add(KaKaoData(R.drawable.pic3,"트카의 텔미텔미딪","아니 내","오후 3:07"))
        kakaoItems.add(KaKaoData(R.drawable.pic4,"사과의 고속사과","이상하고만","오후 8:24"))
        kakaoItems.add(KaKaoData(R.drawable.pic5,"섭이의 섭섭한 칼","옆모습 정승환","오후 11:09"))
        kakaoItems.add(KaKaoData(R.drawable.pic6,"인누강의 웹마이웨이","호에에에엥","오전 7:59"))
        kakaoItems.add(KaKaoData(R.drawable.pic7,"신선이의 힐링캠프","애들아...딱 그 5분만 할게요","오후 6:27"))
        kakaoItems.add(KaKaoData(R.drawable.pic8,"할머니의 당찬하루","아..!","오후 3:33"))
        kakaoItems.add(KaKaoData(R.drawable.pic9,"이모님의 회계원리","뒤풀이 어디가지...","오후 11:55"))
        kakaoItems.add(KaKaoData(R.drawable.pic10,"대장의 생방송","따봉따봉미 bb","오후 10:10"))
        // 코틀린은 new라는 키워드가 존재하지 않기 때문에 바로 생성자를 넣어주면 된다.



        kakaoAdapter = KaKaoAdapter(kakaoItems,context)
        kakaoAdapter.setOnItemClickListener(this)
        main_recyclerview.layoutManager = LinearLayoutManager(this)
        main_recyclerview.adapter = kakaoAdapter

    }
}
