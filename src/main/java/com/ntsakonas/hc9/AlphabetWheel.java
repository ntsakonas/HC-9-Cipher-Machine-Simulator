package com.ntsakonas.hc9;

import java.util.ArrayList;
import java.util.List;

public class AlphabetWheel
{
    private List<Alphabet> alphabets;
    public AlphabetWheel(){
        installAlphabetRows();
    }

    private void installAlphabetRows()
    {
        // the training set (TOTAL-UTB) is used here
        alphabets = new ArrayList<>();
        alphabets.add(new Alphabet("KGTQFEBJXHAPUVRLDOZCMNYIWS"));
        alphabets.add(new Alphabet("JUDCGZEXLATINMWSRQPKBYOHVF"));
        alphabets.add(new Alphabet("ZOEJCWKVYDGNXLBRSPQUTHFMIA"));
        alphabets.add(new Alphabet("WCBEDSYLZKJHOTMQPVFNXRAUGI"));
        alphabets.add(new Alphabet("GXFKPCALWSDHNMYEUVJZQRIBOT"));
        alphabets.add(new Alphabet("CTAFODUQZXVNYLEWHSRBGKPJMI"));
        alphabets.add(new Alphabet("HVNYLQIAGPZEOCMJFXTSWBURDK"));
        alphabets.add(new Alphabet("DIRAQXOKBZHTVSGWECNLYMPFUJ"));
        alphabets.add(new Alphabet("EZLXAKWOQVFCUTHRIPYNMJGDSB"));
        alphabets.add(new Alphabet("QKNVLMOXUTBEFCGSAYPJIDZHRW"));
        alphabets.add(new Alphabet("YPDCOWVNKTIURHEBZMXJLGFSAQ"));
        alphabets.add(new Alphabet("ZPOEDRINGWUYTHCBVFXMKQJSLA"));
        alphabets.add(new Alphabet("OPDCVXZQUMLKJTABHWYNIERFSG"));
        alphabets.add(new Alphabet("EZSVAXRTJIWQNMYULGCHPDKFOB"));
        alphabets.add(new Alphabet("SXMQWJZUTFNPCKYLDVAIHREBOG"));
        alphabets.add(new Alphabet("QIKSLPWJBHCEYTUFAZDNOXGVMR"));

        if (alphabets.size() != 16)
            throw new IllegalArgumentException("The machine requires 16 alphabets. Only "+alphabets.size()+" provided.");
    }

    public Alphabet getAlphabetAt(int position)
    {
        if (position < 0 || position >= alphabets.size())
            throw new IllegalArgumentException("The requested alphabet does not exist");
        return alphabets.get(position);
    }
}
