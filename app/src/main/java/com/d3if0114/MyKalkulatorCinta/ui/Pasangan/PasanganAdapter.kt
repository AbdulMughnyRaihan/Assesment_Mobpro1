package com.d3if0114.MyKalkulatorCinta.ui.Pasangan

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d3if0114.MyKalkulatorCinta.R
import com.d3if0114.MyKalkulatorCinta.databinding.ListItemBinding
import com.d3if0114.MyKalkulatorCinta.model.Pasangan
import com.d3if0114.MyKalkulatorCinta.network.ServiceAPI

class PasanganAdapter : RecyclerView.Adapter<PasanganAdapter.ViewHolder>(){

    private val data = mutableListOf<Pasangan>()

    fun updateData(newData: List<Pasangan>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(pasangan : Pasangan) = with(binding){
            judulTextView.text = pasangan.judul
            tglTextView.text = pasangan.tgl
            Glide.with(imageView.context)
                .load(ServiceAPI.getPasanganUrl(pasangan.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)
            tempatTextView.text = pasangan.tempat
            deskripsiTextView.text = pasangan.deskripsi


            root.setOnClickListener{
                val message = root.context.getString(R.string.message, pasangan.judul)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}