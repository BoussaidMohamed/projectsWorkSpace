package taginstore.packag.com.foodapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle=intent.extras
        iv_FoodImage.setImageResource(bundle.getInt("image"))
        tv_FoodDesc.text = bundle.getString("desc")
        tv_FoodName.text = bundle.getString("name")
    }
}
