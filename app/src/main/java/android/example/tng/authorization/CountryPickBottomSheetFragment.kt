package android.example.tng.authorization

import android.app.Dialog
import android.example.domain.model.CountryModel
import android.example.tng.R
import android.example.tng.databinding.FragmentListMinRvBinding
import android.graphics.Point
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment



class CountryPickBottomSheetFragment(val updateCountry : (country: CountryModel) -> Unit = {}) : BottomSheetDialogFragment() {

    lateinit var binding: FragmentListMinRvBinding
    private lateinit var behavior : BottomSheetBehavior<View>
    private val countries: MutableList<CountryModel> = mutableListOf()

    private val countriesAdapter = CountryAdapter(this::countryClick)

    private fun countryClick(country: CountryModel) {
        updateCountry(country)
        dismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        initCountries()
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialog)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val countriesSheet = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = View.inflate(context, R.layout.fragment_list_min_rv, null)
        binding = FragmentListMinRvBinding.bind(view)
        val disp = activity?.windowManager?.defaultDisplay
        val point = Point()
        disp?.getRealSize(point)
        with(binding) {
            rvList.apply {
//                rvHeight = (point.y * 0.4).toInt()
                adapter = countriesAdapter
            }
        }
        countriesAdapter.setCountries(countries)
        countriesSheet.setContentView(view)
        behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.peekHeight = 500
        (view.parent as View).setBackgroundResource(android.R.color.transparent)
        return countriesSheet
    }

    override fun onStart() {
        super.onStart()
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        behavior.skipCollapsed = true
    }

    private fun initCountries() {
        countries.apply {
            add(CountryModel("+7", "Россия", R.drawable.ic_rus, listOf(8,10)))
            add(CountryModel("+7", "Казахстан", R.drawable.ic_kz, listOf(8)))
//            add(CountryModel("+375", "Беларусь", R.drawable.ic_bru, listOf(9)))
//            add(CountryModel("+373", "Молдова", R.drawable.ic_mld, listOf(8)))
//            add(CountryModel("+972", "Израиль", R.drawable.ic_isr, listOf(9)))
//            add(CountryModel("+998", "Узбекистан", R.drawable.ic_uzb, listOf(9)))
//            add(CountryModel("+371", "Латвия", R.drawable.ic_ltv, listOf(8)))
//            add(CountryModel("+380", "Украина", R.drawable.ic_ukr, listOf(9)))
            add(CountryModel("+996", "Киргизия", R.drawable.ic_krg, listOf(9)))
//            add(CountryModel("+374", "Армения", R.drawable.ic_arm, listOf(8)))
//            add(CountryModel("+49", "Германия", R.drawable.ic_germ, listOf(10)))
//            add(CountryModel("+1", "США", R.drawable.ic_usa, listOf(10)))
//            add(CountryModel("+372", "Эстония", R.drawable.ic_est, listOf(7)))
//            add(CountryModel("+995", "Грузия", R.drawable.ic_grg, listOf(9)))
        }
    }
}