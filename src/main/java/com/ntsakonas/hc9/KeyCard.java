package com.ntsakonas.hc9;


public class KeyCard
{
    // a hole in the punch card produces a logical '1'
    // absence of a hole in the punch card produces a logical '0'
    //
    // the punch card setting is "serialised" in wheel order (1-5)
    // and in letter order (A-Z plus padding numbers)
    // (as we look the card from the rear, pin settings for wheel 1 are at the right side of the card
    // and wheel 5 is at the left side of the card)
    // in the serialised format, a '1' represents a hole and a '0' represents the absence of a hole
    //
    // the only available card is the TOTAL-UTB NR2 training card
    private final String[] pinSettings= {
            "01111001010011110010000101101",        // Wheel 1, 29 pins
            "1001101101101110100110000001100",      // Wheel 2, 31 pins
            "100100010011111010100101100011111",    // Wheel 3, 33 pins
            "0010001111101001101111101010110011",   // Wheel 4, 34 pins
            "01110011100101011000010000001111110",  // Wheel 5, 35 pins
    };

    public boolean hasHole(int wheelNumber,int pinNumber)
    {
        return pinSettings[wheelNumber].charAt(pinNumber) == '1';
    }
}
