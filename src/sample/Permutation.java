package sample;

public class Permutation {
    private static Permutation instance = new Permutation();

    public static Permutation getInstance() {
        return instance;
    }

    private String encryptPermutation(String inputValue, String passphrase){

        int deficit;
        int keyLength = passphrase.length();
        deficit = inputValue.length()%keyLength;
        if(deficit != 0) {
            deficit = keyLength-deficit;
            for(int i = deficit; i != 0 ; i--) {
                inputValue += "*";
            }
        }
        System.out.println(inputValue);
        StringBuffer permutedValue = new StringBuffer();
        int width = inputValue.length()/keyLength;
        for(int i = 0 ; i < keyLength ; i++) {
            for(int j = 0 ; j < width ; j++) {
                char c = inputValue.charAt(i+(j*keyLength));
                permutedValue.append(c);
            }
        }
        System.out.println(permutedValue);
        return permutedValue.toString();
    }

    public String getEncryptPermutation(String input, String passphrase){
        return Permutation.getInstance().encryptPermutation(input, passphrase);
    }


    private String decryptPermutation(String inputValue, String passphrase){
        int n = passphrase.length();
        int width = inputValue.length()/n;
        if(inputValue.length()%n != 0){
            return "Invalid secret key";
        }
        else{

            StringBuffer reorganisedValue = new StringBuffer();
            for(int i = 0 ; i < width ; i++) {
                for(int j = 0 ; j< n ; j++) {
                    char c = inputValue.charAt(i+(j*width));
                    reorganisedValue.append(c);
                }
            }


            return reorganisedValue.toString();
        }
    }
    public String getDecryptPermutation(String input, String passphrase){
        return Permutation.getInstance().decryptPermutation(input, passphrase);
    }
}