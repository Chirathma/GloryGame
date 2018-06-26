package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;

/**
 * Created by Devni on 6/13/2018.
 */
public class LetterBagService implements ILetterBagService {

    private LetterBagGenerator letterBagGenerator = new LetterBagGenerator();
    private LetterBag letterBag = new LetterBag(letterBagGenerator);

    public LetterBagService(ILetterBag letterBag) {
    }

    public LetterBagService() {

    }

    @Override
    public InitialLetterValueElement getInitialLetters() {
        /*for (int i = 0; i < 3; i++) {
            initials.get(i).getLetter();
            System.out.println("LBS Initial letters: " + initials.get(i).getLetter());
        }*/
        return letterBag.getInitialLetter();
    }

    @Override
    public LetterValueElement getVowel() {
        /*for (int i = 0; i < 5; i++) {
            System.out.println("LBS Vowel letters: " + vowel.get(i).getLetter());
        }*/
        return letterBag.getVowelLetter();
    }

    @Override
    public LetterValueElement getConsonant() {
        /*for (int i = 0; i < 22; i++) {
            System.out.println("LBS Consonant letters: " + consonant.get(i).getLetter());
        }*/
        return letterBag.getConsonantLetter();
    }
}
