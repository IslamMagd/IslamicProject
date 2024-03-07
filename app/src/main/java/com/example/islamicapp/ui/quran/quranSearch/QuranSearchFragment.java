package com.example.islamicapp.ui.quran.quranSearch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapp.R;
import com.example.islamicapp.data.pojo.Aya;
import com.example.islamicapp.databinding.FragmentQuranSearchBinding;

import java.util.ArrayList;


public class QuranSearchFragment extends Fragment {
    private FragmentQuranSearchBinding binding;
    private QuranSearchAdapter adapter;
    private QuranSearchViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new QuranSearchAdapter(this);
        viewModel = new ViewModelProvider(this).get(QuranSearchViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentQuranSearchBinding.inflate(inflater, container, false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.quranSearchRvResult.setAdapter(adapter);
        binding.quranSearchRvResult.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        binding.quranSearchEt.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        ArrayList<Aya> ayat = viewModel.getSearchResult(s.toString());
                        adapter.setAyat(ayat);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

    }
}