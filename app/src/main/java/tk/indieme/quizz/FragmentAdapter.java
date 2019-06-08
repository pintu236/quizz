package tk.indieme.quizz;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import tk.indieme.quizz.ui.login.LoginFragment;
import tk.indieme.quizz.ui.signup.SignupFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    private int tabCount;
    private Fragment mCurrentFragment;

    public FragmentAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WelcomeFragment();
            case 1:
                return new SignupFragment();
            case 2:
                return new LoginFragment();
            default:
                return new WelcomeFragment();
        }

    }

    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (getCurrentFragment() != object) {
            mCurrentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
