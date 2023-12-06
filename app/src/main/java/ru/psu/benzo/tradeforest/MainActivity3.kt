package ru.psu.benzo.tradeforest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

//      *** Get intent from main activity
        val bundle = intent.extras

        bundle?.let{
            Toast.makeText(
                this,
                bundle.getString("MY_PARAM2", "NO PARAM"),
                Toast.LENGTH_LONG
            )?.show()
        }?:run{
            Toast.makeText(
                this,
                "PARAM_DENIED",
                Toast.LENGTH_LONG
            ).show()
        }

//      *** Send intent to main activity
        onBackPressedDispatcher.addCallback(this /* lifecycle owner */, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Back is pressed... Finishing the activity
                val data = Intent()
                data.putExtra("S_KEY","s_name")
                data.putExtra("M_KEY","m_name")
                data.putExtra("N_KEY","n_name")
                setResult(RESULT_OK,data)
                finish()
            }
        })

    }

}



