package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import eu.rampsoftware.recyclerbinding.BR;

/**
 * Created by Ramps on 2016-09-02.
 */
public class TagsViewModel extends BaseObservable {
    private ObservableList<TagViewModel> mTags = new ObservableArrayList<>();

    public TagsViewModel() {
        initialize();
    }

    public ObservableList<TagViewModel> getTags() {
        return mTags;
    }

    private void initialize() {
        mTags.add(new TagViewModel("Social"));
        mTags.add(new TagViewModel("Sport"));
        mTags.add(new TagViewModel("Tools"));
        mTags.add(new TagViewModel("Foto"));
        mTags.add(new TagViewModel("Books"));
    }

    public int getItemBindingId(){
        return BR.model;
    }

}
