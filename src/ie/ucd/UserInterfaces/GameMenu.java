package ie.ucd.UserInterfaces;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameMenu extends Application {

    private Menu gameMenu;
    private Game gameBoard;
    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane root = new Pane();
        root.setPrefSize(900,600);

        // open an image file & create an image object for background
        InputStream imageIn = Files.newInputStream(Paths.get("res/images/battle.jpg"));
        Image menuBackground = new Image(imageIn);
        imageIn.close();

        ImageView iv = new ImageView(menuBackground);
        // resizing image
        iv.setFitWidth(900);
        iv.setFitHeight(600);

        gameMenu = new Menu();
        gameMenu.setVisible(false);
        root.getChildren().addAll(iv, gameMenu);
        window.setTitle("Glory Game");
        // remove the window menu
        window.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE ){
                if(!gameMenu.isVisible()){
                    FadeTransition menuFading = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    // opacity change of node gameMenu
                    menuFading.setFromValue(0);
                    menuFading.setToValue(1);

                    gameMenu.setVisible(true);
                    menuFading.play();
                }

                else {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(eve -> gameMenu.setVisible(false));
                    ft.play();
                }
            }
        });
        window.setScene(scene);
        window.show();
    }

    // building the menus
    private class Menu extends Parent {
        public Menu (){
            final int offset = 400;
            VBox mainMenu = new VBox(10);
            VBox subMenu1 = new VBox(10);// sub menu
            GridPane SignInMenu = new GridPane();// Sign In form
            GridPane SignUpMenu = new GridPane();// Sign Up form

            //set positions
            mainMenu.setTranslateX(100);
            mainMenu.setTranslateY(200);
            subMenu1.setTranslateX(100);
            subMenu1.setTranslateY(200);

            subMenu1.setTranslateX(offset);
            SignInMenu.setTranslateX(offset);
            SignUpMenu.setTranslateX(offset);

            // resume button
            MenuButton buttonResume = new MenuButton("PLAY");
            buttonResume.setOnMouseClicked(e -> {
                FadeTransition fading = new FadeTransition(Duration.seconds(0.5), this);
                fading.setFromValue(1);
                fading.setToValue(0);
                fading.setOnFinished(ev ->{
                    this.setVisible(false);
                    gameBoard = new Game();
                    try {
                        gameBoard.start(window);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
                fading.play();
            });

            // Sign In button
            MenuButton buttonSignIn = new MenuButton("Sign In");
            buttonSignIn.setOnMouseClicked(e -> {
                getChildren().add(subMenu1);
                // move the main menu out of the stage
                TranslateTransition menuTransition1 = new TranslateTransition(Duration.seconds(0.25), mainMenu);
                menuTransition1.setToX(mainMenu.getTranslateX() - offset);

                // moving the sign in form into the place
                TranslateTransition menuTransition2 = new TranslateTransition(Duration.seconds(0.5), subMenu1);
                menuTransition2.setToX(mainMenu.getTranslateX());

                //playing the transitions
                menuTransition1.play();
                menuTransition2.play();

                menuTransition1.setOnFinished(evt -> getChildren().remove(mainMenu)
                );
            });

            // options button
            MenuButton buttonOptions = new MenuButton("OPTIONS");
            buttonOptions.setOnMouseClicked(e -> {
                getChildren().add(subMenu1);
                // move the main menu out of the stage
                TranslateTransition menuTransition1 = new TranslateTransition(Duration.seconds(0.25), mainMenu);
                menuTransition1.setToX(mainMenu.getTranslateX() - offset);

                // moving the sub menu into the place
                TranslateTransition menuTransition2 = new TranslateTransition(Duration.seconds(0.5), subMenu1);
                menuTransition2.setToX(mainMenu.getTranslateX());

                //playing the transitions
                menuTransition1.play();
                menuTransition2.play();

                menuTransition1.setOnFinished(evt -> getChildren().remove(mainMenu)
                );
            });

            // quit button
            MenuButton buttonQuit = new MenuButton("QUIT");
            buttonQuit.setOnMouseClicked(e -> {
                System.exit(0);
//
            });

            // back button
            MenuButton buttonBack = new MenuButton("BACK");
            buttonBack.setOnMouseClicked(e -> {
                getChildren().add(mainMenu);
                // move the sub menu out of the stage
                TranslateTransition menuTransition1 = new TranslateTransition(Duration.seconds(0.25), subMenu1);
                menuTransition1.setToX(subMenu1.getTranslateX() + offset);

                // moving the main menu into the place
                TranslateTransition menuTransition2 = new TranslateTransition(Duration.seconds(0.5), mainMenu);
                menuTransition2.setToX(subMenu1.getTranslateX());

                //playing the transitions
                menuTransition1.play();
                menuTransition2.play();

                //remove the sub menu
                menuTransition1.setOnFinished(event -> getChildren().remove(subMenu1)
                );
            });

            MenuButton buttonSound = new MenuButton("SOUND");
            MenuButton buttonVideo = new MenuButton("VIDEO");

            mainMenu.getChildren().addAll(buttonResume, buttonOptions, buttonQuit);
            subMenu1.getChildren().addAll(buttonVideo, buttonSound, buttonBack);

            Rectangle menuBackground = new Rectangle(900, 600);
            menuBackground.setFill(Color.GRAY);
            menuBackground.setOpacity(0.4);

            getChildren().addAll(menuBackground, mainMenu);
        }
    }

    // creating a menu button
    private  static  class MenuButton extends StackPane {
        private Text label;

        //constructor
        public MenuButton (String btnName){
            label = new Text(btnName);
            label.setFont(label.getFont().font(20));
            label.setFill(Color.YELLOW);

            // button background
            Rectangle btnRectangle = new Rectangle(300, 35);
            btnRectangle.setOpacity(0.6);
            btnRectangle.setFill(Color.BLACK);
            btnRectangle.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.6);
            getChildren().addAll(btnRectangle, label);

            //mouse hoover event
            this.setOnMouseEntered(e -> {
                btnRectangle.setTranslateX(10);
                label.setTranslateX(10);
                btnRectangle.setFill(Color.YELLOW);
                label.setFill(Color.BLACK);
            });
            // mouse exit event
            this.setOnMouseExited(e -> {
                btnRectangle.setTranslateX(0);
                label.setTranslateX(0);
                btnRectangle.setFill(Color.BLACK);
                label.setFill(Color.YELLOW);
            });

            DropShadow dropShadow = new DropShadow(50, Color.WHITE);
            dropShadow.setInput(new Glow());
            this.setOnMousePressed(e -> setEffect(dropShadow));
            this.setOnMouseReleased(e -> setEffect(null));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}