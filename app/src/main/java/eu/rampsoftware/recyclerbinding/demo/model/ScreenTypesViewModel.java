package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import eu.rampsoftware.recyclerbinding.BR;

/**
 * Created by Ramps on 2016-09-02.
 */
public class ScreenTypesViewModel extends BaseObservable {
    private ObservableList<ScreenTypeViewModel> mTypes = new ObservableArrayList<>();

    public ScreenTypesViewModel() {
        initialize();
    }

    public ObservableList<ScreenTypeViewModel> getTypes() {
        return mTypes;
    }

    private void initialize() {
        mTypes.add(new ScreenTypeViewModel("Linear List"));
        mTypes.add(new ScreenTypeViewModel("Staggered Grid"));
    }

    public int getItemBindingId(){
        return BR.model;
    }

}
