package eu.rampsoftware.recyclerbinding.adapter;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;

class OnBindingListChangedCallback extends ObservableList.OnListChangedCallback {

        private final WeakReference<RecyclerView.Adapter> mAdapterWeakRef;

        public OnBindingListChangedCallback(RecyclerView.Adapter adapter) {
            this.mAdapterWeakRef = new WeakReference<>(adapter);
        }

        @Override
        public void onChanged(ObservableList sender) {
            RecyclerView.Adapter adapter = mAdapterWeakRef.get();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
            RecyclerView.Adapter adapter = mAdapterWeakRef.get();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(positionStart, itemCount);
            }
        }

        @Override
        public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
            RecyclerView.Adapter adapter = mAdapterWeakRef.get();
            if (adapter != null) {
                adapter.notifyItemRangeInserted(positionStart + 1, itemCount);
            }
        }

        @Override
        public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
            RecyclerView.Adapter adapter = mAdapterWeakRef.get();
            if (adapter != null) {
                adapter.notifyItemMoved(fromPosition, toPosition);
            }
        }

        @Override
        public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
            RecyclerView.Adapter adapter = mAdapterWeakRef.get();
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(positionStart, itemCount);
            }
        }
    }