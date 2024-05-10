package controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import routes.AppRoute;

public class DashboardController implements Initializable {
    @FXML
    VBox navbar;
    @FXML
    BorderPane ground;
    private boolean isHide=false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        var appRoute=new AppRoute();
        appRoute.init(navbar, ground);
    }    
    
    @FXML
    public void onNav(ActionEvent e){
        double x;
        if(isHide) x=216;
        else x=55;
        isHide=!isHide;
        AnchorPane.setLeftAnchor(ground, x);
    }
    
    @FXML
    public void onClose(){
        Platform.exit();
    }
    
    @FXML
    public void onMin(ActionEvent e){
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

}