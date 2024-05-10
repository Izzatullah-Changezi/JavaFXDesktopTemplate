package helpers;

import javafx.scene.control.Alert;

public class MessageBox {
    public static void error(String msg){
        var alert=new Alert(Alert.AlertType.ERROR, msg);
        alert.setTitle("Error");
        alert.showAndWait();
    }
}
