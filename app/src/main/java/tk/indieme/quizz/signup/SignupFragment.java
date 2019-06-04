package tk.indieme.quizz.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import tk.indieme.quizz.R;
import tk.indieme.quizz.SignUpContract;


public class SignupFragment extends Fragment implements SignUpContract.SignUpView {

    private SignUpContract.SignUpPresenter signUpPresenter;
    private EditText mUsername, mPassword, mConfirmPassword, mEmail;
    private Button mBtnSignUp;
    private FirebaseAuth auth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpPresenter = new SignUpPresenterImpl(this);
        auth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        mUsername = view.findViewById(R.id.et_username_signup);
        mPassword = view.findViewById(R.id.et_pass_login);
        mConfirmPassword = view.findViewById(R.id.et_confirm_pass_login);
        mEmail = view.findViewById(R.id.et_email_id_signup);
        mBtnSignUp = view.findViewById(R.id.btn_sign_up);

        mBtnSignUp.setOnClickListener(signUpBtnListener);
        return view;
    }

    View.OnClickListener signUpBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Start Sign Up
            signUpPresenter.startSignUp(mUsername.getText().toString(), mPassword.getText().toString(),
                    mConfirmPassword.getText().toString(), mEmail.getText().toString());
        }
    };

    @Override
    public void showMessage(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(getActivity(), "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                //  progressBar.setVisibility(View.GONE);
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Toast.makeText(getActivity(), "Authentication failed." + task.getException(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    //  startActivity(new Intent((AppCompatActivity)signUpView, MainActivity.class));
                    // finish();
                    Toast.makeText(getActivity(), "Authentication Successful." + task.getException(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
