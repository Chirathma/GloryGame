package ie.ucd.UserInterfaces;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Game extends Application{

    public static final int TILE_SIZE   = 85;
    public static final int TILE_WIDTH  = 8;
    public static final int TILE_HEIGHT = 8;
    private static final int INIT_SIZE  = 3;
    private Alphabet[] initialLetters;
    private Tile[] selectiveLetterSet;
    private Alphabet selectedLetter;

    private Text roundValue;
    private Text scoreValue;
    private Text playerName;


    private BorderPane root;

    private Parent createContent () throws IOException{
        Text gameName = createLabel("Glory", Color.VIOLET, 32 );
        Text round    = createLabel("ROUND:", Color.YELLOW, 18);
        Text score    = createLabel("SCORE:", Color.YELLOW, 18 );
        Text player   = createLabel("PLAYER:", Color.YELLOW, 18 );
        //Text dummy    = createLabel("100", Color.WHITE, 14 );

        //labels for displaying data on scoreboard
        roundValue    = createLabel("", Color.WHITE, 14);
        scoreValue    = createLabel("", Color.WHITE, 14 );
        playerName   = createLabel("", Color.WHITE, 14 );

        Text centerLabel = new Text("Your initial letters~");
        Text letterBagLabel = new Text("Please select your letters~");

        Text labelCapture = new Text("CAPTURE");
        Text labelDiscard = new Text("DISCARD");
        Text labelMenu = new Text("MENU");

        // Text Field to input produced word
        TextField wordField = new TextField();
        wordField.setText("Enter your word here...");
        wordField.setFont(wordField.getFont().font(22));
        wordField.setAlignment(Pos.BOTTOM_CENTER);
        wordField.setPrefSize(200, 50);
        wordField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8); -fx-border-radius: 0; -fx-border-color: yellow\n; " +
                "-fx-border-insets: 0; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 1; -fx-background-radius: 5;");

        //Game menu
        VBox gameMenu = new VBox();
        gameMenu.setPrefSize(60, 500);
        gameMenu.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-border-radius: 5;" +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 0; -fx-background-radius: 5;");
        gameMenu.getChildren().addAll(labelCapture, labelDiscard, labelMenu);

        //top pane for displaying score etc.
        BorderPane topPane = new BorderPane();
        topPane.setPrefSize(900, 80);
        topPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-border-radius: 5; " +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 0; -fx-background-radius: 5;");
        //Region region = new Region();
        //HBox.setHgrow(region, Priority.ALWAYS);

        // bottom pane
        HBox bottomPane = new HBox();
        bottomPane.setPrefSize(900, 150);
        bottomPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-border-radius: 5; -fx-border-color: gold\n; " +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 3; -fx-background-radius: 5;");

        // center pane
        VBox centerPanel = new VBox();
        centerPanel.setPadding(new Insets(10, 10, 10 , 10));
        centerPanel.setPrefSize(800, 500);
        centerPanel.setSpacing(5);
        centerPanel.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-border-radius: 5; -fx-border-color: gold\n; " +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 3; -fx-background-radius: 5;");

        // grid pane for the initial letters
        GridPane initPane = new GridPane();
        initPane.setHgap(5.0);
        initPane.setVgap(5.0);
        initPane.setAlignment(Pos.CENTER);
        initPane.setMinSize(500, 150);
        initPane.setPadding(new Insets(10, 10, 10 , 10));
        initPane.setStyle("-fx-background-color: rgba(255, 204, 0, 0.5); -fx-border-radius: 0; -fx-border-color: yellow\n; " +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 2; -fx-background-radius: 5;");


        for(int i = 0; i< INIT_SIZE; i++){
            Tile tile = new Tile(true, i, 0);
            initPane.add(tile, i, 0);

            LetterMaterial initLetter = null;
            initLetter = createPiece(initialLetters[i], 75, 0);
            tile.setLetter(initLetter);
            initPane.add(initLetter, i, 0);

        }
        selectiveLetterSet = new Tile[8];

        // grid pane for the selective letters
        GridPane selectivePane = new GridPane();
        selectivePane.setHgap(5.0);
        selectivePane.setVgap(5.0);
        selectivePane.setAlignment(Pos.CENTER);
        selectivePane.setMinSize(500, 150);
        selectivePane.setPadding(new Insets(10, 10, 10 , 10));
        selectivePane.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-border-radius: 0; -fx-border-color: olive\n; " +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 2; -fx-background-radius: 5;");

        for(int x = 0; x< TILE_WIDTH; x++){
            Tile tile = new Tile(false, x, 0);
            //Event listener for the selection of the tile
            tile.setOnMouseClicked(event -> {
                Node source = (Node)event.getSource();
                int colIndex = GridPane.getColumnIndex(source);
                int rowIndex = GridPane.getRowIndex(source);
                LetterMaterial selectedPiece = new LetterMaterial(selectedLetter, 75, 0);
                selectivePane.add(selectedPiece, colIndex, rowIndex);
            });
            selectivePane.add(tile, x, 0);
            selectiveLetterSet[x] = tile;
        }

        // grid pane for the letter bag
        GridPane letterBagPane = new GridPane();
        letterBagPane.setHgap(1.0);
        letterBagPane.setVgap(1.0);
        letterBagPane.setAlignment(Pos.CENTER);
        letterBagPane.setMinSize(900, 150);
        letterBagPane.setPadding(new Insets(10, 10, 10 , 10));
        letterBagPane.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-border-radius: 0; -fx-border-color: olive\n; " +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 2; -fx-background-radius: 5;");


        LetterMaterial[] bagLetters = new LetterMaterial[26];
        int count = 0;
        for(Alphabet alphabet : Alphabet.values()){
            LetterMaterial bagLetter = null;
            bagLetter = createPiece(alphabet, 55, 0);

            // Event listener for a piece in letter bag
            bagLetter.setOnMouseClicked(event -> {
                LetterMaterial source = (LetterMaterial) event.getSource();
                selectedLetter = source.getLetterValue();
            });
            bagLetters[count]=bagLetter;
            count++;
        }

        for(int x = 0; x < 13; x++){
            letterBagPane.add(bagLetters[x], x, 0);
        }
        int n = 0;
        for(int y = 13; y < 26; y++){
            letterBagPane.add(bagLetters[y], n, 1);
            n++;
        }

        // grid pane for the scoreboard
        GridPane scoreBoard = new GridPane();
        scoreBoard.setHgap(15.0);
        scoreBoard.setVgap(2.0);
        scoreBoard.setAlignment(Pos.CENTER_RIGHT);
        scoreBoard.setPrefSize(150, 70);
        scoreBoard.setPadding(new Insets(10, 10, 10 , 10));
        scoreBoard.setStyle("-fx-background-color: rgba(0, 100, 100, 0.0); -fx-border-radius: 0;" +
                "-fx-border-insets: 5; -fx-border-style: solid\n;" +
                " -fx-padding: 10; -fx-border-width: 0; -fx-background-radius: 5;");

        // adding child labels to the scoreboard
        scoreBoard.add(player, 0, 0);
        scoreBoard.add(round, 1, 0);
        scoreBoard.add(score, 2, 0);
        scoreBoard.add(playerName, 0, 1);
        scoreBoard.add(roundValue, 1, 1);
        scoreBoard.add(scoreValue, 2, 1);

        // Setting label alignments
        GridPane.setHalignment(playerName, HPos.RIGHT);
        GridPane.setValignment(playerName, VPos.TOP);
        GridPane.setHalignment(scoreValue, HPos.RIGHT);
        GridPane.setValignment(scoreValue, VPos.TOP);
        GridPane.setHalignment(roundValue, HPos.RIGHT);
        GridPane.setValignment(roundValue, VPos.TOP);
        // Tile group
        Group initialLettersGroup = new Group();

        // adding child nodes to child layouts
        topPane.setLeft(gameName);
        topPane.setRight(scoreBoard);
        centerPanel.getChildren().addAll(initPane, selectivePane, wordField);
        bottomPane.getChildren().add(letterBagPane);


        // main border layout frame
        root = new BorderPane();
        root.setPrefSize(1000, 660);

        // setting margins of child nodes in root node
        BorderPane.setMargin(topPane, new Insets(3,3,3,3));
        BorderPane.setMargin(centerPanel, new Insets(3,3,3,3));
        BorderPane.setMargin(gameMenu, new Insets(3,3,3,3));
        BorderPane.setMargin(bottomPane, new Insets(3,3,3,3));

        // open an image file & create an image object for background
        InputStream imageIn = Files.newInputStream(Paths.get("res/images/treasure.jpg"));
        Image menuBackground = new Image(imageIn);
        imageIn.close();

        ImageView iv = new ImageView(menuBackground);
        // resizing image
        iv.setFitWidth(1000);
        iv.setFitHeight(720);


        //gameMenu.setVisible(false);

        root.getChildren().add(iv);
        root.setRight(gameMenu);
        root.setTop(topPane);
        root.setBottom(bottomPane);
        root.setCenter(centerPanel);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        getInitialLetters(Alphabet.S, Alphabet.A, Alphabet.H);
        Scene scene = new Scene(createContent());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

