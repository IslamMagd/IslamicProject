package com.example.islamicapp.ui.quran.soarlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.R;
import com.example.islamicapp.data.pojo.Jozz;
import com.example.islamicapp.data.pojo.Sora;
import com.example.islamicapp.databinding.FragmentQuranContainerBinding;
import com.example.islamicapp.databinding.ListItemSoraBinding;
import com.example.islamicapp.ui.quran.quranindex.QuranIndexFragmentDirections;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SoraLIstAdapter extends RecyclerView.Adapter<SoraLIstAdapter.ViewHolder> {
    private List<?> index;
    private Fragment fragment;


    public SoraLIstAdapter(List<?> index, Fragment fragment) {
        this.index = index;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       return new ViewHolder(ListItemSoraBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (index.get(position) instanceof Sora) {
            holder.bind((Sora) index.get(position));
        } else if (index.get(position) instanceof Jozz) {
            holder.bind((Jozz) index.get(position));
        } else if (index.get(position) instanceof Integer) {
            holder.bind((Integer) index.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return index.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemSoraBinding binding;
        public ViewHolder(ListItemSoraBinding binding) {
            super(binding.getRoot());
            this.binding = binding;}

        public void bind(Sora sora) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));
            binding.listItemTvSoraNumber.setText((nf.format(sora.getSoraNumber())+"-"));
            binding.listItemTvSoraName.setText(sora.getArabicName());
            binding.listItemTvSoraStart.setText(nf.format(sora.getStartBage()));
            binding.listItemTvSoraEnd.setText(nf.format(sora.getEndBage()));
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavHostFragment.findNavController(fragment).navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranContainerFragment(sora.getStartBage()));
                }
            });
        }
        public void bind(Jozz jozz) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));

            binding.listItemTvSoraName.setText((fragment.getString(R.string.jozz)+": "+(nf.format(jozz.getJozzNumber()))));
            binding.listItemTvSoraNumber.setText("");
            binding.listItemTvSoraStart.setText(nf.format(jozz.getStartPage()));
           binding.listItemTvSoraEnd.setText(nf.format(jozz.getEndPage()));

            itemView.setOnClickListener(v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranContainerFragment(jozz.getStartPage())));
        }
        public void bind(Integer page) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));

            binding.listItemTvSoraName.setText((fragment.getString(R.string.page)+" : "+(nf.format(page))));
            binding.listItemTvSoraStart.setVisibility(View.GONE);
            binding.listItemTvSoraEnd.setVisibility(View.GONE);
            binding.listItemTvSoraWordFrom.setVisibility(View.GONE);
            binding.listItemTvSoraWordTo.setVisibility(View.GONE);
            binding.listItemTvSoraNumber.setText("");

            itemView.setOnClickListener(v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranContainerFragment(page)));
        }
    }
}
