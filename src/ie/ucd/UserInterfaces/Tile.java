package ie.ucd.UserInterfaces;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{

    private LetterMaterial letter;

    public LetterMaterial getLetter() {
        return letter;
    }

    public void setLetter(LetterMaterial letter) {
        this.letter = letter;
    }

    public boolean hasLetter () {
        return letter != null;
    }

    public Tile (boolean light, int x, int y) {
        setWidth (Game.TILE_SIZE);
        setHeight(Game.TILE_SIZE);

        relocate(x* Game.TILE_SIZE, y * Game.TILE_SIZE);

        if(light) {
            setFill(Color.valueOf("#feb"));

        }
        else
            setFill(Color.valueOf("#582"));

    }
}