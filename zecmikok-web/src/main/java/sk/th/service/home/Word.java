package sk.th.service.home;

import java.io.Serializable;

/**
 * Created by tohy on 24.01.2015.
 */
public class Word implements Serializable {

    private String slovak;

    private String translated;

    private Long diff;

    private Long state;

    private boolean done;

    public Word() {
    }

    public Word(String slovak, String translated, Long diff, Long state, boolean done) {
        this.slovak = slovak;
        this.translated = translated;
        this.diff = diff;
        this.state = state;
        this.done = done;
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
}
