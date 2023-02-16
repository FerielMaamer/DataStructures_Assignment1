public class WordInfo {
    String word;
    String meaning;

    public WordInfo(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "WordInfo{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
