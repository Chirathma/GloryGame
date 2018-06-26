package ie.ucd.UserInterfaces;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LetterMaterial extends StackPane{

    private  Alphabet letter;
    private int weight;

    public Alphabet getLetterValue () {
        return letter;
    }

    public LetterMaterial (Alphabet letter, int size, int y) {
        this.letter = letter;
        weight = letter.value;
        Rectangle background = new Rectangle(size, size);
        background.setStroke(Color.YELLOW);
        background.setFill(Color.GOLD);

        background.setArcHeight(5);
        background.setArcWidth(5);

        // the label for the letter
        Text letterLabel = new Text(toString());
        letterLabel.setFont(letterLabel.getFont().font(32));
        letterLabel.setFill(Color.GOLD);
        //letterLabel.setWrappingWidth(65);

        // the label for the letter weight
        Text weightLabel = new Text(Integer.toString(weight));
        weightLabel.setFont(letterLabel.getFont().font(16));
        letterLabel.setFill(Color.DARKGREEN);
        //letterLabel.setWrappingWidth(30);

        //vertical layout for letter piece contents
        GridPane letterGrid = new GridPane();
        letterGrid.setAlignment(Pos.CENTER);
        letterGrid.setPrefSize(size, size);
        letterGrid.setMinSize(50, 50);
        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(10);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(60);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(30);
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(30);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(40);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        letterGrid.getRowConstraints().addAll(row0,row1, row2);
        letterGrid.getColumnConstraints().addAll(col0, col1, col2);
        // position the main letter
        letterGrid.add(letterLabel, 1, 1);
        GridPane.setHalignment(letterLabel, HPos.CENTER);
        GridPane.setValignment(letterLabel, VPos.BOTTOM);


        letterGrid.add(weightLabel, 2 , 2);
        GridPane.setHalignment(weightLabel, HPos.LEFT);
        GridPane.setValignment(weightLabel, VPos.TOP);
        // add background & letterGrid to this inherited pane
        getChildren().addAll(background ,letterGrid);



        setOnMousePressed(event -> {
//            mouseX = event.getSceneX();
//            mouseY = event.getSceneY();
        });

//        setOnMouseDragged(event ->{
//            //relocate(event.getSceneX() - mouseX , event.getSceneY() - mouseY);
//            setTranslateX(event.getSceneX() - mouseX);
//            setTranslateY(event.getSceneY() - mouseY);
//
//
//        });

//        setOnMouseReleased(event -> {
//            mouseX = event.getScreenX() - mouseX;
//            mouseY = event.getScreenY() - mouseY;
//        });
    }

//    private double mouseX, mouseY;
//    private double oldMouseX;
//    private double oldMouseY;
//
//
//    public double getOldMouseX() {
//        return oldMouseX;
//    }
//
//    public double getOldMouseY() {
//        return oldMouseY;
//    }

    @Override
    public String toString () {
        return letter.toString();
    }

//    public void moveLetterPiece (double x, double y){
//       oldMouseX = x;
//       oldMouseY = y;
//       relocate(oldMouseX, oldMouseY);
//    }
}