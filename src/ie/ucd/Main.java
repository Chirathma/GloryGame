package ie.ucd;

import ie.ucd.GlorySchema.ConstantElement;
import ie.ucd.GlorySchema.InitialLetterValueElement;
import ie.ucd.GlorySchema.LetterValueElement;
import ie.ucd.Score.Scorer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Glory Game!");

        Scorer scorer = new Scorer();

        ConstantElement size = new ConstantElement(11);

        LetterValueElement [] elements = new LetterValueElement[size.getValue()];

        for(int i = 0; i < 1 ; ++i){
            elements[i] = new InitialLetterValueElement('a', 3);
        }

        for(int i = 1; i < size.getValue() ; ++i){
            elements[i] = new LetterValueElement('b', 1);
        }

        int score = scorer.getScore(elements);

        System.out.println("score is " + score);

    }
}
