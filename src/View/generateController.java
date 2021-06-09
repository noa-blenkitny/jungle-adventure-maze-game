package View;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class generateController extends AView {

    public TextField rowText;
    public TextField colText;

    public void customSizeMazeGenerator() {
        String rows = rowText.getText();
        String cols = colText.getText();
        if(myViewModel.checkMazeGenarationParams(rows, cols) == true)
        {
            switchScene("MazeWindow.fxml", getStage());
            myViewModel.startServers();
            myViewModel.generateMaze(rows, cols);
        }
        else
        {
            invalidParamAlert("Invalid parameter entered.\nPlease enter an integer between 2 to 1000.");
        }
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}