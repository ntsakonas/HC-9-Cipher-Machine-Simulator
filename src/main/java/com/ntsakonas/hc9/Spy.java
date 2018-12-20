package com.ntsakonas.hc9;

public class Spy
{
    private final HC9Machine machine;
    private String rotorsSetting;
    public Spy(){
        // this key is chosen according to some pre-arranged procedure
        rotorsSetting = "BLVGM";
        KeyCard keyCard = pickKeyCard();
        AlphabetWheel alphabetWheel = setAlphabetWheel();
        machine = new HC9Machine(keyCard, rotorsSetting, alphabetWheel);
    }

    private KeyCard pickKeyCard()
    {
        // for the moment only one key card is available
        // the TOTAL-UTB NR2 training card
        return new KeyCard();
    }

    private AlphabetWheel setAlphabetWheel()
    {
        // only the training set (TOTAL-UTB) alphabet is available.
        return new AlphabetWheel();
    }

    // encryption/decryption are reciprocal
    public String decryptMessage(String encryptedMessage)
    {
        return runMessage(encryptedMessage);
    }

    public String encryptMessage(String plainTextMessage)
    {
        return runMessage(plainTextMessage);
    }

    private String runMessage(String message)
    {
        String compressedText = message.replaceAll("\\s+", "").toUpperCase();
        StringBuilder transformedText = compressedText.chars().map(c ->
        {
            // the process goes as follows:
            // first the crank is triggered so the machine will calculate a new alphabet
            // then we translate the letter based on this alphabet
            machine.calculateNext();
            return machine.mapLetter(c);
        }).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        return groupIntoBlocks(transformedText.toString());
    }

    private String groupIntoBlocks(String message)
    {
        StringBuilder groupedText =
                message.chars().collect(StringBuilder::new, (sb, letter) ->
                {
                    if (sb.length() % 6 ==0)
                        sb.append(" ");
                    sb.appendCodePoint(letter);
                }, StringBuilder::append);
        return groupedText.toString();
    }

    private String getRotorsSetting()
    {
        return rotorsSetting;
    }

    public static void main(String[] args)
    {
        System.out.println("A Transvertex HC-9 cipher machine simulator by N.Tsakonas.");
        System.out.println("(based on information from cryptomuseum.com HC-9 page)\n");

        // Mr.Spy wants to sent a message to Mr.AnotherSpy...
        Spy spy = new Spy();
        String secretMessage = "MEET ME TOMORROW AT MIDNIGHT AT THE USUAL PLACE";
        System.out.println("Secret Message: " + secretMessage);

        String encryptedMessage = spy.encryptMessage(secretMessage);
        System.out.println("Rotor settings: " + spy.getRotorsSetting());
        System.out.println("Encrypted Message: " + encryptedMessage);

        // message transmitted...
        // repeat with the same settings
        Spy anotherSpy = new Spy();
        String decryptedMessage = anotherSpy.decryptMessage(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

}
