package sk.th.zecmikok.service;

import java.util.List;

public interface HomeService {

    List<LearnUnitDto> getAllLearnUnits();

    LearnUnitDto getLearnUnit(Long unitId);

    List<WordDto> getWordsForLearnUnit(Long unitId);

    WordDto updateWord(Long wordId, WordDto wordDto);


}
