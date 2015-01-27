package sk.th.zecmikok.service;

import java.io.Serializable;
import java.util.Comparator;

public class WordDto implements Serializable {

    public static Comparator<WordDto> SRCOMPARATOR = new WordDtoComparator();

    private Long id;

    private String slovak;

    private String translated;

    private Long diff;

    private Long state;

    private boolean done;

    private Boolean know1;
    private Boolean know2;
    private Boolean know3;

    private Long currentTime;

    public WordDto() {
    }

    public WordDto(Long id, String slovak, String translated, Long diff, Long state, boolean done) {
        this.id = id;
        this.slovak = slovak;
        this.translated = translated;
        this.diff = diff;
        this.state = state;
        this.done = done;
        this.know1 = false;
        this.know2 = false;
        this.know3 = false;
        this.currentTime = System.currentTimeMillis();
    }

    public String getSlovak() {
        return slovak;
    }

    public void setSlovak(String slovak) {
        this.slovak = slovak;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public Long getDiff() {
        return diff;
    }

    public void setDiff(Long diff) {
        this.diff = diff;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getKnow1() {
        return know1;
    }

    public void setKnow1(Boolean know1) {
        this.know1 = know1;
    }

    public Boolean getKnow2() {
        return know2;
    }

    public void setKnow2(Boolean know2) {
        this.know2 = know2;
    }

    public Boolean getKnow3() {
        return know3;
    }

    public void setKnow3(Boolean know3) {
        this.know3 = know3;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }
}
