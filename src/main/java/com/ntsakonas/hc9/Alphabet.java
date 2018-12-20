package com.ntsakonas.hc9;

public class Alphabet
{
    private final String permutation;
    public Alphabet(String permutation)
    {
        if (permutation.length() != 26)
            throw new IllegalArgumentException("HC-9 machine supports latin alphabets only (26 characters required)");
        checkReciprocity(permutation);
        this.permutation = permutation;
    }

    private void checkReciprocity(String permutation)
    {
        for (int alphabetIndex = 0; alphabetIndex < permutation.length(); alphabetIndex++)
        {
            char character = permutation.charAt(alphabetIndex);
            int reciprocalIndex = character - 'A';
            int reciprocalCharacter = 'A' + alphabetIndex;
            if (permutation.charAt(reciprocalIndex) != (reciprocalCharacter))
                throw new IllegalArgumentException("The alphabet must be reciprocal, otherwise decryption will fail."+
                                                   "In alphabet ["+permutation+"] in position "+reciprocalIndex+
                                                   " the letter '"+(char)reciprocalCharacter+"'"+
                                                   " was expected, but found '"+permutation.charAt(reciprocalIndex));
        }
    }

    public char getLetterAt(int position){
        if (position < 0 || position > permutation.length())
            throw new IllegalArgumentException("the requested letter exceeds the alphabet length");
        return permutation.charAt(position);
    }
}
