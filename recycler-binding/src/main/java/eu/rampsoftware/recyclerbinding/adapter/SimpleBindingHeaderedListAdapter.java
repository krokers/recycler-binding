package eu.rampsoftware.recyclerbinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SimpleBindingHeaderedListAdapter<T> extends RecyclerView.Adapter<SimpleBindingHeaderedListAdapter.BindingHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;

    protected final ObservableList<T> mItems;
    private final int mBindingVariableId;
    private final int mRowLayoutResId;
    private final Object mHeaderModel;
    private final int mBindingVariableIdHeader;
    private final int mHeaderLayoutResId;

    public SimpleBindingHeaderedListAdapter(final ObservableList<T> items, final int bindingVariableId, final int rowLayoutResId,
                                            final Object headerModel, final int bindingVariableIdHeader, final int headerLayoutResId) {
        mItems = items;
        mBindingVariableId = bindingVariableId;
        mRowLayoutResId = rowLayoutResId;
        mHeaderModel = headerModel;
        mBindingVariableIdHeader = bindingVariableIdHeader;
        mHeaderLayoutResId = headerLayoutResId;
        OnBindingListChangedCallback callback = new OnBindingListChangedCallback(this);
        mItems.addOnListChangedCallback(new HeaderedListChangedCallbackWrapper(callback));
    }


    public T getItem(final int position) {
        return mItems.get(position);
    }

    @Override
    public BindingHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v;
        if (viewType == TYPE_HEADER) {
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
        if (isPositionHeader(position)) {
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

    private static class HeaderedListChangedCallbackWrapper extends ObservableList.OnListChangedCallback {

        private final OnBindingListChangedCallback mCallback;

        public HeaderedListChangedCallbackWrapper(OnBindingListChangedCallback callback) {
            this.mCallback = callback;
        }

        @Override
        public void onChanged(ObservableList observableList) {
            mCallback.onChanged(observableList);
        }

        public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
            mCallback.onItemRangeChanged(sender, positionStart + 1, itemCount);
        }

        @Override
        public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
            mCallback.onItemRangeInserted(sender, positionStart + 1, itemCount);
        }

        @Override
        public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
            mCallback.onItemRangeMoved(sender, fromPosition + 1, toPosition + 1, itemCount);
        }

        @Override
        public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
            mCallback.onItemRangeRemoved(sender, positionStart + 1, itemCount);
        }

    }
}
