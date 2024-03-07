package com.example.islamicapp.ui.quran.quranSearch;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.islamicapp.data.database.QuranDao;
import com.example.islamicapp.data.database.QuranDatabase;
import com.example.islamicapp.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchViewModel extends AndroidViewModel {
    public QuranSearchViewModel(@NonNull Application application) {
        super(application);
    }
    public ArrayList<Aya> getSearchResult(String keyword) {
        QuranDao dao = QuranDatabase.getInstance(getApplication()).quranDao();
        return (ArrayList<Aya>) dao.getAyaBySubText(keyword);
    }
}
