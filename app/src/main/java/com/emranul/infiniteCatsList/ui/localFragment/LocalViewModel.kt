package com.emranul.infiniteCatsList.ui.localFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.emranul.infiniteCatsList.data.repositories.CatRepositories
import com.emranul.infiniteCatsList.data.response.CatResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalViewModel @Inject constructor(private val repositories:CatRepositories) : ViewModel() {

    val localCatsList = repositories.getLocalCats().cachedIn(viewModelScope)

    fun saveCate(catResponseItem: CatResponseItem) = viewModelScope.launch(Dispatchers.IO) {
        repositories.saveCat(catResponseItem)
    }

    fun delete(catResponseItem: CatResponseItem) = viewModelScope.launch(Dispatchers.IO) {
        repositories.deleteCat(catResponseItem)
    }

}