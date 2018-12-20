package com.ntsakonas.hc9;

public class CardReader
{
    private final KeyCard card;

    public CardReader(KeyCard card)
    {
        this.card = card;
    }

    public boolean isPinEnabled(Rotor rotor)
    {
        // the wheel numbers are 1-based for consistency with the machine description, so it is adjusted here
        return card.hasHole(rotor.getRotorNumber() - 1,rotor.getCurrentPosition());
    }
}
