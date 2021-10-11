package dominando.android.fragments

class HotelListPresenter(
    private val view: HotelListView,
    private val repository: HotelRepository) {

    private var lastTerm = ""
    private var inDeleteMode = false
    private var selectedItems = mutableListOf<Hotel>()

    fun searchHotels(term: String){
        lastTerm = term
        repository.search(term){hotels ->
            view.showHotels(hotels)
        }
    }

    fun selectHotel(hotel: Hotel){
        if (inDeleteMode){
            toggleHotelSelected(hotel)
            if (selectedItems.size == 0){
                view.hideDeleteMode()
            }else{
                view.updateSelectionCount
            }
        }
    }

    fun showHotelDetails(hotel: Hotel){
        view.showHotelDetails(hotel)
    }

}