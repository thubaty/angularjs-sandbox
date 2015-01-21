package sk.th.service.home;

import java.io.Serializable;

public class WordList implements Serializable {

    private Long id;
    private String name;
    private Long wordCount;
    private Long state;

    public WordList(Long id, String name, Long wordCount, Long state) {
        this.id = id;
        this.name = name;
        this.wordCount = wordCount;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }
}
