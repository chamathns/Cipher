package sample;

public class Permutation {

    public String encryptWithPerm(String inputString, String secretKey){

        int deficit;
        int n = secretKey.length();
        deficit = inputString.length()%n;
        System.out.println("Deficit: "+deficit);
        if(deficit != 0) {
            deficit = n-deficit;
            for(int a = deficit; a != 0 ; a--) {
                inputString += "*";
            }
        }
        System.out.println(inputString);
        StringBuffer permutedString = new StringBuffer();
        int width = inputString.length()/n;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < width ; j++) {
                char c = inputString.charAt(i+(j*n));
//                System.out.print(c);
                permutedString.append(c);
            }
//            System.out.println();
        }
        System.out.println(permutedString);
        return permutedString.toString();
    }

    public String decryptWithPerm(String inputString, String secretKey){
        int n = secretKey.length();
        int width = inputString.length()/n;
        if(inputString.length()%n != 0){
            return "Invalid secret key";
        }
        else{

            StringBuffer reorganisedString = new StringBuffer();
            for(int i = 0 ; i < width ; i++) {
                for(int j = 0 ; j< n ; j++) {
                    char c = inputString.charAt(i+(j*width));
//                    System.out.print(c);
                    reorganisedString.append(c);
                }
//                System.out.println();
            }


            return reorganisedString.toString();
        }
    }
}