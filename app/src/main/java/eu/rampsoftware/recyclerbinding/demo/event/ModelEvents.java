package eu.rampsoftware.recyclerbinding.demo.event;

/**
 * Created by Ramps on 2016-09-03.
 */
public class ModelEvents {
    public static class OnTypeSelectedEvent {
        private final String mType;

        public OnTypeSelectedEvent(String type) {
            mType = type;
        }

        public String getType() {
            return mType;
        }
    }
}
