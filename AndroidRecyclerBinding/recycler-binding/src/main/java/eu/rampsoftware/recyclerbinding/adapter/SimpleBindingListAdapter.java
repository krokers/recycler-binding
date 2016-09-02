package eu.rampsoftware.recyclerbinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Created by Rafal on 2016-02-20.
 */
public class SimpleBindingListAdapter<T> extends RecyclerView.Adapter<SimpleBindingListAdapter.BindingHolder> {

    protected final ObservableList<T> mItems;
    private final int mBindingVariableId;
    private final int mRowLayoutResId;
    private final OnBindingListChangedCallback mOnListChangedCallback;

    public SimpleBindingListAdapter(final ObservableList<T> items, final int bindingVariableId, final int rowLayoutResId) {
        mItems = items;
        mBindingVariableId = bindingVariableId;
        mRowLayoutResId = rowLayoutResId;
        this.mOnListChangedCallback = new OnBindingListChangedCallback(this);
        mItems.addOnListChangedCallback(this.mOnListChangedCallback);
    }

    public T getItem(final int position) {
        return mItems.get(position);
    }

    @Override
    public BindingHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(mRowLayoutResId, parent, false);
        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {
        T item = mItems.get(position);
        holder.binding.setVariable(mBindingVariableId, item);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View rowView) {
            super(rowView);
            binding = DataBindingUtil.bind(rowView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }


}
