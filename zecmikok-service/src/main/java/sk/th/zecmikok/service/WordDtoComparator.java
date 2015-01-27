package sk.th.zecmikok.service;

import org.springframework.util.comparator.CompoundComparator;

import java.util.Comparator;

public class WordDtoComparator extends CompoundComparator<WordDto> {

    public WordDtoComparator() {
        super(new WordComparator1(), new WordComparator2(), new WordComparator3(), new WordComparator4());
    }

    static class WordComparator1 implements Comparator<WordDto> {

        @Override
        public int compare(WordDto o1, WordDto o2) {
            return o1.getKnow1().compareTo(o2.getKnow1());
        }
    }

    static class WordComparator2 implements Comparator<WordDto> {

        @Override
        public int compare(WordDto o1, WordDto o2) {
            return o1.getKnow2().compareTo(o2.getKnow2());
        }
    }

    static class WordComparator3 implements Comparator<WordDto> {

        @Override
        public int compare(WordDto o1, WordDto o2) {
            return o1.getKnow3().compareTo(o2.getKnow3());
        }
    }

    static class WordComparator4 implements Comparator<WordDto> {

        @Override
        public int compare(WordDto o1, WordDto o2) {
            return o1.getCurrentTime().compareTo(o2.getCurrentTime());
        }
    }
}
