package eu.rampsoftware.recyclerbinding.extensions;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import eu.rampsoftware.recyclerbinding.adapter.SimpleBindingHeaderedListAdapter;
import eu.rampsoftware.recyclerbinding.adapter.SimpleBindingListAdapter;


public class RecyclerViewExtensions {

    @BindingAdapter({"bind:headerModel", "bind:headerLayout", "bind:headerBindingId",
            "bind:items", "bind:itemLayout", "bind:itemBindingId"})
    public static void createAdapter(final RecyclerView list, Object headerModel, int headerLayout, int headerBindingId,
                                     ObservableList items, int itemLayout, int itemBindingId) {
        createAdapter(list, headerModel, headerLayout, headerBindingId, items, itemLayout, itemBindingId, LinearLayoutManager.VERTICAL);
    }

    @BindingAdapter({"bind:headerModel", "bind:headerLayout", "bind:headerBindingId",
            "bind:items", "bind:itemLayout", "bind:itemBindingId", "bind:orientation"})
    public static void createAdapter(final RecyclerView list, Object headerModel, int headerLayout, int headerBindingId,
                                     ObservableList items, int itemLayout, int itemBindingId, int orientation) {
        if (null == list.getAdapter()) {
            SimpleBindingHeaderedListAdapter adapter = new SimpleBindingHeaderedListAdapter(items, itemBindingId, itemLayout, headerModel, headerBindingId, headerLayout);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(list.getContext());
            list.setLayoutManager(layoutManager);
            list.setAdapter(adapter);
        }
    }

    @BindingAdapter({"bind:items", "bind:itemLayout", "bind:itemBindingId"})
    public static void createAdapter(final RecyclerView list, ObservableList items, int itemLayout, int itemBindingId) {
        createAdapter(list, items, itemLayout, itemBindingId, LinearLayoutManager.VERTICAL);
    }

    @BindingAdapter({"bind:items", "bind:itemLayout", "bind:itemBindingId", "bind:orientation"})
    public static void createAdapter(final RecyclerView list, ObservableList items, int itemLayout, int itemBindingId, int orientation) {
        if (null == list.getAdapter()) {
            SimpleBindingListAdapter adapter = new SimpleBindingListAdapter(items, itemBindingId, itemLayout);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(list.getContext());
            layoutManager.setOrientation(orientation);
            list.setLayoutManager(layoutManager);
            list.setAdapter(adapter);
        }
    }
}
