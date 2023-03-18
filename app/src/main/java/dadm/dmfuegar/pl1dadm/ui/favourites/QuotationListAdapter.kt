package dadm.dmfuegar.pl1dadm.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dadm.dmfuegar.pl1dadm.databinding.QuotationItemBinding
import dadm.dmfuegar.pl1dadm.domain.model.Quotation

class QuotationListAdapter(val itemClicked: ItemClicked) : ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff) {
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
        val view = ViewHolder(QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), itemClicked)
        return view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}