//    private MoveResult tryMove(LetterMaterial letterPiece, int newX) {
//        if(selectiveLetterSet[newX].hasLetter()){
//            return new MoveResult(PieceMoves.NONE);
//        }
//        return new MoveResult(PieceMoves.NORMAL);
//    }

//    private int toIndex(double coordinate){
//            return (int)
//    }

    private  LetterMaterial createPiece(Alphabet letter, int x, int y){
        LetterMaterial letterPiece = new LetterMaterial(letter, x, y);
        letterPiece.setOnMouseReleased(event -> {
            double newX = letterPiece.getLayoutX();
            double newY = letterPiece.getLayoutY();
            letterPiece.relocate(newX, newY);

//            letterPiece.setTranslateX(newX);
//            letterPiece.setTranslateY(newY);
        });

        //MoveResult result = new MoveResult(tryMove(letterPiece,))

        return letterPiece;
    }

    private Text createLabel (String name, Color color, int fontSize){
        Text label = new Text(name);
        label.setFill(color);
        label.setFont(label.getFont().font(fontSize));
        return label;
    }

    public void getInitialLetters (Alphabet i1, Alphabet i2, Alphabet i3){
        initialLetters = new Alphabet[3];
        initialLetters[0] = i1;
        initialLetters[1] = i2;
        initialLetters[2] = i3;

    }

    public void setPlayer (String name){
        playerName.setText(name);
    }

    public void setRound (int round){
        roundValue.setText(Integer.toString(round));
    }

    public void setScore (int score){
        scoreValue.setText(Integer.toString(score));
    }

}