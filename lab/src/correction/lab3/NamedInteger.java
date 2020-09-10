package correction.lab3;

public class NamedInteger implements Comparable<NamedInteger> {
    private String value;
    private int key;
    public int getKey(){ return key;}

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(NamedInteger namedInteger) {
        return key-namedInteger.getKey();
    }
}
