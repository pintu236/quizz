package tk.indieme.quizz;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import tk.indieme.quizz.login.LoginFragment;
import tk.indieme.quizz.signup.SignupFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    private int tabCount;

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

    @Override
    public int getCount() {
        return tabCount;
    }
}
