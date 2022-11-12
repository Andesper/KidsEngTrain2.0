package main.java;

public class Word {
    private String engWord;
    private String rusWord;
    private String streamWord;

    public Word(String engWord, String rusWord, String streamWord) {
        this.engWord = engWord;
        this.rusWord = rusWord;
        this.streamWord = streamWord;
    }

    public Word() {

    }

    public String getRusWord() {
        return rusWord;
    }

    public void setRusWord(String rusWord) {
        this.rusWord = rusWord;
    }

    public String getStreamWord() {
        return streamWord;
    }

    public void setStreamWord(String stream) {
        this.streamWord = streamWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }
}
