package com.example.islamicapp.ui.quran.quranindex;

import androidx.lifecycle.ViewModel;

import com.example.islamicapp.data.utils.IndexTabsUtils;

public class QuranIndexViewModel extends ViewModel {
    private int[] tabsList;

    public QuranIndexViewModel() {
        tabsList = IndexTabsUtils.QURAN_INDEX_TABS;
    }

    public int getTabAt(int position) {
        return tabsList[position];
    }
}
