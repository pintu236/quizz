package tk.indieme.quizz;

public interface SignUpContract {

    interface SignUpView {
        void showMessage(String email,String password);

        void showError(String message);

    }

    interface SignUpPresenter {
        void startSignUp(String username, String password, String confirmPassword, String email);
    }
}
