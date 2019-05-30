package wordCount;

public class StringFilter{    
    private String word;
    private int index, occurences;

    public StringFilter(String word, int index, int occurences){
        this.index = index;
        this.word = word;
        this.occurences = occurences;
    }

    public String getWord(){
        return word;
    }

    public int getOccurences(){
        return occurences;
    }

    @Override
    public String toString(){
        return "Words{" +
                "word ='" + word+ '\'' +
                ", index =" + index +
                ", occurences =" + occurences +
                '}';
    }
}