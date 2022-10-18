package kr.ac.kumoh.ce.s20181131.w0701explicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.ce.s20181131.w0701explicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnHomepage.setOnClickListener {
            val uri = Uri.parse("http://www.isntagram.com/dlwlrma/")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        binding.btnMap.setOnClickListener {
            val uri = Uri.parse("geo:0,0?z=17&q=경북 구미시 산호대로18-3")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        binding.btnSms.setOnClickListener {
            val uri = Uri.parse("tel:010-2855-0838")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            //startActivity(intent)
            if (intent.resolveActivity(packageManager)!= null)
            {
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"연결할 앱이 업습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}