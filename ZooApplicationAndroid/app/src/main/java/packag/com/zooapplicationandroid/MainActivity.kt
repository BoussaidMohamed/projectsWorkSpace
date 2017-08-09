package packag.com.zooapplicationandroid

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animals_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfAnimals.add(Animal("Baboon","Baboon live in big place with tree",R.drawable.balboon,false))
        listOfAnimals.add(Animal("Bulldog","Bulldog live in houses",R.drawable.bulldog,true))
        listOfAnimals.add(Animal("Panda","Panda is a cute Animal",R.drawable.panda,true))
        listOfAnimals.add(Animal("Swallow Bird","Swallow Bird live in the sky",R.drawable.swallow_bird,false))
        listOfAnimals.add(Animal("Zebra","Zebra live in big place with tree",R.drawable.zebra,false))
        listOfAnimals.add(Animal("White Tiger","White Tiger live in the jungle",R.drawable.white_tiger,true))

        adapter= AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var context:Context?=null
        var listOfAnimals: ArrayList<Animal>
        constructor(context:Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context=context

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            if(animal.isKiller==true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animals_killer_ticket,null)
                var activityMainView = inflator.inflate(R.layout.activity_main,null)
                myView.tvName.text = animal.name
                myView.tvDescreption.text = animal.desc
                myView.iwAnimal.setImageResource(animal.image!!)
                myView.iwAnimal.setOnClickListener {
                    var intent =Intent(context,AnimalInfos::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("des",animal.desc)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)

                }
                return myView

            }
            else {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animals_ticket,null)
                myView.tvName.text = animal.name
                myView.tvDescreption.text = animal.desc
                myView.iwAnimal.setImageResource(animal.image!!)
                myView.iwAnimal.setOnClickListener {
                    var intent =Intent(context,AnimalInfos::class.java)
                    intent.putExtra("name",animal.name)
                    intent.putExtra("des",animal.desc)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)

                }
                return myView

            }

        }



        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
           return listOfAnimals.size
        }

    }
}
