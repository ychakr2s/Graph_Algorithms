package AbstractGraphColoring;

public class Algorithm {

    private String algorithm;
    private int numberColors;
    private int[] coloredUsed;

    public Algorithm(int num, int[] colors, String name) {
        this.numberColors = num;
        this.coloredUsed = colors;
        this.algorithm = name;
    }
}






