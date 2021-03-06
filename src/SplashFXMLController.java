import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashFXMLController implements Initializable {
    @FXML
    private StackPane rootPane;
    @Override
    public void initialize(URL url, ResourceBundle rb){

new SplashScreen().start();


    }
    class SplashScreen extends Thread {
        @Override
        public void run(){
            try {
                Thread.sleep(3000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {

                            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }


                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                        rootPane.getScene().getWindow().hide();
                    }
                });
            }catch (InterruptedException ex){
                System.out.println("hello");


            }

        }
    }



}
