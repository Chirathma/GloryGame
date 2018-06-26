package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;

import java.util.ArrayList;

/**
 * Created by Devni on 6/13/2018.
 */
public class LetterBagService implements ILetterBagService {

    private LetterBagGenerator letterBagGenerator = new LetterBagGenerator();
    private ArrayList<LetterValueElement> initials = letterBagGenerator.generateLetterBag();
    private ArrayList<LetterValueElement> vowel = letterBagGenerator.generateVowelLetter();
    private ArrayList<LetterValueElement> consonant = letterBagGenerator.generateConsonantLetter();

    private LetterBag letterBag = new LetterBag(letterBagGenerator);

    public LetterBagService(LetterBag letterBag) {
        letterBag.shuffleLetters();
        letterBag.shuffleConsonants();
        letterBag.shuffleVowels();
    }

    LetterBagService() {

    }

    @Override
    public InitialLetterValueElement getInitialLetters() {
        letterBag.shuffleLetters();
        for (int i = 0; i < 3; i++) {
            System.out.println("LBS Initial letters: " + initials.get(i).getLetter());
        }
        return null;
    }

    @Override
    public LetterValueElement getVowel() {
        letterBag.shuffleVowels();
        for (int i = 0; i < 5; i++) {
            System.out.println("LBS Vowel letters: " + vowel.get(i).getLetter());
        }
        return null;
    }

    @Override
    public LetterValueElement getConsonant() {
        letterBag.shuffleConsonants();
        for (int i = 0; i < 22; i++) {
            System.out.println("LBS Consonant letters: " + consonant.get(i).getLetter());
        }
        return null;
    }
}
