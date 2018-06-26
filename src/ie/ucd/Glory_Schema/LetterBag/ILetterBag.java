package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;

/**
 * Created by Devni on 6/13/2018.
 */
public interface ILetterBag{

     LetterValueElement getVowelLetter();
     LetterValueElement getConsonantLetter();
     InitialLetterValueElement getInitialLetter();
}
