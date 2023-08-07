package juan.gutierrez.contador

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var cuenta: Int = 0

    lateinit var contador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contador = findViewById(R.id.txtView_cuenta)
        val increment: ImageView = findViewById(R.id.imgView_increment)
        val decrement: ImageView = findViewById(R.id.imgView_decrement)
        val reset: ImageView = findViewById(R.id.imgView_reset)

        increment.setOnClickListener{
            cuenta++
            contador.setText("$cuenta")
            //Toast.makeText(this, "Incrementa" , Toast.LENGTH_SHORT).show()
        }

        decrement.setOnClickListener{
            cuenta--
            contador.setText("$cuenta")
            //Toast.makeText(this,"Decrementa", Toast.LENGTH_LONG).show()
        }

        reset.setOnClickListener{
            cuenta = 0
            contador.setText("$cuenta")
            //Toast.makeText(this,"Reinicia conteo", Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()

        //Toast.makeText(this,"Se ejecuta onPause()", Toast.LENGTH_LONG).show()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.putInt("Contador", cuenta)
        editor?.apply()
    }

    override fun onStart() {
        super.onStart()

        //Toast.makeText(this,"Se ejecuta onStart()", Toast.LENGTH_LONG).show()
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)?: return
        val Contador = sharedPref.getInt("Contador", 0)
        cuenta = Contador
        contador.setText("$Contador")
    }

    /*override fun onStop() {
        super.onStop()

        //Toast.makeText(this,"Se ejecuta onStop()", Toast.LENGTH_LONG).show()
    }*/

    /*override fun onRestart() {
        super.onRestart()

        //Toast.makeText(this,"Se ejecuta onRestart()", Toast.LENGTH_LONG).show()
    }*/

    /*override fun onResume() {
        super.onResume()

        //Toast.makeText(this,"Se ejecuta onResume()", Toast.LENGTH_LONG).show()
    }*/

    /*override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this,"Se ejecuta onDestroy()", Toast.LENGTH_LONG).show()
    }*/
}