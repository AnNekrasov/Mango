package android.example.tng.base

import android.example.domain.BaseModel
import androidx.collection.SparseArrayCompat

class AdapterDelegateManager {

    private var delegates: SparseArrayCompat<AdapterDelegate> = SparseArrayCompat()

    fun addDelegate(delegate: AdapterDelegate) = delegates.put(delegates.size(), delegate)

    fun addDelegate(vararg delegate: AdapterDelegate) {
        delegate.forEach {
            delegates.put(delegates.size(), it)
        }
    }

    fun getDelegate(viewType: Int): AdapterDelegate = delegates[viewType]!!

    fun getItemViewType(postModel: BaseModel): Int{
        for (i in 0 until delegates.size()){
            delegates[i]?.let {
                if (it.isValidType(postModel)) {
                    return delegates.keyAt(i)
                }
            }
        }

        throw NullPointerException("Delegate not found for $postModel")
    }
}