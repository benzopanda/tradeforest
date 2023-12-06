package ru.psu.benzo.tradeforest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import ru.psu.benzo.tradeforest.databinding.CalcActivityBinding

class CalcActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private lateinit var binding : CalcActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalcActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // The Toolbar defined in the layout has the id "my_toolbar".
        setSupportActionBar(binding.myToolbar)


        binding.textViewOutput.text = getString(R.string._initial_output)

        binding.buttonPlus.setOnLongClickListener {
            val intent = Intent(this,MainActivity2::class.java).apply {
                putExtra("MY_PARAM1", "1234567890") }
            startActivity(intent)
            return@setOnLongClickListener true
        }

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data?.extras
                Toast.makeText(this, "Data received", Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonMinus.setOnLongClickListener {
            val intent = Intent(this,MainActivity3::class.java).apply {
                putExtra("MY_PARAM2", "0987654321") }
            resultLauncher.launch(intent)
            return@setOnLongClickListener true
        }



    }
    fun onButtonPlusClick(view : View)
    {
        if(!binding.editTextValue1.editText?.text.isNullOrEmpty() && !binding.editTextValue2.editText?.text.isNullOrEmpty()) {
            val val1 = binding.editTextValue1.editText?.text.toString().toDouble()
            val val2 = binding.editTextValue2.editText?.text.toString().toDouble()
            binding.textViewOutput.text = "  " + (val1 + val2)
        }
    }
    fun onButtonMinusClick(view : View)
    {
        if(!binding.editTextValue1.editText?.text.isNullOrEmpty() && !binding.editTextValue2.editText?.text.isNullOrEmpty()) {
            val val1 = binding.editTextValue1.editText?.text.toString().toDouble()
            val val2 = binding.editTextValue2.editText?.text.toString().toDouble()
            binding.textViewOutput.text = "  "+(val1-val2)
        }
    }
    fun onButtonMulClick(view : View)
    {
        if(!binding.editTextValue1.editText?.text.isNullOrEmpty() && !binding.editTextValue2.editText?.text.isNullOrEmpty()) {
            val val1 = binding.editTextValue1.editText?.text.toString().toDouble()
            val val2 = binding.editTextValue2.editText?.text.toString().toDouble()
            binding.textViewOutput.text = "  "+(val1*val2)
        }
    }
    fun onButtonDivClick(view : View)
    {
        if(!binding.editTextValue1.editText?.text.isNullOrEmpty() && !binding.editTextValue2.editText?.text.isNullOrEmpty()) {
            val val1 = binding.editTextValue1.editText?.text.toString().toDouble()
            val val2 = binding.editTextValue2.editText?.text.toString().toDouble()
            binding.textViewOutput.text = "  "+(val1/val2)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.activity_tradeforest_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.settings -> {
                Toast.makeText(
                    this,
                    "Button pressed!",
                    Toast.LENGTH_LONG
                ).show()
                true
            }
            R.id.help -> {
                Toast.makeText(
                    this,
                    "Daddy chill!",
                    Toast.LENGTH_LONG
                ).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }







}