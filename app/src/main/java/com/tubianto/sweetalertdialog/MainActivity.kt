package com.tubianto.sweetalertdialog

import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Tubianto on 13/07/2021.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            val pDialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
            pDialog.progressHelper.barColor = Color.parseColor("#A5DC86")
            pDialog.titleText = "Loading"
            pDialog.setCancelable(false)
            pDialog.show()
        }

        btn_2.setOnClickListener {
            SweetAlertDialog(this)
                .setTitleText("Here's a message!")
                .show()
        }

        btn_3.setOnClickListener {
            SweetAlertDialog(this)
                .setTitleText("Here's a message!")
                .setContentText("It's pretty, isn't it?")
                .show()
        }

        btn_4.setOnClickListener{
            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("Something went wrong!")
                .show()
        }

        btn_5.setOnClickListener{
            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .show()
        }

        btn_6.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("You clicked the button!")
                .show()
        }

        btn_7.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Sweet!")
                .setContentText("Here's a custom image.")
                .setCustomImage(R.drawable.icon)
                .show()
        }

        btn_8.setOnClickListener {
            val editText = EditText(this)
            SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
                .setTitleText("Custom view")
                .setConfirmText("Ok")
                .setCustomView(editText)
                .show()
        }

        btn_9.setOnClickListener{
            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .setConfirmClickListener { sDialog -> sDialog.dismissWithAnimation() }
                .setCancelButton(
                    "Cancel"
                ) { sDialog -> sDialog.dismissWithAnimation() }
                .show()
        }

        btn_10.setOnClickListener {
            val disabledBtnDialog = SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
            .setTitleText("Title")
            .setContentText("Disabled button dialog")
            .setConfirmText("Confirm")
            .setCancelText("Cancel")

            disabledBtnDialog.setOnShowListener {
                disabledBtnDialog.getButton(SweetAlertDialog.BUTTON_CONFIRM).isEnabled = false
            }
            disabledBtnDialog.show()
        }

        btn_11.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .setConfirmClickListener { sDialog ->
                    sDialog
                        .setTitleText("Deleted!")
                        .setContentText("Your imaginary file has been deleted!")
                        .setConfirmText("OK")
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
                }
                .show()
        }
    }
}