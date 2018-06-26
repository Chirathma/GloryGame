package ie.ucd.Glory_Schema.LetterBag;

import ie.ucd.Glory_Schema.ConstantElement;
import ie.ucd.Glory_Schema.LetterValueElement;

import java.util.ArrayList;

/**
 * Created by Devni on 6/13/2018.
 */
public class LetterBagGenerator implements ILetterBagGenerator {

    private ArrayList<LetterValueElement> vowelLetters;
    private ArrayList<LetterValueElement> consonantLetters;
    final private ArrayList<LetterValueElement> letterlist;

    public LetterBagGenerator() {
        LetterValueElement aTile = new LetterValueElement('A', 1);
        LetterValueElement bTile = new LetterValueElement('B', 3);
        LetterValueElement cTile = new LetterValueElement('C', 3);
        LetterValueElement dTile = new LetterValueElement('D', 2);
        LetterValueElement eTile = new LetterValueElement('E', 1);
        LetterValueElement fTile = new LetterValueElement('F', 4);
        LetterValueElement gTile = new LetterValueElement('G', 2);
        LetterValueElement hTile = new LetterValueElement('H', 4);
        LetterValueElement iTile = new LetterValueElement('I', 1);
        LetterValueElement jTile = new LetterValueElement('J', 8);
        LetterValueElement kTile = new LetterValueElement('K', 5);
        LetterValueElement lTile = new LetterValueElement('L', 1);
        LetterValueElement mTile = new LetterValueElement('M', 3);
        LetterValueElement nTile = new LetterValueElement('N', 1);
        LetterValueElement oTile = new LetterValueElement('O', 1);
        LetterValueElement pTile = new LetterValueElement('P', 3);
        LetterValueElement qTile = new LetterValueElement('Q', 10);
        LetterValueElement rTile = new LetterValueElement('R', 1);
        LetterValueElement sTile = new LetterValueElement('S', 1);
        LetterValueElement tTile = new LetterValueElement('T', 1);
        LetterValueElement uTile = new LetterValueElement('U', 1);
        LetterValueElement vTile = new LetterValueElement('V', 4);
        LetterValueElement wTile = new LetterValueElement('W', 4);
        LetterValueElement xTile = new LetterValueElement('X', 8);
        LetterValueElement yTile = new LetterValueElement('Y', 4);
        LetterValueElement zTile = new LetterValueElement('Z', 10);

        ConstantElement frequencyOne = new ConstantElement(1);
        ConstantElement frequencyTwo = new ConstantElement(2);
        ConstantElement frequencyFour = new ConstantElement(4);
        ConstantElement frequencySix = new ConstantElement(6);
        ConstantElement frequencyEight = new ConstantElement(8);
        ConstantElement frequencyNine = new ConstantElement(9);
        ConstantElement frequencyTwelve = new ConstantElement(12);


        letterlist = new ArrayList<>();
        vowelLetters = new ArrayList<>();
        consonantLetters = new ArrayList<>();

        //vowelLetters & constantLetters arrays are used to draw vowels & consonants inorder to the players selection
        //add 12 e letters
        for (int i = 0; i < frequencyTwelve.getValue(); i++) {
            vowelLetters.add(eTile);
        }

        //add 9 a & i letters
        for (int i = 0; i < frequencyNine.getValue(); i++) {
            vowelLetters.add(aTile);
            vowelLetters.add(iTile);
        }

        //add 8 o letters
        for (int i = 0; i < frequencyEight.getValue(); i++) {
            vowelLetters.add(oTile);
        }

        //add 6 n, r & t letters
        for (int i = 0; i < frequencySix.getValue(); i++) {
            consonantLetters.add(nTile);
            consonantLetters.add(rTile);
            consonantLetters.add(tTile);
        }

        //add 4 d, l, s & u  letters
        for (int i = 0; i < frequencyFour.getValue(); i++) {
            consonantLetters.add(dTile);
            consonantLetters.add(lTile);
            consonantLetters.add(sTile);
            vowelLetters.add(uTile);
        }

        //add 3 g letters
        for (int i = 0; i < 3; i++) {
            consonantLetters.add(gTile);
        }

        //add 2 b, c, f, h, m, p, v, w  & y letters
        for (int i = 0; i < frequencyTwo.getValue(); i++) {
            consonantLetters.add(bTile);
            consonantLetters.add(cTile);
            consonantLetters.add(fTile);
            consonantLetters.add(hTile);
            consonantLetters.add(mTile);
            consonantLetters.add(pTile);
            consonantLetters.add(vTile);
            consonantLetters.add(wTile);
            consonantLetters.add(yTile);
        }

        //add 1 j, k, q, x & z letters
        for (int i = 0; i < frequencyOne.getValue(); i++) {
            consonantLetters.add(jTile);
            consonantLetters.add(kTile);
            consonantLetters.add(qTile);
            consonantLetters.add(xTile);
            consonantLetters.add(zTile);
        }


        //letterlist array is used to get the initial letters
        //add 12 e letters = 12
        for (int i = 0; i < frequencyTwelve.getValue(); i++) {
            letterlist.add(eTile);
        }

        //add 9 a & i letters 18
        for (int i = 0; i < frequencyNine.getValue(); i++) {
            letterlist.add(aTile);
            letterlist.add(iTile);
        }

        //add 8 o letters = 8
        for (int i = 0; i < frequencyEight.getValue(); i++) {
            letterlist.add(oTile);
        }

        //add 6 n, r & t letters = 18
        for (int i = 0; i < frequencySix.getValue(); i++) {
            letterlist.add(nTile);
            letterlist.add(rTile);
            letterlist.add(tTile);
        }

        //add 4 d, l, s & u  letters = 16
        for (int i = 0; i < frequencyFour.getValue(); i++) {
            letterlist.add(dTile);
            letterlist.add(lTile);
            letterlist.add(sTile);
            letterlist.add(uTile);
        }

        //add 3 g letters = 3
        for (int i = 0; i < 3; i++) {
            letterlist.add(gTile);
        }

        //add 2 b, c, f, h, m, v, w  & y letters = 16
        for (int i = 0; i < frequencyTwo.getValue(); i++) {
            letterlist.add(bTile);
            letterlist.add(cTile);
            letterlist.add(fTile);
            letterlist.add(hTile);
            letterlist.add(mTile);
            letterlist.add(pTile);
            letterlist.add(vTile);
            letterlist.add(wTile);
            letterlist.add(yTile);
        }

        //add 1 j, k, q, x & z letters = 5
        for (int i = 0; i < frequencyOne.getValue(); i++) {
            letterlist.add(jTile);
            letterlist.add(kTile);
            letterlist.add(qTile);
            letterlist.add(xTile);
            letterlist.add(zTile);
        }
    }

    @Override
    public ArrayList<LetterValueElement> generateLetterBag() {
        System.out.println("LBG Letters size: " + letterlist.size());
        for (int i = 0; i < letterlist.size(); i++)
            System.out.println("LBG generate the letter bag: " + letterlist.get(i).getLetter());
        return letterlist;
    }


    @Override
    public ArrayList<LetterValueElement> generateVowelLetter() {
        System.out.println("LBG vowelLetters size: " + vowelLetters.size());
        for (int i = 0; i < vowelLetters.size(); i++)
            System.out.println("LBG vowels generated : " + vowelLetters.get(i).getLetter());

        return vowelLetters;
    }

    @Override
    public ArrayList<LetterValueElement> generateConsonantLetter() {
        System.out.println("LBG consonantLetters size: " + consonantLetters.size());
        for (int i = 0; i < consonantLetters.size(); i++)
            System.out.println("LBG consonants generated : " + consonantLetters.get(i).getLetter());

        return consonantLetters;
    }
}
