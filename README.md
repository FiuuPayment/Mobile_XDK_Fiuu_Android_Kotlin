<!--
 # license: Copyright © 2011-2024 Fiuu. All Rights Reserved.
 -->

# Mobile_XDK_Fiuu_AndroidKotlin

Fiuu Mobile Payment for .NET MAUI

<img src="https://user-images.githubusercontent.com/38641542/74424311-a9d64000-4e8c-11ea-8d80-d811cfe66972.jpg">

This is a complete and functional payment gateway Android Kotlin payment module that is ready to be implemented into Visual Studio / Android Studio as a FiuuXDK module. An example application project (KotlinXdkExample) is provided for FiuuXDK framework integration reference.

## Recommended configurations

- Microsoft Visual Studio Community 2022 (For Windows) / Android Studio latest version

- Minimum Android API level: 19 ++

- Minimum Android target version: Android 4.4

- Android SDK latest

- Android AVD

## Installation

- Create new Kotlin project and implement 'com.github.RazerMS:Mobile-XDK-RazerMS_Android_Library:<tag>'

- Click on Sync Now or build project

- copy this and put in onCreate function.

- to call our payment page call this function on your button or any widget.

```
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
```

## Sample Result

#### Sample transaction result in JSON string:

```

{"status_code":"11","amount":"1.01","chksum":"34a9ec11a5b79f31a15176ffbcac76cd","pInstruction":0,"msgType":"C6","paydate":1459240430,"order_id":"3q3rux7dj","err_desc":"","channel":"Credit","app_code":"439187","txn_ID":"6936766"}

Parameter and meaning:

"status_code" - "00" for Success, "11" for Failed, "22" for *Pending.
(*Pending status only applicable to cash channels only)
"amount" - The transaction amount
"paydate" - The transaction date
"order_id" - The transaction order id
"channel" - The transaction channel description
"txn_ID" - The transaction id generated by Fiuu
```

*Notes: You may ignore other parameters and values not stated above*


#### Sample error result in JSON string:

```
{"Error":"Communication Error"}

Parameter and meaning:

"Communication Error" - Error starting a payment process due to several possible reasons, please contact Fiuu support should the error persists.
1) Internet not available
2) API credentials (username, password, merchant id, verify key)
3) Fiuu server offline.
```

## Prepare the Payment detail object

```
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

```

## Start the payment module

```
binding.fab.setOnClickListener {
    startPaymentXDK()
}

```

## Cash channel payment process (How does it work?)

    This is how the cash channels work on XDK:

    1) The user initiate a cash payment, upon completed, the XDK will pause at the “Payment instruction” screen, the results would return a pending status.

    2) The user can then click on “Close” to exit the Fiuu XDK aka the payment screen.

    3) When later in time, the user would arrive at say 7-Eleven to make the payment, the host app then can call the XDK again to display the “Payment Instruction” again, then it has to pass in all the payment details like it will for the standard payment process, only this time, the host app will have to also pass in an extra value in the payment details, it’s the “mp_transaction_id”, the value has to be the same transaction returned in the results from the XDK earlier during the completion of the transaction. If the transaction id provided is accurate, the XDK will instead show the “Payment Instruction” in place of the standard payment screen.

    4) After the user done the paying at the 7-Eleven counter, they can close and exit Fiuu XDK by clicking the “Close” button again.

## XDK built-in checksum validator caveats

    All XDK come with a built-in checksum validator to validate all incoming checksums and return the validation result through the "mp_secured_verified" parameter. However, this mechanism will fail and always return false if merchants are implementing the private secret key (which the latter is highly recommended and prefereable.) If you would choose to implement the private secret key, you may ignore the "mp_secured_verified" and send the checksum back to your server for validation.

## Private Secret Key checksum validation formula

    chksum = MD5(mp_merchant_ID + results.msgType + results.txn_ID + results.amount + results.status_code + merchant_private_secret_key)

## Resources
- GitHub:     https://github.com/FiuuPayment
- Website:    https://fiuu.com/
- Twitter:    https://twitter.com/FiuuPayment
- YouTube:    https://www.youtube.com/c/FiuuPayment
- Facebook:   https://www.facebook.com/FiuuPayment/
- Instagram:  https://www.instagram.com/FiuuPayment/


## Support

Submit issue to this repository or email to our support@fiuu.com

Merchant Technical Support / Customer Care : support@fiuu.com<br>
Sales/Reseller Enquiry : sales@fiuu.com<br>
Marketing Campaign : marketing@fiuu.com<br>
Channel/Partner Enquiry : channel@fiuu.com<br>
Media Contact : media@fiuu.com<br>
R&D and Tech-related Suggestion : technical@fiuu.com<br>
Abuse Reporting : abuse@fiuu.com
