package org.d3if0114_mobpro1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if0114_mobpro1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)

        }
    }

    private  fun getData(): List<Stok> {
        return listOf(
            Stok(R.drawable.cocacola, "Coca Cola", "127684242",   20),
            Stok(R.drawable.miesedap, "Mie Sedap", "537645323",   30),
            Stok(R.drawable.miekorea, "Mie korea", "645645645",   28),
            Stok(R.drawable.kecap_abc, "Kecap ABC", "345345531",   41),
            Stok(R.drawable.sgm, "Susu SGM", "345654347",   54),
            Stok(R.drawable.terigu, "Vanish ", "897563456",   20),
            Stok(R.drawable.susu, "Susu Nutrion ", "234576543",   35),
            Stok(R.drawable.vanish, "Vanish ", "653478965",   64),
            Stok(R.drawable.mielemonio, "Mie Lemonio ", "345890098",   18),

            )
    }
}