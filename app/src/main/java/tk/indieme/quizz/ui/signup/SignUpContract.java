package tk.indieme.quizz.ui.signup;

public interface SignUpContract {

    interface SignUpView {
        void showMessage(String email, String password);

        void showError(String message);

        void showProgressBar();

    }

    interface SignUpPresenter {
        void startSignUp(String username, String password, String confirmPassword, String email);

        void saveUserName(String key, String value);
    }
}
