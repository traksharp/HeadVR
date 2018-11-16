package autoandshare.headvr.lib;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Setting {
    public enum id {
        Brightness,
        EyeDistance,
        EyeDistance3D,
        VerticalDistance,
        VideoSize,
        MotionSensitivity,
    }

    private static class Item {
        int min;
        int max;
        int defaultValue;
        float minF;
        float maxF;

        Item(int min, int max, int defaultValue, float minF, float maxF) {
            this.min = min;
            this.max = max;
            this.defaultValue = defaultValue;
            this.minF = minF;
            this.maxF = maxF;
        }
    }

    private static HashMap<id, Item> items;

    static {
        items = new HashMap<>();
        items.put(id.Brightness, new Item(0, 100, 50, 0f, 0.5f));
        items.put(id.EyeDistance, new Item(-50, 50, 0, -0.4f, 0.4f));
        items.put(id.EyeDistance3D, new Item(-50, 50, 0, -0.4f, 0.4f));
        items.put(id.VerticalDistance, new Item(-50, 50, 0, -0.6f, 0.6f));
        items.put(id.VideoSize, new Item(50, 150, 100, 1.5f, 4.5f));
        items.put(id.MotionSensitivity, new Item(-10, 10, 0, 0.09f, 0.01f));
    }

    public float getFloat(id name) {
        Item item = items.get(name);
        return item.minF + (item.maxF - item.minF) * (get(name) - item.min) / (item.max - item.min);
    }

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public void clear() {
        editor.clear().commit();
    }

    public Setting(Activity activity) {
        pref = activity.getSharedPreferences("Setting", 0);
        editor = pref.edit();
    }

    public int getMin(id name) {
        return items.get(name).min;
    }

    public int getMax(id name) {
        return items.get(name).max;
    }

    public int get(id name) {
        return pref.getInt(name.toString(), items.get(name).defaultValue);
    }

    public void set(id name, int value) {
        editor.putInt(name.toString(), value);
    }

    public void apply() {
        editor.apply();
    }
}
