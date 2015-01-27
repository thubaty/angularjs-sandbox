import org.springframework.util.StringUtils;
import org.springframework.util.comparator.CompoundComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tohy on 25.01.2015.
 */
public class SRTest {

    static Comparator<Word> tika = new CompoundComparator<Word>(new WordComparator1(), new WordComparator2(), new WordComparator3(), new WordComparator4());

    static List<Word> wordDb;

    static {
        wordDb = new ArrayList<Word>();
        wordDb.add(new Word("ahoj"));
        wordDb.add(new Word("pa"));
        wordDb.add(new Word("caj"));
        wordDb.add(new Word("vodpal"));
      /*  wordDb.add(new Word("serus"));
        wordDb.add(new Word("maj sa"));
        wordDb.add(new Word("sevas"));
        wordDb.add(new Word("soj"));*/
    }

    static void sort() {
        Collections.sort(wordDb, tika);
    }

    static void print() {
        String result = StringUtils.collectionToDelimitedString(wordDb, ",");
        System.out.println(result);
    }

    static void know() throws InterruptedException {
        wordDb.get(0).know();
        sortPrintWait();
    }

    static void donno() throws InterruptedException {
        wordDb.get(0).donno();
        sortPrintWait();
    }

    static void sortPrintWait() throws InterruptedException {
        sort();
        print();
        Thread.sleep(10);
    }

    public static void main(String[] args) throws InterruptedException {
        sortPrintWait();
        know();
        know();
        donno();
        donno();
        donno();
        know();
        donno();
        donno();
        know();
        know();
        donno();
        know();
        know();
        know();
        know();
        know();
        donno();
        donno();
        donno();
        donno();
        donno();
        donno();
        donno();
        donno();

    }

    static class WordComparator1 implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            return o1.getKnow1().compareTo(o2.getKnow1());
        }
    }

    static class WordComparator2 implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            return o1.getKnow2().compareTo(o2.getKnow2());
        }
    }

    static class WordComparator3 implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            return o1.getKnow3().compareTo(o2.getKnow3());
        }
    }

    static class WordComparator4 implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            return o1.getCurrentTime().compareTo(o2.getCurrentTime());
        }
    }


    static class Word {

        private String word;

        private Boolean know1;
        private Boolean know2;
        private Boolean know3;

        private Long currentTime;

        public Word(String word) {
            this.word = word;
            know1 = false;
            know2 = false;
            know3 = false;
            currentTime = System.currentTimeMillis();
        }

        public Long getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(Long currentTime) {
            this.currentTime = currentTime;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
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

        @Override
        public String toString() {
            String s1 = getKnow1() ? "Y" : "N";
            String s2 = getKnow2() ? "Y" : "N";
            String s3 = getKnow3() ? "Y" : "N";
            return word + "(" + s1 + s2 + s3 + ")";
        }

        public void know() {
            setKnow3(getKnow2());
            setKnow2(getKnow1());
            setKnow1(true);
            currentTime = System.currentTimeMillis();
        }

        public void donno() {
            setKnow3(getKnow2());
            setKnow2(getKnow1());
            setKnow1(false);
            currentTime = System.currentTimeMillis();
        }
    }
}
