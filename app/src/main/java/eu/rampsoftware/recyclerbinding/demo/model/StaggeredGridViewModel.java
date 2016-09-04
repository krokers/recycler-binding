package eu.rampsoftware.recyclerbinding.demo.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import java.util.Random;

import eu.rampsoftware.recyclerbinding.BR;
import eu.rampsoftware.recyclerbinding.demo.R;

/**
 * Created by Ramps on 2016-09-02.
 */
public class StaggeredGridViewModel extends BaseObservable {
    private final Random mRand;

    private int[] mImageResIds = new int[]{
            R.drawable.image_200_300_2,
            R.drawable.image_200_300_3,
            R.drawable.image_200_300_4,
            R.drawable.image_200_300_5,
            R.drawable.image_200_400_1,
            R.drawable.image_200_400_2,
            R.drawable.image_200_400_3,
            R.drawable.image_200_400_4,
            R.drawable.image_200_400_5,
            R.drawable.image_400_200_1,
            R.drawable.image_400_200_2,
            R.drawable.image_400_200_3,
            R.drawable.image_400_200_4,
            R.drawable.image_400_200_5,
            R.drawable.image_400_300_1,
            R.drawable.image_400_300_2,
            R.drawable.image_400_300_3,
            R.drawable.image_400_300_4,
            R.drawable.image_400_300_5,
            R.drawable.image_400_300_6,
            R.drawable.image_400_400_1,
            R.drawable.image_400_400_2,
            R.drawable.image_400_400_3,
            R.drawable.image_400_400_4,
            R.drawable.image_400_400_5,
    };

    ObservableList<GridItemViewModel> mItems = new ObservableArrayList<>();

    public StaggeredGridViewModel() {
        mRand = new Random();
        initialize();
    }

    public ObservableList<GridItemViewModel> getItems() {
        return mItems;
    }

    private void initialize() {
        for (int i = 0; i < 100; i++) {
            mItems.add(new GridItemViewModel(mImageResIds[mRand.nextInt(mImageResIds.length)] ));
        }
    }

    public int getItemBindingId() {
        return BR.model;
    }

}
