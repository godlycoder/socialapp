package id.banidevv.socialapp.common.core

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseRecyclerAdapter<T, VB: ViewBinding> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemClick: ((T, Int) -> Unit)? = null
    private var items = mutableListOf<T>()

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VB>
        val inflateMethod = bindingClass.getMethod("inflate",
            LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        val binding = inflateMethod.invoke(
            null, LayoutInflater.from(parent.context), parent, false) as VB
        return Holder(binding)
    }

    override fun getItemCount() : Int {
        return items.size
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items.getOrNull(position)
        if (item != null && holder is Holder<*>) {
            (holder as Holder<VB>).apply {
                binding.bind(item, position)
                if (onItemClick != null) holder.itemView.setOnClickListener {
                    onItemClick?.let {
                        listener ->
                        listener(item, position)
                    }
                }
            }
        }
    }

    abstract fun VB.bind(item: T, position: Int)

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<T>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun add(item: T) {
        items.add(item)
        notifyItemInserted(items.size-1)
    }

    fun setItem(position: Int, item: T) {
        items[position] = item
        notifyItemChanged(position)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeAll() {
        items.clear()
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClick: (T, Int) -> Unit) {
        this.onItemClick = onItemClick
    }

    private class Holder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}