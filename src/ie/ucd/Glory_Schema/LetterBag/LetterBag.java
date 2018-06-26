package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.LetterValueElement;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Devni on 6/19/2018.
 */
public class LetterBag implements ILetterBag {
    private LetterBagService service = new LetterBagService();
    private LetterBagGenerator generator = new LetterBagGenerator();

    public LetterBag(ILetterBagGenerator generator) {
        generator.generateConsonantLetter();
        generator.generateVowelLetter();
        generator.generateLetterBag();
    }

    @Override
    public char getVowelLetter() {
        this.shuffleVowels();
        char vowel = service.getVowel().getLetter();

        System.out.println("LB char vowel: " + vowel);

        return vowel;
    }

    @Override
    public char getConsonantLetter() {
        this.shuffleConsonants();
//        char consonant = service.getConsonant().getLetter();

        return service.getConsonant().getLetter();
    }

    @Override
    public char getInitialLetter() {
        this.shuffleLetters();
//        for (int i = 0; i < 2; i++)
//            char letterList = service.getInitialLetters().getLetter();
//            ArrayList<Character> letterList = service.getInitialLetters().;

        return service.getInitialLetters().getLetter();
    }

    public void shuffleLetters() {
        ArrayList<LetterValueElement> letters = generator.generateLetterBag();
        Collections.shuffle(letters);


        for (int i = 0; i < letters.size(); i++) {
            System.out.println("LB shuffled letters: " + letters.get(i).getLetter() + " ");
        }
    }

    void shuffleVowels() {
        ArrayList<LetterValueElement> vowels = generator.generateVowelLetter();
        Collections.shuffle(vowels);

        for (int i = 0; i < vowels.size(); i++) {
            System.out.println("LB shuffled vowel: " + vowels.get(i).getLetter() + " ");
        }
    }

    void shuffleConsonants() {
        ArrayList<LetterValueElement> consonants = generator.generateConsonantLetter();
        Collections.shuffle(consonants);

        for (int i = 0; i < consonants.size(); i++) {
            System.out.println("LB shuffled consonants: " + consonants.get(i).getLetter() + " ");
        }
    }
}
