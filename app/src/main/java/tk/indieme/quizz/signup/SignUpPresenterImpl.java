package tk.indieme.quizz.signup;

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
        }

    }
}
