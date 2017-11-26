package cyrilpillai.supernatives.utils.adapter.delegate;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.RvHorizontalDividerItemBinding;

/**
 * Created by cyrilpillai on 26-11-2017.
 */

public class HorizontalDividerDelegate extends AbsListItemAdapterDelegate<
        HorizontalDividerDelegate.HorizontalDividerItem,
        Object, HorizontalDividerDelegate.DividerHolder> {

    public HorizontalDividerDelegate() {
    }

    @Override
    protected boolean isForViewType(@NonNull Object item, @NonNull List<Object> items,
                                    int position) {
        return item instanceof HorizontalDividerItem;
    }

    @NonNull
    @Override
    protected DividerHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        RvHorizontalDividerItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.rv_horizontal_divider_item, parent, false);
        return new DividerHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull HorizontalDividerItem item,
                                    @NonNull DividerHolder viewHolder,
                                    @NonNull List<Object> payloads) {

    }

    class DividerHolder extends RecyclerView.ViewHolder {
        private RvHorizontalDividerItemBinding binding;

        DividerHolder(RvHorizontalDividerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class HorizontalDividerItem {
    }

}