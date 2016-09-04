package eu.rampsoftware.recyclerbinding.extensions;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by Ramps on 2016-09-04.
 */
public interface LayoutManagerType {
    int LINEAR=0;
    int GRID=1;
    int STAGGERED_GRID=2;

    @Retention(SOURCE)
    @IntDef({LINEAR, GRID, STAGGERED_GRID})
    public @interface LayoutType {}
}
