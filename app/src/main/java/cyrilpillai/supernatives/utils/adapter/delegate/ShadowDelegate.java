package cyrilpillai.supernatives.utils.adapter.delegate;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import cyrilpillai.supernatives.R;
import cyrilpillai.supernatives.databinding.RvShadowItemBinding;

/**
 * Created by cyrilpillai on 26-11-2017.
 */

public class ShadowDelegate extends AbsListItemAdapterDelegate<ShadowDelegate.ShadowItem, Object,
        ShadowDelegate.ShadowHolder> {

    public ShadowDelegate() {
    }

    @Override
    protected boolean isForViewType(@NonNull Object item, @NonNull List<Object> items,
                                    int position) {
        return item instanceof ShadowItem;
    }

    @NonNull
    @Override
    protected ShadowHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        RvShadowItemBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.getContext()), R.layout.rv_shadow_item, parent, false);
        return new ShadowHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull ShadowItem item, @NonNull ShadowHolder viewHolder,
                                    @NonNull List<Object> payloads) {
    }

    class ShadowHolder extends RecyclerView.ViewHolder {
        private RvShadowItemBinding binding;

        ShadowHolder(RvShadowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class ShadowItem {
    }
}