package ducku.com.moneyhappy.model;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    public static final String KEY_USER = "user";

    public static void  saveUser(Context context, String userID) {
        SharedPreferences.Editor editor = context.getSharedPreferences("KEYAPP", Context.MODE_PRIVATE).edit();
        editor.putString(KEY_USER, userID);
        editor.commit();
    }

    public static String getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("KEYAPP", Context.MODE_PRIVATE);
        String userID = sharedPreferences.getString(KEY_USER, "");
        return userID;
    }
}
