package android.example.domain

interface BaseModel {

    /**
     * Use in BaseDiffUtil (ListAdapter for RecyclerView)
     */

    open fun isIdDiff(other: BaseModel): Boolean = this.hashCode() == other.hashCode()
    open fun isContentDiff(other: BaseModel): Boolean = this == other
    open fun getPayloadDiff(other: BaseModel): MutableList<Any> = mutableListOf()

}

interface BaseModelWithCheckedAndEnabled : BaseModel {
    val isEnabled : Boolean
    val isChecked : Boolean
}
