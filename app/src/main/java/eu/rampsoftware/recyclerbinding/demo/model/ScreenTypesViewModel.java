package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import eu.rampsoftware.recyclerbinding.BR;

/**
 * Created by Ramps on 2016-09-02.
 */
public class ScreenTypesViewModel extends BaseObservable {
    public static final String TYPE_LINEAR_LIST = "Linear List";
    public static final String TYPE_STAGGERED_GRID = "Staggered Grid";
    private ObservableList<ScreenTypeViewModel> mTypes = new ObservableArrayList<>();

    public ScreenTypesViewModel() {
        initialize();
    }

    public ObservableList<ScreenTypeViewModel> getTypes() {
        return mTypes;
    }

    private void initialize() {
        mTypes.add(new ScreenTypeViewModel(TYPE_LINEAR_LIST));
        mTypes.add(new ScreenTypeViewModel(TYPE_STAGGERED_GRID));
    }

    public int getItemBindingId() {
        return BR.model;
    }

}
