package helpers;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.layout.Pane;

public class Icon extends Pane{
    public Icon(Icons icons){
        super();
        var icon=getIcon(icons);
        setStyle("-fx-background-color:#000; -fx-shape:'"+icon+"'");
        
    }
    private String getIcon(Icons icon){
        var sc=new Scanner(getClass().getResourceAsStream("/text/icons.txt"));
        var list=new ArrayList<String>();
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        return list.get(icon.ordinal());
    }
}
