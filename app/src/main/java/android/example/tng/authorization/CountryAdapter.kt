package android.example.tng.authorization

import android.example.domain.model.CountryModel
import android.example.tng.R
import android.example.tng.databinding.ItemCountryBottomBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CountryAdapter(val updateCountry: (country: CountryModel) -> Unit = {}) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val countries = mutableListOf<CountryModel>()

    fun setCountries(newCountries: MutableList<CountryModel>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country_bottom, parent, false)
        ).apply {
            with(itemView) {
                setOnClickListener {
                    updateCountry(countries[adapterPosition])
                }
            }
        }
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var binding: ItemCountryBottomBinding

        fun bind(country: CountryModel) {
            binding = ItemCountryBottomBinding.bind(itemView)
            with(binding) {
                Glide
                    .with(itemView.context)
                    .load(country.drawableId)
                    .placeholder(R.drawable.nopic)
                    .circleCrop()
                    .into(ivCountry)
                tvCountryCode.text = country.code
                tvCountryName.text =
                    String.format(itemView.context.getString(R.string.country_text), country.name)
            }
        }
    }
}