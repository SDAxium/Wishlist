package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val nameTextField = findViewById<TextView>(R.id.itemName)
        val urlTextField = findViewById<TextView>(R.id.itemURL)
        val priceTextField = findViewById<TextView>(R.id.price)

        val listRv = findViewById<RecyclerView>(R.id.listRv)
        items = ListFetcher.GetWishList()
        val adapter = ItemAdapter(items)

        listRv.adapter = adapter
        listRv.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            if (nameTextField.text.toString().trim().isBlank() || urlTextField.toString().trim().isBlank() ||
                    priceTextField.text.toString().trim().isBlank()){
                val toast = Toast.makeText(this,"Complete all fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val newItem = Item(nameTextField.text.toString(),urlTextField.text.toString(),priceTextField.text.toString())
            items.add(newItem)
            nameTextField.text = ""
            urlTextField.text = ""
            priceTextField.text = ""
            adapter.notifyDataSetChanged()
        }
    }
}