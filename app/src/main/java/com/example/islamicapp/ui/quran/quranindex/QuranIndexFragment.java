package com.example.islamicapp.ui.quran.quranindex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapp.R;
import com.example.islamicapp.databinding.FragmentQuranIndexBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class QuranIndexFragment extends Fragment {
   FragmentQuranIndexBinding binding;
    QuranIndexPagerAdapter adapter;
    ViewPager2 pager;
    QuranIndexViewModel viewModel;


    public QuranIndexFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuranIndexBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new QuranIndexPagerAdapter(this);
        binding.quranIndexPager.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(QuranIndexViewModel.class);
        new TabLayoutMediator(binding.quranIndexTabs,binding.quranIndexPager,
                (tab, position) -> tab.setText(viewModel.getTabAt(position))
        ).attach();
        binding.quranIndexEtSearch.setOnClickListener(v ->
                NavHostFragment
                        .findNavController(this)
                        .navigate(QuranIndexFragmentDirections
                                .actionQuranIndexFragmentToQuranSearchFragment()));
    }
}