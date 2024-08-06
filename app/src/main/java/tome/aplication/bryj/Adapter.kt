package tome.aplication.bryj

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tome.aplication.bryj.databinding.ItemEntryBinding

class Adapter(private var items: List<String> = listOf(), private var activity : Activity) : RecyclerView.Adapter<Adapter.ListViewHolder>() {

    class ListViewHolder(val binding: ItemEntryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemEntryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.binding.entryValue.text = items[position]

    }

    override fun getItemCount() = items.size


    fun updateItems(items: List<String>) {
        activity.runOnUiThread {
            this.items = items
            notifyDataSetChanged()
        }
    }
}
