package tk.indieme.quizz.ui.login;

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    private LoginContract.LoginView loginView;

    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void startLogin(String email, String password) {
        
    }
}
