package sample;

import java.math.BigInteger;

public class Substitution
{
    public String encryptWithSub(String inputString, String secretKey){
        String subString = "";
        int value = 0;

        for(int j = 0; j < secretKey.length(); j++){
            value += (int)secretKey.charAt(j);
        }

        int subVal = value % secretKey.length() + 2;

        for(int i=0 ; i<inputString.length() ; i++) {
            char c = inputString.charAt(i);
            if(i%3 == 0){
                subString += ((char) (c + subVal));
            }
            else if(i%3 == 1){
                subString += ((char) (c + subVal + 3));
            }
            else{
                subString += ((char) (c + subVal + 5));
            }

        }
//        System.out.println("Enc sub: "+subString);
        return subString;
    }

    public String decryptwithSub(String inputString, String secretKey){
        String decryptedString = "";

        int value = 0;

        for(int j = 0; j<secretKey.length(); j++){
            value += (int)secretKey.charAt(j);
        }

        int subVal = value%secretKey.length() + 2;

        for(int i=0; i<inputString.length(); i++){
            char c = inputString.charAt(i);
            if(i%3 == 0){
                decryptedString += ((char) (c - subVal));
            }
            else if(i%3 == 1){
                decryptedString += ((char) (c - subVal - 3));
            }
            else{
                decryptedString += ((char) (c - subVal - 5));
            }
        }
//        System.out.println("Dec sub: "+decryptedString);
        return decryptedString;
    }
}