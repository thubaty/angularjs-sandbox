package sk.th.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.th.zecmikok.service.HomeService;
import sk.th.zecmikok.service.LearnUnitDto;
import sk.th.zecmikok.service.WordDto;

import java.util.List;

@RequestMapping("/wordservice")
@RestController
public class HomeRestController {


    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<LearnUnitDto> getAllLearnUnits() {
        return homeService.getAllLearnUnits();
    }

    @RequestMapping(value = "/getwords/{listId}", method = RequestMethod.GET)
    public List<WordDto> getWordsForLearnUnit(@PathVariable("listId") Long unitId) {
        return homeService.getWordsForLearnUnit(unitId);
    }

    @RequestMapping(value = "/{listId}", method = RequestMethod.GET)
    public LearnUnitDto getLearnUnit(@PathVariable("listId") Long unitId) {
        return homeService.getLearnUnit(unitId);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.PUT)
    public
    @ResponseBody
    WordDto updateWord(@RequestBody WordDto word, @PathVariable("wordId") Long wordId) {
        return homeService.updateWord(wordId, word);
    }

}
