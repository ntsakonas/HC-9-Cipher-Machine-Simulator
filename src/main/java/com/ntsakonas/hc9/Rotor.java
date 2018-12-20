package com.ntsakonas.hc9;

public class Rotor
{
    private int rotorNumber;
    private int pinCount;
    private int currentPosition;

    public Rotor(int rotorNumber, int pinCount, char initialSetting)
    {
        this.rotorNumber = rotorNumber;
        this.pinCount = pinCount;
        if (initialSetting < 'A' || initialSetting > 'Z')
            throw new IllegalArgumentException("Invalid rotor setting "+initialSetting);
        this.currentPosition = initialSetting - 'A';
        if (currentPosition >= pinCount)
            throw new IllegalArgumentException("Invalid rotor setting");
    }

    public int getRotorNumber()
    {
        return rotorNumber;
    }

    public int getCurrentPosition()
    {
        return currentPosition;
    }

    public void advance()
    {
        currentPosition = (currentPosition + 1) % pinCount;
    }
}
