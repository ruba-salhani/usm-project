package app;
import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javafx.application.Application;
import javafx.stage.Stage;
import app.route.Route;
import app.view.pages.LogInPage;

public class HelloFX extends Application {
    
    @Override

    public void start(Stage stage) throws IOException {
        Route.setStage(stage);
       LogInPage inPage = new LogInPage();
       stage.setScene(inPage.getScene());
        stage.show();
       
    }

    public static void main(String[] args) {
        launch();
    }

}