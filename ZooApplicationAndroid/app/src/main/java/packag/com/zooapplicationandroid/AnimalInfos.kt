package packag.com.zooapplicationandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_infos.*
import kotlinx.android.synthetic.main.animals_ticket.*

class AnimalInfos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_infos)
        val bundle:Bundle = intent.extras
        val name=bundle.getString("name")
        val desc=bundle.getString("des")
        val image=bundle.getInt("image")

        ivAnimalImage.setImageResource(image)
        tvAnimalName.text = name
        tvAnimalsDetails.text=desc
    }
}
