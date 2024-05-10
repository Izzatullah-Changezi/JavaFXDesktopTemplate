package routes;

import helpers.Icon;
import helpers.Icons;
import helpers.MessageBox;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AppRoute {
    private VBox navBar;
    public void init(VBox navBar, BorderPane ground){
        this.navBar=navBar;
        routes().forEach(r->{
            var b=new Button(r.name());
            b.getStyleClass().add("btn");
            b.getStyleClass().add("btnNav");
            b.setPrefSize(215, 25);
            b.setTooltip(new Tooltip(r.name()));
            var stack=new StackPane();
            stack.setPrefSize(40, 30);
            stack.setPadding(new Insets(0, 10, 0, 0));
            stack.getChildren().add(new Icon(r.icon()));
            b.setGraphic(stack);
            b.setOnAction(e->{
                selected(r.name());
                changeView(r.url(), ground);
            });
            navBar.getChildren().add(b);
        });
    }
    
    private List<Route> routes(){
        var list=List.of(
                new Route("Home", "/views/home", Icons.HOUSE),
                new Route("Credit", "/views/credit", Icons.CART_SHOPPING),
                new Route("Buy", "/views/buy", Icons.SHOPIFY),
                new Route("Transact", "/views/transact",  Icons.MONEY_BILL)
        );
        return list;
    }
    
    private void selected(String name){
        var b=navBar.getChildren().filtered(p-> ((Button)p).getText().equals(name)).get(0);
        navBar.getChildren().forEach(p-> p.getStyleClass().remove("btnNavSelected"));
        b.getStyleClass().add("btnNavSelected");
    }
    private void changeView(String url, BorderPane ground){
        try {
            var node=(Parent)FXMLLoader.load(getClass().getResource("/fxml"+url+".fxml"));
            ground.setCenter(node);
        } catch (IOException | NullPointerException ex) {
            MessageBox.error(ex.getMessage());
        }
        
    }
}
