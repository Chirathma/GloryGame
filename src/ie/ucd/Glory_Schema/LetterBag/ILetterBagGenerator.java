package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.LetterValueElement;

import java.util.ArrayList;

/**
 * Created by Devni on 6/19/2018.
 */
public interface ILetterBagGenerator {

     ArrayList<LetterValueElement> generateLetterBag();
     ArrayList<LetterValueElement> generateVowelLetter();
     ArrayList<LetterValueElement> generateConsonantLetter();
}
