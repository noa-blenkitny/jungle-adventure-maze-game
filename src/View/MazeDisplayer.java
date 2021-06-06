package View;

import Model.Solution;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MazeDisplayer extends Canvas {
    private int[][] maze;
    private Solution solution;
    // player position:
    private int playerRow = 0;
    private int playerCol = 0;
    // wall and player images:
    private StringProperty imageFileNameWall = new SimpleStringProperty();
    private StringProperty imageFileNamePlayer = new SimpleStringProperty();
    private StringProperty imageFox = new SimpleStringProperty();
    private StringProperty imageGazelle = new SimpleStringProperty();
    private StringProperty imageMonkey = new SimpleStringProperty();
    private StringProperty imageChild = new SimpleStringProperty();
    private Image playerImage ;

    public void setImageMan(String imageMan) {
        this.imageMan.set(imageMan);
    }

    private StringProperty imageMan = new SimpleStringProperty();
    private StringProperty imageWoman = new SimpleStringProperty();


    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public void setPlayerPosition(int row, int col) {
        this.playerRow = row;
        this.playerCol = col;
        draw();
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
        draw();
    }

    public String getImageFileNameWall() {
        return imageFileNameWall.get();
    }

    public String imageFileNameWallProperty() {
        return imageFileNameWall.get();
    }

    public void setImageFileNameWall(String imageFileNameWall) {
        this.imageFileNameWall.set(imageFileNameWall);
    }

    public String getImageFileNamePlayer() {
        return imageFileNamePlayer.get();
    }

    public String imageFileNamePlayerProperty() {
        return imageFileNamePlayer.get();
    }

    public void setImageFileNamePlayer(String imageFileNamePlayer) {
        this.imageFileNamePlayer.set(imageFileNamePlayer);
    }

    public void drawMaze(int[][] maze) {
        this.maze = maze;
        draw();
    }

    private void draw() {
        if(maze != null){
            double canvasHeight = getHeight();
            double canvasWidth = getWidth();
            int rows = maze.length;
            int cols = maze[0].length;

            double cellHeight = canvasHeight / rows;
            double cellWidth = canvasWidth / cols;

            GraphicsContext graphicsContext = getGraphicsContext2D();
            //clear the canvas:
            graphicsContext.clearRect(0, 0, canvasWidth, canvasHeight);

            drawMazeWalls(graphicsContext, cellHeight, cellWidth, rows, cols);
            if(solution != null)
                drawSolution(graphicsContext, cellHeight, cellWidth);
            drawPlayer(graphicsContext, cellHeight, cellWidth);
        }
    }

    private void drawSolution(GraphicsContext graphicsContext, double cellHeight, double cellWidth) {
        // need to be implemented
        System.out.println("drawing solution...");
    }

    private void drawMazeWalls(GraphicsContext graphicsContext, double cellHeight, double cellWidth, int rows, int cols) {
        graphicsContext.setFill(Color.RED);

        Image wallImage = null;
        try{
            wallImage = new Image(new FileInputStream(getImageFileNameWall()));
        } catch (FileNotFoundException e) {
            System.out.println("There is no wall image file");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(maze[i][j] == 1){
                    //if it is a wall:
                    double x = j * cellWidth;
                    double y = i * cellHeight;
                    if(wallImage == null)
                        graphicsContext.fillRect(x, y, cellWidth, cellHeight);
                    else
                        graphicsContext.drawImage(wallImage, x, y, cellWidth, cellHeight);
                }
            }
        }
    }

    private void drawPlayer(GraphicsContext graphicsContext, double cellHeight, double cellWidth) {
        double x = getPlayerCol() * cellWidth;
        double y = getPlayerRow() * cellHeight;
        graphicsContext.setFill(Color.GREEN);
        try {

            playerImage = new Image(new FileInputStream(getImageFileNamePlayer()));
        } catch (FileNotFoundException e) {
            System.out.println("There is no player image file");
        }
        if(playerImage == null)
            graphicsContext.fillRect(x, y, cellWidth, cellHeight);
        else
            graphicsContext.drawImage(playerImage, x, y, cellWidth, cellHeight);
    }

    public void changePlayer(String player)
    {
        switch(player)
        {
            case "fox":
                imageFileNamePlayer.set(imageFox.get());
                break;
            case "child":
                imageFileNamePlayer.set(imageChild.get());
               // playerImage = new Image(new FileInputStream())
                break;
            case "monkey":
                imageFileNamePlayer.set("./resources/images/monkey1.PNG");
                break;
            case "gazelle":
                imageFileNamePlayer.set("./resources/images/gazelleR1.png");
                break;
            case "man":
                imageFileNamePlayer.set("./resources/images/manR1.PNG");
                break;
            case "women":
                imageFileNamePlayer.set("./resources/images/womenR1.PNG");
                break;

        }
    }

    public String getImageFox() {
        return imageFox.get();
    }

    public StringProperty imageFoxProperty() {
        return imageFox;
    }

    public void setImageFox(String imageFox) {
        this.imageFox.set(imageFox);
    }

    public String getImageGazelle() {
        return imageGazelle.get();
    }

    public StringProperty imageGazelleProperty() {
        return imageGazelle;
    }

    public void setImageGazelle(String imageGazelle) {
        this.imageGazelle.set(imageGazelle);
    }

    public String getImageMonkey() {
        return imageMonkey.get();
    }

    public StringProperty imageMonkeyProperty() {
        return imageMonkey;
    }

    public void setImageMonkey(String imageMonkey) {
        this.imageMonkey.set(imageMonkey);
    }

    public String getImageChild() {
        return imageChild.get();
    }

    public StringProperty imageChildProperty() {
        return imageChild;
    }

    public void setImageChild(String imageChild) {
        this.imageChild.set(imageChild);
    }

    public String getImageWoman() {
        return imageWoman.get();
    }

    public StringProperty imageWomanProperty() {
        return imageWoman;
    }

    public void setImageWoman(String imageWoman) {
        this.imageWoman.set(imageWoman);
    }


    public String getImageMan() {
        return imageMan.get();
    }

    public StringProperty imageManProperty() {
        return imageMan;
    }

}
