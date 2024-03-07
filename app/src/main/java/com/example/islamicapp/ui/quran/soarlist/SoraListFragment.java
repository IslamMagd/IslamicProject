package com.example.islamicapp.ui.quran.soarlist;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapp.R;
import com.example.islamicapp.data.pojo.Sora;
import com.example.islamicapp.data.utils.IndexTabsUtils;
import com.example.islamicapp.databinding.FragmentQuranPageBinding;
import com.example.islamicapp.databinding.FragmentSoraListBinding;


public class SoraListFragment extends Fragment {

    private FragmentSoraListBinding binding;
    private SoraListViewModel viewModel;
    private IndexTabsUtils.QuranTabs currentTab;
    public SoraListFragment(IndexTabsUtils.QuranTabs currentTab) {
        this.currentTab = currentTab;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSoraListBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SoraListViewModel.class);
        binding.fragmentSoraListRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.fragmentSoraListRv.setAdapter(new SoraLIstAdapter(viewModel.provideIndexList(currentTab),this));

    }

}