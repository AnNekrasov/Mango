package android.example.tng.base

import android.example.domain.BaseModel
import android.view.ViewGroup

interface AdapterDelegate {
    fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder

    fun isValidType(baseModel: BaseModel): Boolean
}