package com.example.islamicapp.ui.quran.quranSearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamicapp.data.pojo.Aya;
import com.example.islamicapp.databinding.ListItemQuranSearchBinding;
import com.example.islamicapp.databinding.ListItemSoraBinding;
import com.example.islamicapp.ui.quran.soarlist.SoraLIstAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class QuranSearchAdapter extends RecyclerView.Adapter<QuranSearchAdapter.viewHolder> {
    private ArrayList<Aya> ayat;
    private Fragment fragment;
    public QuranSearchAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setAyat(ArrayList<Aya> ayat) {
        this.ayat = ayat;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(ListItemQuranSearchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(ayat.get(position));

    }

    @Override
    public int getItemCount() {
        return ayat == null ? 0 : ayat.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private final ListItemQuranSearchBinding binding;

        public viewHolder(ListItemQuranSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Aya aya) {
            NumberFormat nf = NumberFormat.getInstance(new Locale("ar", "EG"));
            binding.listItemSearchTvSoraNo.setText(nf.format(aya.getSora()));
            binding.listItemSearchTvAyaNo.setText(nf.format(aya.getAya_no()));
            binding.listItemSearchTvSoraName.setText(aya.getAya_text());
            binding.listItemSearchTvAyaContent.setText(aya.getAya_text_emlaey());
            binding.getRoot().setOnClickListener(v ->
                    NavHostFragment.findNavController(fragment).
                            navigate(QuranSearchFragmentDirections.
                                    actionQuranSearchFragmentToQuranContainerFragment(aya.getPage()))

            );
        }
    }
}




