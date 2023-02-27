package dadm.dmfuegar.pl1dadm.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dadm.dmfuegar.pl1dadm.databinding.QuotationItemBinding
import domain.model.Quotation

class QuotationListAdapter(val quotDiff : QuotationDiff) : ListAdapter<Quotation, QuotationListAdapter.ViewHolder>() {
    class ViewHolder(val binding: QuotationItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(q: Quotation){
            binding.textAuthor.text=q.author
            binding.textCita.text=q.nombre
        }

    }
    object QuotationDiff : DiffUtil.ItemCallback<Quotation>() {
        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        //return ProductViewHolder(view)
        val view = ViewHolder(QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return view
    }

    override fun getItemCount(): Int {
        //return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bind(products[position])
        holder.bind(getItem(position))
    }
}