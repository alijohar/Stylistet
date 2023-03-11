package com.amorphteam.stylistet.launcher.collection

import androidx.lifecycle.ViewModel
import com.amorphteam.stylistet.R

class CollectionViewModel : ViewModel() {

    val collections = listOf(
        CollectionData(1, R.drawable.collection1,"sam1"),
        CollectionData(2, R.drawable.collection2,"sam2"),
        CollectionData(3, R.drawable.collection3,"sam3"),
        CollectionData(4, R.drawable.collection4,"sam4"),
        CollectionData(5, R.drawable.collection5,"sam5"),
        CollectionData(6, R.drawable.collection6,"sam6"),
        CollectionData(7, R.drawable.collection7,"sam7"),
        CollectionData(8, R.drawable.collection8,"sam8"),
        CollectionData(9, R.drawable.collection9,"sam9"),
        CollectionData(10, R.drawable.collection1,"sam10"),
        CollectionData(11, R.drawable.collection2,"sam11"),
        CollectionData(12, R.drawable.collection3,"sam12")
    )
}