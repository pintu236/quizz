package tk.indieme.quizz.ui.signup;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceRepoImpl implements SharedPreferenceRepo {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SharedPreferenceRepoImpl(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }


    @Override
    public void saveUserName(String key, String value) {
        editor.putString(key, value);
    }
}
