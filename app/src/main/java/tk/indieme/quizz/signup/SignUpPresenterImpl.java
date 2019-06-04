package tk.indieme.quizz.signup;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import tk.indieme.quizz.SignUpContract;

public class SignUpPresenterImpl implements SignUpContract.SignUpPresenter {
    private SignUpContract.SignUpView signUpView;


    public SignUpPresenterImpl(SignUpContract.SignUpView signUpView) {
        this.signUpView = signUpView;

    }

    @Override
    public void startSignUp(String username, String password, String confirmPassword, String email) {
        //Validate input fields
        if (username.isEmpty()) {
            signUpView.showError("Please Enter Username");
            return;
        } else if (password.isEmpty()) {
            signUpView.showError("Please Enter Password");
            return;
        } else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)) {
            signUpView.showError("Password MisMatch");
            return;
        } else if (email.isEmpty()) {
            signUpView.showError("Please Enter Email");
            return;
        }

    }
}
