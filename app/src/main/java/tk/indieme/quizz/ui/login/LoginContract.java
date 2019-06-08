package tk.indieme.quizz.ui.login;

public interface LoginContract {

    interface LoginView {
        void showMessage(String email, String password);
    }

    interface LoginPresenter {
        void startLogin(String email, String password);
    }
}
