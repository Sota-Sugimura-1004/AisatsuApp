package jp.techacademy.sota.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> setTimePickerDialog()
        }
    }

    private fun setTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                //時刻に応じて挨拶を表示
                setAisatsu(hour)
            },
            13, 0, true)

        timePickerDialog.show()
    }

    private fun setAisatsu(time:Int){
        when{
            (time >= 2) && (time < 10) -> textView.text = "おはよう"
            (time >= 10) && (time < 18) -> textView.text = "こんにちは"
            (time >= 18) || (time < 2) -> textView.text = "こんばんは"
        }
    }

}