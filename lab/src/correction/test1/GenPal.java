package correction.test1;

public class GenPal { //TO COMPLETE

    private static final String[] ALPHABET = {"0","1","2"};
    private static final String SEP = " ";


    public static void genPal(int n){
        if (n%2 == 0) genPal("", n);
        else{
            for (String lettre  : ALPHABET) {
                genPal(lettre,n);
            }
        }
    }

    private static void genPal(String m, int n){
        if (n <= 1) {
            System.out.print(m + SEP);
            return;
        }
        for (String lettre  : ALPHABET) {
            genPal(lettre+m+lettre,n-2);
        }
    }

    public static void main(String[] args) {
        GenPal genPal =new GenPal();
        genPal.genPal(2);
    }
}

