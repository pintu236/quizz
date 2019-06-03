package tk.indieme.quizz;

public interface SignUpContract {

    interface SignUpView {
        void showMessage();

        void showError(String message);
    }

    interface SignUpPresenter {
        void startSignUp(String username, String password, String confirmPassword, String email);
    }
}
