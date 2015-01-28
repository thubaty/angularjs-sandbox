package sk.th.zecmikok.service.internal;

import org.springframework.stereotype.Service;
import sk.th.zecmikok.service.HomeService;
import sk.th.zecmikok.service.LearnUnitDto;
import sk.th.zecmikok.service.WordDto;
import sk.th.zecmikok.service.WordDtoComparator;

import java.util.*;

@Service
public class HomeServiceImpl implements HomeService {

    Map<Long, LearnUnitDto> listDb = new HashMap<Long, LearnUnitDto>();
    Map<Long, List<WordDto>> wordDb = new HashMap<Long, List<WordDto>>();


    {
        listDb.put(1l, new LearnUnitDto(1l, "list1", "wordset", 40l));
        listDb.put(2l, new LearnUnitDto(2l, "list2", "wordset", 40l));
        listDb.put(3l, new LearnUnitDto(3l, "pastperfect", "grammar", 40l));
        listDb.put(4l, new LearnUnitDto(4l, "atWork1", "homework", 40l));
        listDb.put(5l, new LearnUnitDto(4l, "atWork1", "homework", 40l));

        {
            List<WordDto> words = new ArrayList<WordDto>();
            words.add(new WordDto(1l, "slovo1", "word1", 10l, 10l, false));
            words.add(new WordDto(2l, "slovo2", "word2", 10l, 10l, false));
            words.add(new WordDto(3l, "slovo3", "word3", 10l, 10l, false));
            words.add(new WordDto(4l, "slovo4", "word4", 10l, 10l, false));
            words.add(new WordDto(5l, "slovo5", "word4", 10l, 10l, false));
            words.add(new WordDto(6l, "slovo6", "word4", 10l, 10l, false));
            words.add(new WordDto(7l, "slovo7", "word4", 10l, 10l, false));
            words.add(new WordDto(8l, "slovo8", "word4", 10l, 10l, false));
            words.add(new WordDto(9l, "slovo9", "word4", 10l, 10l, false));
            words.add(new WordDto(10l, "slovo10", "word4", 10l, 10l, false));
            wordDb.put(1l, words);
        }

        {
            List<WordDto> words = new ArrayList<WordDto>();
            words.add(new WordDto(11l, "slovo51", "word1", 10l, 10l, false));
            words.add(new WordDto(12l, "slovo62", "word2", 10l, 10l, false));
            words.add(new WordDto(13l, "slovo73", "word3", 10l, 10l, false));
            words.add(new WordDto(14l, "slovo84", "word4", 10l, 10l, false));
            wordDb.put(2l, words);
        }
    }

    @Override
    public List<LearnUnitDto> getAllLearnUnits() {
        Set<Long> ids = listDb.keySet();
        List<LearnUnitDto> list = new ArrayList<LearnUnitDto>();
        for (Long id : ids) {
            list.add(listDb.get(id));
        }
        return list;
    }

    @Override
    public LearnUnitDto getLearnUnit(Long unitId) {
        return listDb.get(unitId);
    }

    @Override
    public List<WordDto> getWordsForLearnUnit(Long unitId) {
        List<WordDto> wordDtos = wordDb.get(unitId);
        Collections.sort(wordDtos, new WordDtoComparator());
        return wordDtos;
    }

    @Override
    public WordDto updateWord(WordDto wordDto) {
        Long idToFind = wordDto.getId();
        Set<Long> keySet = this.wordDb.keySet();
        for (Long aLong : keySet) {
            List<WordDto> wordDtos = wordDb.get(aLong);
            for (WordDto currentDto : wordDtos) {
                if (currentDto.getId().equals(idToFind)) {
                    currentDto.setDone(wordDto.isDone());
                    currentDto.setState(wordDto.getState());
                    currentDto.setKnow1(wordDto.getKnow1());
                    currentDto.setKnow2(wordDto.getKnow2());
                    currentDto.setKnow3(wordDto.getKnow3());
                    currentDto.setCurrentTime(System.currentTimeMillis());
                    return wordDto;
                }
            }
        }
        return null;
    }
}
