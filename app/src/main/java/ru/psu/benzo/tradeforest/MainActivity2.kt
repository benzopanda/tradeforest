package ru.psu.benzo.tradeforest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = getIntent().getExtras();

        bundle?.let{
            Toast.makeText(
                this,
                bundle.getString("MY_PARAM1", "NO PARAM"),
                Toast.LENGTH_LONG
            )?.show()
        }?:run{
            Toast.makeText(
                this,
                "PARAM_DENIED",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}