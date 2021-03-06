package app.view.components;

import java.io.FileNotFoundException;
import java.util.Objects;

import app.Controllers.UserController;
import app.Models.UserModel;
import app.route.Route;
import app.view.pages.Profile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LoginForm extends VBox {
    TextField email;
    PasswordField password;
    Button submit;

    UserController userController = UserController.getInstance();

    public LoginForm() {

        email = new TextField();
        email.setPromptText("email");
        password = new PasswordField();
        password.setPromptText("password");

        email.setId("baseforminput");
        password.setId("baseforminput");
        submit = new Button("Sign in");
        submit.setId("baseformbutton");

        email.setMinWidth(25);
        password.setMinWidth(25);
        submit.setMinWidth(25);

        submit.setMaxWidth(150);
        email.setMaxWidth(250);
        password.setMaxWidth(250);

        getChildren().addAll(email, password, submit);
        setSpacing(10);
        submit.setPadding(new Insets(5, 5, 5, 5));
        setAlignment(Pos.CENTER);

        VBox.setVgrow(email, Priority.ALWAYS);
        VBox.setVgrow(password, Priority.ALWAYS);
        VBox.setVgrow(submit, Priority.ALWAYS);
        submit.setOnAction(e -> {

            boolean state = userController.checkSignIn(email.getText(), password.getText());

            if (state)
                try {
                    profileRoute(userController.getUserModel());
                } catch (FileNotFoundException e1) {
                 
                    e1.printStackTrace();
                }
            else {
                loginError();
            }

        });
        
    }

    public void profileRoute(UserModel u) throws FileNotFoundException {
        Route.getStage().setScene((new Profile(u).getScene()));
    }
    public void loginError()
    {
        Route.showError(userController.getUserModel().getName());
    }
    public LoginForm(TextField email, PasswordField password, Button submit) {
        this.email = email;
        this.password = password;
        this.submit = submit;
    }

    public TextField getEmail() {
        return this.email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public PasswordField getPassword() {
        return this.password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getSubmit() {
        return this.submit;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }

    public LoginForm email(TextField email) {
        this.email = email;
        return this;
    }

    public LoginForm password(PasswordField password) {
        this.password = password;
        return this;
    }

    public LoginForm submit(Button submit) {
        this.submit = submit;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LoginForm)) {
            return false;
        }
        LoginForm loginForm = (LoginForm) o;
        return Objects.equals(email, loginForm.email) && Objects.equals(password, loginForm.password) && Objects.equals(submit, loginForm.submit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, submit);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", submit='" + getSubmit() + "'" +
            "}";
    }

        
    
    
}
