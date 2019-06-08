package tk.indieme.quizz;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;

import tk.indieme.quizz.ui.main.HomeActivity;

public class WelcomeFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            //close this activity
            getActivity().finish();
            //opening profile activity
            startActivity(new Intent(getActivity(), HomeActivity.class));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        view.findViewById(R.id.btn_login_main).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                ViewPager viewPager = getActivity().findViewById(R.id.vp_main);
                viewPager.setCurrentItem(2);
            }
        });
        view.findViewById(R.id.btn_sign_up_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = getActivity().findViewById(R.id.vp_main);
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }
}
