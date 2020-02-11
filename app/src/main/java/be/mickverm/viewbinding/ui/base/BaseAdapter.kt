package be.mickverm.viewbinding.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

private typealias AdapterViewBindingInflater<VB> = (
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
) -> VB

abstract class BaseAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    fun <VB : ViewBinding> ViewGroup.inflateBinding(
        bindingInflater: AdapterViewBindingInflater<VB>
    ): VB {
        return bindingInflater.invoke(LayoutInflater.from(context), this, false)
    }

    abstract class BaseViewHolder<VB : ViewBinding>(
        binding: VB
    ) : RecyclerView.ViewHolder(binding.root)
}