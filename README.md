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

# How strong is the encryption of HC-9?
The key space of HC-9 can be calculated for various combinations of rotors and whether all the positions of the rotors can be used as initial state.
(see `Calculation of the Key Space of the HC-9` in [Cipher Machines Transvertex HC-9](http://ciphermachines.com/transvertex)). As stated in this page, [...] *The theoretical key space for the Enigma is 3.28 X 10 ^ 114 but the practical key space was greatly reduced to 1.07 X 10^23* [...]

## The original HC-9 for reference 

```
HC-9 Key Space with 5 rotors , using Letters only for initial state
  rotors combinations: 11,881,376
  rotors pins combinations: 2,923,003,274,661,805,836,407,369,665,432,566,039,311,865,085,952
  alphabets combinations: 126,493,657,289,880
 = 4,393,036,292,980,624,879,041,381,919,139,963,735,122,550,448,068,968,993,938,046,986,485,760
 ~ 4.393 x 10^69
```
**Key space: ~ 4.393 x 10^69** . The key space is larger than the practical key space of Enigma.


## The original HC-9 if all the positions on the rotors were used as starting point
```
HC-9 Key Space with 5 rotors , using all positions for initial state 
  rotors combinations: 35,303,730
  rotors pins combinations: 2,923,003,274,661,805,836,407,369,665,432,566,039,311,865,085,952
  alphabets combinations: 126,493,657,289,880
 = 13,053,249,654,550,859,762,451,723,276,849,340,675,234,757,146,815,815,166,556,503,854,284,800
 ~ 1.305 x 10^70
```
***Key space: ~ 1.305 x 10^70***

### The HC9 with more rotors and using all the positions of the rotors as starting point
This is not practical for the design and size of HC-9 as one of the biggest issues would be that the alphabets' drum would be large and hard to be accomodated by such a small machine.
But for the sake of comparison, *IF* HC-9 had rotors with these pin sizes: [29, 31, 33, 34, 35, 37, 41, 47, 53, 59]


#### HC-9 Key Space with 7 rotors, using Letters only for initial state
```
  rotors combinations: 8,031,810,176
  rotors pins combinations: 883,423,532,389,192,164,791,648,750,371,459,257,913,741,948,437,809,479,060,803,100,646,309,888
  alphabets combinations: 505,974,629,157,984
 = 3,590,137,980,724,869,295,443,467,174,738,845,665,334,668,728,251,068,248,370,258,330,046,241,824,933,085,486,071,984,152,379,392
 ~ 3.590 x 10^96
``` 
**Key space: ~ 3.590 x 10^96**


#### HC-9 Key Space with 7 rotors, using all positions for initial state 
```
  rotors combinations: 53,555,758,410
  rotors pins combinations: 883,423,532,389,192,164,791,648,750,371,459,257,913,741,948,437,809,479,060,803,100,646,309,888
  alphabets combinations: 505,974,629,157,984
 = 23,938,882,784,954,196,689,620,225,634,062,454,378,271,804,192,549,203,111,811,619,507,234,550,871,008,264,315,327,937,742,110,720
 ~ 2.393 x 10^97
```
**Key space: ~ 2.393 x 10^97***

#### HC-9 Key Space with 8 rotors, using all positions for initial state 
```
  rotors combinations: 2,517,120,645,270
  rotors pins combinations: 124,330,809,102,446,660,538,845,562,036,705,210,025,114,037,699,336,929,360,115,994,223,289,874,253,133,343,883,264
  alphabets combinations: 1,011,949,258,311,872
 = 316,695,234,294,301,132,532,726,160,402,984,597,526,383,372,676,155,509,907,711,375,026,531,057,776,126,730,051,013,851,441,059,443,793,297,837,916,160
 ~ 3.166 x 10^113
```
**Key space: ~ 3.166 x 10^113***

#### HC-9 Key Space with 9 rotors, using all positions for initial state 
```
  rotors combinations: 133,407,394,199,310
  rotors pins combinations: 1,119,872,371,088,902,105,278,721,140,284,222,139,060,822,748,617,324,767,449,994,550,481,895,935,590,080,472,690,438,746,635,803,557,888
  alphabets combinations: 2,023,898,516,607,360
 = 302,368,930,299,011,461,928,063,197,625,643,153,015,243,437,999,749,738,874,352,461,094,538,054,925,911,739,488,542,240,354,647,802,094,247,975,051,465,718,497,511,525,580,800
 ~ 3.023 x 10^131 
 ```
 ***Key space: ~ 3.023 x 10^131***

#### HC-9 Key Space with 10 rotors, using all positions for initial state 
```
  rotors combinations: 7,871,036,257,759,290
  rotors pins combinations: 645,562,469,521,727,147,413,979,793,000,752,968,582,426,448,207,305,878,207,664,839,135,161,905,504,210,298,657,411,338,320,034,457,858,975,792,993,186,873,344
  alphabets combinations: 4,047,797,033,149,184
 = 20,567,850,881,602,244,475,951,023,959,801,460,394,840,945,394,439,340,295,798,069,676,872,155,800,265,056,569,888,963,752,461,034,955,842,616,942,617,856,217,167,014,924,446,876,414,531,507,941,539,840
 ~ 2.056 x 10^151
 ```
 ***Key space: ~ 2.056 x 10^151***
 
