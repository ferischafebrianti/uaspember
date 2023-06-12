package com.example.searchbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {

    // deklarasi variabel beserta tipe view yang akan digunakan
    private lateinit var imageView: ImageView
    private lateinit var detailTextView: TextView
    private lateinit var detailTextView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailTextView = findViewById(R.id.textView)
        detailTextView2 = findViewById(R.id.textView2)
        imageView = findViewById(R.id.imageView)

        // Mengambil data dari intent
        val itemImage = intent.getIntExtra("Img", 0)
        val itemName = intent.getStringExtra("name")
        val itemPrice = intent.getStringExtra("price")

        // Gunakan data yang diterima untuk menampilkan detail item
        detailTextView.text = "Type  : $itemName"
        detailTextView2.text = "Price : $itemPrice"
        imageView.setImageResource(itemImage)

//        process beli
        val btnBuy = findViewById<Button>(R.id.btnBuy)
        btnBuy.setOnClickListener {
//            startActivity(Intent(this@DetailActivity))
            Toast.makeText(this, "Pembelian berhasil dilakukan", Toast.LENGTH_SHORT).show()
        }


    }
}