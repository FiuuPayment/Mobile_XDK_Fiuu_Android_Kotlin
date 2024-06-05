package com.example.kotlinxdkexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinxdkexample.databinding.ActivityMainBinding
import com.molpay.molpayxdk.MOLPayActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            startPaymentXDK()
        }

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                Log.d(
                    MOLPayActivity.MOLPAY,
                    "MOLPay result = " + data!!.getStringExtra(MOLPayActivity.MOLPayTransactionResult)
                )
                val tw = findViewById<View>(R.id.resultTV) as TextView
                tw.text = data.getStringExtra(MOLPayActivity.MOLPayTransactionResult)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId

        if (id == R.id.newBtn) {
            startPaymentXDK()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun startPaymentXDK() {
        val paymentDetails: HashMap<String, Any> = HashMap()
        paymentDetails[MOLPayActivity.mp_amount] = "1.10"

        paymentDetails[MOLPayActivity.mp_username] = ""
        paymentDetails[MOLPayActivity.mp_password] = ""
        paymentDetails[MOLPayActivity.mp_merchant_ID] = ""
        paymentDetails[MOLPayActivity.mp_app_name] = "mobile"
        paymentDetails[MOLPayActivity.mp_verification_key] = ""

        paymentDetails[MOLPayActivity.mp_order_ID] = Calendar.getInstance().getTimeInMillis()
        paymentDetails[MOLPayActivity.mp_currency] = "MYR"
        paymentDetails[MOLPayActivity.mp_country] = "MY"
        paymentDetails[MOLPayActivity.mp_channel] = "multi"
        paymentDetails[MOLPayActivity.mp_bill_description] = "bill description"
        paymentDetails[MOLPayActivity.mp_bill_name] = "bill name"
        paymentDetails[MOLPayActivity.mp_bill_email] = "@gmail.com"
        paymentDetails[MOLPayActivity.mp_bill_mobile] = ""
        paymentDetails[MOLPayActivity.mp_channel_editing] = false
        paymentDetails[MOLPayActivity.mp_editing_enabled] = true
        paymentDetails[MOLPayActivity.mp_express_mode] = false
        paymentDetails[MOLPayActivity.mp_dev_mode] = false
        paymentDetails[MOLPayActivity.mp_preferred_token] = "new"

        val intent = Intent(this@MainActivity, MOLPayActivity::class.java)
        intent.putExtra(MOLPayActivity.MOLPayPaymentDetails, paymentDetails)
        startForResult.launch(intent)
    }
}