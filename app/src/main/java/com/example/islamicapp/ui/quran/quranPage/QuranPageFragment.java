package com.example.islamicapp.ui.quran.quranPage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapp.R;
import com.example.islamicapp.databinding.FragmentQuranPageBinding;


public class QuranPageFragment extends Fragment {
    private FragmentQuranPageBinding binding;
    private QuranViewModel quranViewModel;
    private final int pageNumber;
    public QuranPageFragment(int pageNumber){
       this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        quranViewModel = new ViewModelProvider(this).get(QuranViewModel.class);
        // Inflate the layout for this fragment
        binding = FragmentQuranPageBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Drawable quranPage = quranViewModel.getQuranImageByPageNumber(pageNumber);
        binding.fragmentQuranPageIv.setImageDrawable(quranPage);
        
    }
}