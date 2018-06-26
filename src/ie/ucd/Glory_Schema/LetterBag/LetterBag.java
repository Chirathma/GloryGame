package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.InitialLetterValueElement;
import ie.ucd.Glory_Schema.LetterValueElement;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Devni on 6/19/2018.
 */
public class LetterBag implements ILetterBag {
    private LetterBagService service = new LetterBagService();

    private LetterBagGenerator letterBagGenerator = new LetterBagGenerator();
    private ArrayList<LetterValueElement> initials = letterBagGenerator.generateLetterBag();
    private ArrayList<LetterValueElement> vowels = letterBagGenerator.generateVowelLetter();
    private ArrayList<LetterValueElement> consonants = letterBagGenerator.generateConsonantLetter();

    public LetterBag(ILetterBagGenerator generator) {
    }

    @Override
    public LetterValueElement getVowelLetter() {
        this.shuffleLetters(vowels);
        return service.getVowel();
    }

    @Override
    public LetterValueElement getConsonantLetter() {
        this.shuffleLetters(consonants);
        return service.getConsonant();
    }

    @Override
    public InitialLetterValueElement getInitialLetter() {
        this.shuffleLetters(initials);
        return service.getInitialLetters();
    }

    private void shuffleLetters(ArrayList<LetterValueElement> list) {
        Collections.shuffle(list);
    }
}

