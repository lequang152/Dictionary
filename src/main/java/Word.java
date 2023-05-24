public class Word {
    //khai bao thuoc tinh
    private String word_target;
    private String word_explain;
    private String pronounce;

    //khai bao phuong thuc
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    /**
     * Constructor.
     */
    public Word() {

    }
    /**
     * constructor.
     * @param word_target tu can tra
     * @param word_explain nghia cua tu
     */
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public Word(String word_target, String word_explain, String pronounce) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.pronounce = pronounce;
    }
}

