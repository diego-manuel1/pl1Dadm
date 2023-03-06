package dadm.dmfuegar.pl1dadm.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dadm.dmfuegar.pl1dadm.databinding.QuotationItemBinding
import domain.model.Quotation

class QuotationListAdapter(val quotDiff : QuotationDiff, val itemClicked: ItemClicked) : ListAdapter<Quotation, QuotationListAdapter.ViewHolder>() {
    class ViewHolder(val binding: QuotationItemBinding, val itemClicked: ItemClicked) : RecyclerView.ViewHolder(binding.root){
        fun bind(q: Quotation){
            binding.textAuthor.text=q.author
            binding.textCita.text=q.content
        }
        init {
            binding.root.setOnClickListener {
                itemClicked.onClick(binding.textAuthor.text.toString())
            }
        }

    }
    interface ItemClicked { fun onClick(author: String) }
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