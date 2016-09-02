package eu.rampsoftware.recyclerbinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class SimpleBindingHeaderedListAdapter<T> extends RecyclerView.Adapter<SimpleBindingHeaderedListAdapter.BindingHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;

    protected final ObservableList<T> mItems;
    private final int mBindingVariableId;
    private final int mRowLayoutResId;
    private final Object mHeaderModel;
    private final int mBindingVariableIdHeader;
    private final int mHeaderLayoutResId;
    private final OnBindingListChangedCallback mOnListChangedCallback;

    public SimpleBindingHeaderedListAdapter(final ObservableList<T> items, final int bindingVariableId, final int rowLayoutResId,
                                            final Object headerModel, final int bindingVariableIdHeader , final int headerLayoutResId) {
        mItems = items;
        mBindingVariableId = bindingVariableId;
        mRowLayoutResId = rowLayoutResId;
        mHeaderModel = headerModel;
        mBindingVariableIdHeader = bindingVariableIdHeader;
        mHeaderLayoutResId = headerLayoutResId;
        this.mOnListChangedCallback = new OnBindingListChangedCallback(this);
        mItems.addOnListChangedCallback(this.mOnListChangedCallback);
    }



    public T getItem(final int position){
        return mItems.get(position);
    }

    @Override
    public BindingHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v;
        if(viewType == TYPE_HEADER){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(mHeaderLayoutResId, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(mRowLayoutResId, parent, false);
        }
        BindingHolder holder = new BindingHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {
        if(isPositionHeader(position)){
            holder.getBinding().setVariable(mBindingVariableIdHeader, mHeaderModel);
            holder.getBinding().executePendingBindings();
        } else {
            T item = mItems.get(position - 1);
            holder.binding.setVariable(mBindingVariableId, item);
            holder.binding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
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
