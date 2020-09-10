package correction.test1;

public class GenMBP {        //TO COMPLETE

    private static final String OPENING = "(";
    private static final String CLOSING = ")";
    private static final String SEP = " / ";

    public static void genMBP(int n){
        genMBP("",0,2*n);
    }

    private static void genMBP(String pref, int aFermer, int reste){
        if (reste == 0){
            System.out.print(pref + SEP);
            return;
        }
        if (0 < aFermer) genMBP(pref+CLOSING,aFermer-1,reste-1);
        if (aFermer+1 < reste) genMBP(pref+OPENING,aFermer+1,reste-1);
    }

}