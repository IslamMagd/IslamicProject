package com.example.islamicapp.ui.quran.quranContainer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapp.databinding.FragmentQuranContainerBinding;



public class QuranContainerFragment extends Fragment {

    private QuranContainerFragmentArgs args;
    private FragmentQuranContainerBinding binding;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        args = QuranContainerFragmentArgs.fromBundle(requireArguments());
        // Inflate the layout for this fragment
        binding = FragmentQuranContainerBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = binding.fragmentQuranContainerPager;
        pagerAdapter = new QuranPagesAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(604-args.getStartPage(),false);

    }
}