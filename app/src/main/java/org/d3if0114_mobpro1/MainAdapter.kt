package org.d3if0114_mobpro1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.d3if0114_mobpro1.databinding.ListItemBinding

class MainAdapter(private val stok: List<Stok>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>(), Filterable {

    private var filteredPeople: List<Stok> = stok

    class ViewHolder(private val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root) {
        fun bind(stok: Stok) = with(binding) {
            namabarang.text = stok.namabarang
            codebarang.text = stok.codebarang
            image.setImageResource(stok.image)
            jumlahbarang.text = stok.jumlahbarang.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stok[position])
    }

    override fun getItemCount(): Int {
        return stok.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString()
                filteredPeople = if (query.isEmpty()) {
                    stok
                } else {
                    stok.filter { it.namabarang.contains(query, ignoreCase = true) }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredPeople
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredPeople = results?.values as List<Stok>
                notifyDataSetChanged()
            }
        }
    }
}