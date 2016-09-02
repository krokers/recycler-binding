package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.text.TextUtils;

import eu.rampsoftware.recyclerbinding.BR;

public class MainActivityViewModel extends BaseObservable {


    private ObservableList<MobileApplicationViewModel> mApplications = new ObservableArrayList<>();
    private TagsViewModel mTags = new TagsViewModel();
    private String mNewName;

    public MainActivityViewModel() {
        initializeModel();
    }

    @Bindable
    public String getNewName() {
        return mNewName;
    }

    public void setNewName(String newName) {
        mNewName = newName;
        notifyPropertyChanged(BR.newName);
    }

    public TagsViewModel getTags() {
        return mTags;
    }

    public ObservableList<MobileApplicationViewModel> getApplications() {
        return mApplications;
    }

    private void initializeModel() {
        addApplication("Facebook");
        addApplication("Challenger");
        addApplication("Instagram");
        addApplication("Snapchat");
    }

    public int getHeaderBindingId() {
        return BR.model;
    }

    public int getItemBindingId() {
        return BR.model;
    }

    public void actionAdd(Object source) {
        if (!TextUtils.isEmpty(mNewName)) {
            addApplication(mNewName);
            setNewName("");
        }
    }

    private void addApplication(String name) {
        mApplications.add(new MobileApplicationViewModel(name));
    }
}
