package taginstore.packag.com.foodapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var foodAdapter:FoodAdapter? = null
    var listOfFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load foods
        listOfFoods.add(Food("Coffee","Coffee is a brewed drink prepared from roasted coffee beans, which are the seeds of berries from the Coffea plant. The genus Coffea is native to tropical Africa (specifically having its origin in Ethiopia and Sudan) and Madagascar, the Comoros, Mauritius, and Réunion in the Indian Ocean.[2] The plant was exported from Africa to countries around the world and coffee plants are now cultivated in over 70 countries, primarily in the equatorial regions of the Americas, Southeast Asia, India, and Africa. The two most commonly grown are the highly regarded arabica, and the less sophisticated but stronger and more hardy robusta. Once ripe, coffee berries are picked, processed, and dried. Dried coffee seeds (referred to as beans) are roasted to varying degrees, depending on the desired flavor. Roasted beans are ground and brewed with near-boiling water to produce coffee as a beverage.",R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso","Espresso (/ɛˈsprɛsoʊ/, Italian: [esˈprɛsso]) is coffee brewed by forcing a small amount of nearly boiling water under pressure through finely ground coffee beans. Espresso is generally thicker than coffee brewed by other methods, has a higher concentration of suspended and dissolved solids, and has crema on top (a foam with a creamy consistency).[1] As a result of the pressurized brewing process, the flavors and chemicals in a typical cup of espresso are very concentrated. Espresso is also the base for other drinks such as a caffè latte, cappuccino, caffè macchiato, caffè mocha, flat white, or caffè Americano.\n" +
                "\n" +
                "Espresso has more caffeine per unit volume than most coffee beverages, but because the usual serving size is much smaller, the total caffeine content is less than a mug of standard brewed coffee, contrary to a common belief.[2] Although the actual caffeine content of any coffee drink varies by size, bean origin, roast method and other factors, the caffeine content of \"typical\" servings of espresso vs. drip brew are 120 to 170 mg[3] vs. 150 to 200 mg.[4][5]",R.drawable.espresso))
        listOfFoods.add(Food("French Fires","French fries (North American English (American/Canadian)), chips (British English),[1] fries,[2] finger chips (Indian English),[3] or French-fried potatoes are batonnet or allumette-cut deep-fried potatoes.[4] In the United States and most of Canada, the term fries refers to all dishes of fried elongated pieces of potatoes, while in the United Kingdom, Australia, South Africa (rarely), Ireland and New Zealand, thinly cut fried potatoes are sometimes called shoestring fries or skinny fries to distinguish them from the thicker-cut chips.\n" +
                "\n" +
                "French fries are served hot, either soft or crispy, and are generally eaten as part of lunch or dinner or by themselves as a snack, and they commonly appear on the menus of diners, fast food restaurants, pubs, and bars. Fries in America are generally salted and are almost always served with ketchup, but in many countries they have other condiments or toppings, like vinegar, mayonnaise, or other local specialties. Fries can be topped more heavily, as in the dishes of poutine and chili cheese fries. French fries can be made from sweet potatoes instead of potatoes. A baked variant of the French fry (\"chunky oven chips\") uses less or even no oil.[5]",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","Honey is a sweet, viscous food substance produced by bees and some related insects.[1] Bees produce honey from the sugary secretions of plants (floral nectar) or other insects (aphid honeydew) through regurgitation, enzymatic activity, and water evaporation, and store it in wax structures called honeycombs.[1][2] The variety of honey produced by honey bees (the genus Apis) is the best-known, due to its worldwide commercial production and human consumption.[3] Honey is collected from wild bee colonies, or from hives of domesticated bees, a practice known as beekeeping.\n" +
                "\n" +
                "Honey gets its sweetness from the monosaccharides fructose and glucose, and has about the same relative sweetness as granulated sugar.[4][5] It has attractive chemical properties for baking and a distinctive flavor when used as a sweetener.[4] Most microorganisms do not grow in honey, so sealed honey does not spoil, even after thousands of years.[6][7]\n" +
                "\n",R.drawable.honey))
        listOfFoods.add(Food("Strawberry Ice Cream","Strawberry ice cream is a flavor of ice cream made with strawberry or strawberry flavoring. It is made by blending in fresh strawberries or strawberry flavoring with the eggs, cream, vanilla and sugar used to make ice cream.[1][2] Most strawberry ice cream is colored pink or light red. Strawberry ice cream dates back at least to 1813, when it was served at the second inauguration of James Madison.[3] Along with vanilla and chocolate ice cream, strawberry is one of the three flavors in Neapolitan ice cream. Variations of strawberry ice cream include strawberry cheesecake ice cream and strawberry ripple ice cream, which is vanilla ice cream with a ribbon of strawberry jam or syrup. Some ice cream sandwiches are prepared neapolitan-style, and include strawberry ice cream.",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar cubes","Sugar is the generic name for sweet, soluble carbohydrates, many of which are used in food. There are various types of sugar derived from different sources. Simple sugars are called monosaccharides and include glucose (also known as dextrose), fructose, and galactose. The \"table sugar\" or \"granulated sugar\" most customarily used as food is sucrose, a disaccharide of glucose and fructose. Sugar is used in prepared foods (e.g., cookies and cakes) and it is added to some foods and beverages (e.g., coffee and tea). In the body, sucrose is hydrolysed into the simple sugars fructose and glucose. Other disaccharides include maltose from malted grain, and lactose from milk. Longer chains of sugars are called oligosaccharides or polysaccharides. Some other chemical substances, such as glycerol may also have a sweet taste, but are not classified as sugars. Diet food substitutes for sugar, include aspartame and sucralose, a chlorinated derivative of sucrose.",R.drawable.sugar_cubes))
        foodAdapter= FoodAdapter(this,listOfFoods)
        gv_foodApp.adapter=foodAdapter

    }
}

class FoodAdapter: BaseAdapter{
    var listOfFoods = ArrayList<Food>()
    var context:Context?=null

    constructor(context:Context,listOfFoods:ArrayList<Food>):super(){
        this.context=context
        this.listOfFoods=listOfFoods
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var food = this.listOfFoods[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView=inflator.inflate(R.layout.food_ticket,null)
        foodView.iv_food.setImageResource(food.image!!)
        foodView.iv_food.setOnClickListener {
            val intent = Intent(context,FoodDetails::class.java)
            intent.putExtra("name",food.name!!)
            intent.putExtra("desc",food.desc!!)
            intent.putExtra("image",food.image!!)
            context!!.startActivity(intent)
        }
        foodView.tv_food.text=food.name
        return foodView
    }

    override fun getItem(p0: Int): Any {
        return listOfFoods[p0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getCount(): Int {
        return listOfFoods.size
    }

}
