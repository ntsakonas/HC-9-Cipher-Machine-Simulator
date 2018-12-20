package com.ntsakonas.hc9;

import java.util.ArrayList;
import java.util.List;

public class HC9Machine
{
    private final CardReader cardReader;
    private final List<Rotor> rotors;
    private final AlphabetWheel alphabet;
    private int currentAlphabet;

    public HC9Machine(KeyCard card, String rotorsSetting, AlphabetWheel alphabet)
    {
        checkRotorSettings(rotorsSetting);
        this.cardReader = new CardReader(card);
        this.rotors = setKeyToRotors(rotorsSetting.toUpperCase());
        this.alphabet = alphabet;
    }

    private void checkRotorSettings(String rotorsSetting)
    {
        if (rotorsSetting.length() != 5 || rotorsSetting.indexOf(' ') != -1)
            throw new IllegalArgumentException("Key \""+rotorsSetting+"\" is not a valid setting for the rotors.");
    }

    private List<Rotor> setKeyToRotors(String rotorsSetting)
    {
        // rotora are placed in the order they appear on the machine
        // numbered from left to right (wheel 1 -> wheel5)
        List<Rotor> rotors = new ArrayList<>();
        rotors.add(new Rotor(1,29,rotorsSetting.charAt(0)));
        rotors.add(new Rotor(2,31,rotorsSetting.charAt(1)));
        rotors.add(new Rotor(3,33,rotorsSetting.charAt(2)));
        rotors.add(new Rotor(4,34,rotorsSetting.charAt(3)));
        rotors.add(new Rotor(5,35,rotorsSetting.charAt(4)));
        return rotors;
    }

    public void calculateNext()
    {
        advanceRotors();
        calculateNextAlphabet();
    }

    private void advanceRotors()
    {
        for (Rotor r:rotors)
            r.advance();
    }

    private void calculateNextAlphabet()
    {
        // reduce 5bits-> 4bit and convert to decimal count
        int[] adderWeights = {1,2,4,8};
        currentAlphabet = 0;
        for (int rotorNumber=0; rotorNumber<4; rotorNumber++){
            Rotor leftRotor = rotors.get(rotorNumber);
            Rotor rightRotor = rotors.get(rotorNumber + 1);
            boolean addWeight = cardReader.isPinEnabled(leftRotor) ^ cardReader.isPinEnabled(rightRotor);
            if (addWeight)
                currentAlphabet += adderWeights[rotorNumber];
        }
        // HC9 is counting backwards from the 16th alphabet
        // but the machine is using 1-based indexing. to adjust it here for indexing internally
        // we subtract 1
        currentAlphabet = 16 - currentAlphabet;
        currentAlphabet--;
    }

    public int mapLetter(int letter)
    {
        return alphabet.getAlphabetAt(currentAlphabet).getLetterAt(mapLetterToPosition(letter));
    }

    private int mapLetterToPosition(int letter)
    {
        return letter - 'A';
    }
}
