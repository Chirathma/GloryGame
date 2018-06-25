package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;

/**
 * Created by Devni on 6/19/2018.
 */
public interface ILetterBagService {

     InitialLetterValueElement getInitialLetters();
     LetterValueElement getVowel();
     LetterValueElement getConsonant();
}
