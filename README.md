# HC-9 Cipher Machine Simulator

A simulator of the HC-9, a mechanical cipher machine built by Transvertex in the early '50s.
Based on the description from [Cryptomuseum Transvertex HC-9](https://www.cryptomuseum.com/crypto/transvertex/hc9/)

HC-9 is a masterpiece of mechanical engineering and was used for messages that had to remain secret for a few hours.
The key space of the HC-9 compares quite favourably with German Enigma (see [Cipher Machines Transvertex HC-9](http://ciphermachines.com/transvertex) ) 

A simple encryption/decryption example is provided in the project:

Suppose that we need to transmit the following message:


`MEET ME TOMORROW AT MIDNIGHT AT THE USUAL PLACE`

Using a randomly picked rotor settings: BLVGM ,we get the message to transmit


`FQLMJ CJCCE PVBFC NYGCT BAANK IKXOO TPYCE PZOP`

on the other side, when the message is received, with the same rotor settings (BLVGM) we get back the original message


`MEETM ETOMO RROWA TMIDN IGHTA TTHEU SUALP LACE`

