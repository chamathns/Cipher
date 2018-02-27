package sample;

public class Substitution {
    private static Substitution instance = new Substitution();

    public static Substitution getInstance() {
        return instance;
    }

    private String encryptSubstitution(String inputValue, String passphrase) {
        String substitutedValue = "";
        int value = 0;
        int keyLength = passphrase.length();

        for (int j = 0; j < keyLength; j++) {
            value += (int) passphrase.charAt(j);
        }

        int subVal = value % keyLength + keyLength;

        for (int i = 0; i < inputValue.length(); i++) {
            char c = inputValue.charAt(i);
            if (i % keyLength == 0) {
                substitutedValue += ((char) (c + subVal));
            } else if (i % keyLength == 1) {
                substitutedValue += ((char) (c + subVal + keyLength % 2));
            } else if (i % keyLength == 2) {
                substitutedValue += ((char) (c + subVal + keyLength % 3));

            } else if (i % keyLength == 3) {
                substitutedValue += ((char) (c + subVal + keyLength % 5));

            } else {
                substitutedValue += ((char) (c + subVal + keyLength % 7));
            }

        }
        return substitutedValue;
    }


    public String getEncryptSubstitution(String input, String passphrase){
        return Substitution.getInstance().encryptSubstitution(input, passphrase);
    }


        private String decryptSubstitution (String inputValue, String passphrase){
            String decryptedValue = "";
            int keyLength = passphrase.length();
            int value = 0;

            for (int j = 0; j < keyLength; j++) {
                value += (int) passphrase.charAt(j);
            }

            int subVal = value % keyLength + keyLength;

            for (int i = 0; i < inputValue.length(); i++) {
                char c = inputValue.charAt(i);
                if (i % keyLength == 0) {
                    decryptedValue += ((char) (c - subVal));
                } else if (i % keyLength == 1) {
                    decryptedValue += ((char) (c - subVal - keyLength % 2));
                } else if (i % keyLength == 2) {
                    decryptedValue += ((char) (c - subVal - keyLength % 3));
                } else if (i % keyLength == 3) {
                    decryptedValue += ((char) (c - subVal - keyLength % 5));
                } else {
                    decryptedValue += ((char) (c - subVal - keyLength % 7));
                }
            }
            return decryptedValue;
        }

    public String getDecryptSubstitution(String input, String passphrase){
        return Substitution.getInstance().decryptSubstitution(input, passphrase);
    }

}
