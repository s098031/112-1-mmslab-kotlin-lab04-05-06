package com.example.a112_1_mmslab_kotlin_lab06

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.a112_1_mmslab_kotlin_lab06.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("根據下方按鈕選擇要顯示的物件")
            dialog.setNeutralButton(
                "取消"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "Dialog關閉",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.setNegativeButton(
                "自定義Toast"
            ) { dialogInterface, i -> showToast() }
            dialog.setPositiveButton(
                "顯示List"
            ) { dialogInterface, i -> showListDialog() }
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater = layoutInflater
        val layout: View = inflater.inflate(
            R.layout.custom_toast,
            findViewById<View>(R.id.custom_toast_root) as ViewGroup?
        )
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("Message1", "Message2", "Message3", "Message4", "Message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(
            list
        ) { dialoginterface, i ->
            Toast.makeText(
                this@MainActivity,
                "你選得是" + list[i],
                Toast.LENGTH_SHORT
            ).show()
        }
        dialog_list.show()
    }
}