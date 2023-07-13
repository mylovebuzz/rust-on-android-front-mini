package cn.com.companyname.rustonandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

/* Empty Views Activity */
class MainActivity : AppCompatActivity() {

    private external fun doSth(pattern: String): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtRustResult: TextView = findViewById(R.id.rustResult)
        try {
            System.loadLibrary("rust_on_android")
            val responseFormRust = doSth("in onCreate")
            txtRustResult.text = responseFormRust
        } catch (e: Exception) {
            txtRustResult.text = e.stackTraceToString()
        }
    }

    fun callRust(view: View) {
        view.accessibilityClassName
        val txtRustResult: TextView = findViewById(R.id.txtRustCallResult)
        try {
            val responseFormRust = doSth("in onCreate")
            txtRustResult.text = responseFormRust
        } catch (e: Exception) {
            txtRustResult.text = e.stackTraceToString()
        }
    }
}
