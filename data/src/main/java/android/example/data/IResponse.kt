package android.example.data

interface IResponse<T> {
    fun toDomainObject(): T
}