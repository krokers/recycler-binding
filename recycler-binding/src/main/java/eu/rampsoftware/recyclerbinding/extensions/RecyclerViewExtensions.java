package eu.rampsoftware.recyclerbinding.extensions;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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

    @BindingAdapter({
            "bind:items",
            "bind:itemLayout",
            "bind:itemBindingId",
            "bind:layoutType",
            "bind:spanCount"})
    public static void createAdapterStaggeredGrid(final RecyclerView list,
                                                  ObservableList items, int itemLayout,
                                                  int itemBindingId,
                                                  @LayoutManagerType.LayoutType int layoutType,
                                                  int spanCount) {
        createAdapterStaggeredGrid(list, items, itemLayout, itemBindingId, spanCount, layoutType, LinearLayoutManager.VERTICAL);
    }

    @BindingAdapter({
            "bind:items",
            "bind:itemLayout",
            "bind:itemBindingId",
            "bind:spanCount"})
    public static void createAdapterStaggeredGrid(final RecyclerView list,
                                                  ObservableList items, int itemLayout,
                                                  int itemBindingId, int spanCount) {
        createAdapterStaggeredGrid(list, items, itemLayout, itemBindingId, spanCount, LayoutManagerType.GRID, LinearLayoutManager.VERTICAL);
    }

    @BindingAdapter({
            "bind:items",
            "bind:itemLayout",
            "bind:itemBindingId",
            "bind:spanCount",
            "bind:layoutType",
            "bind:orientation"})
    public static void createAdapterStaggeredGrid(final RecyclerView list,
                                                  ObservableList items,
                                                  int itemLayout, int itemBindingId,
                                                  int spanCount,
                                                  @LayoutManagerType.LayoutType int layoutType,
                                                  int orientation) {
        if (null == list.getAdapter()) {
            SimpleBindingListAdapter adapter = new SimpleBindingListAdapter(items, itemBindingId, itemLayout);
            RecyclerView.LayoutManager layoutManager = createLayoutManager(list, spanCount, layoutType, orientation);
            list.setLayoutManager(layoutManager);
            list.setAdapter(adapter);
        }
    }

    @NonNull
    private static RecyclerView.LayoutManager createLayoutManager(RecyclerView list, int spanCount, @LayoutManagerType.LayoutType int layoutType, int orientation) {
        RecyclerView.LayoutManager layoutManager;
        switch (layoutType) {
            default:
            case LayoutManagerType.LINEAR:
                layoutManager = new LinearLayoutManager(list.getContext(), orientation, false);
                break;
            case LayoutManagerType.GRID:
                layoutManager = new GridLayoutManager(list.getContext(), spanCount, orientation, false);
                break;
            case LayoutManagerType.STAGGERED_GRID:
                layoutManager = new StaggeredGridLayoutManager(spanCount, orientation);
                break;
        }
        return layoutManager;
    }

}
