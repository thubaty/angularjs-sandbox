package sk.th.service.home;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/wordservice")
@RestController
public class HomeService {

    Map<Long, LearnUnit> listDb = new HashMap<Long, LearnUnit>();
    Map<Long, List<Word>> wordDb = new HashMap<Long, List<Word>>();


    {
        listDb.put(1l, new LearnUnit(1l, "list1", "wordset", 40l));
        listDb.put(2l, new LearnUnit(2l, "list2", "wordset", 40l));
        listDb.put(3l, new LearnUnit(3l, "pastperfect", "grammar", 40l));
        listDb.put(4l, new LearnUnit(4l, "atWork1", "homework", 40l));

        {
            List<Word> words = new ArrayList<Word>();
            words.add(new Word("slovo1", "word1", 10l, 10l, false));
            words.add(new Word("slovo2", "word2", 10l, 10l, false));
            words.add(new Word("slovo3", "word3", 10l, 10l, false));
            words.add(new Word("slovo4", "word4", 10l, 10l, false));
            wordDb.put(1l, words);
        }

        {
            List<Word> words = new ArrayList<Word>();
            words.add(new Word("slovo51", "word1", 10l, 10l, false));
            words.add(new Word("slovo62", "word2", 10l, 10l, false));
            words.add(new Word("slovo73", "word3", 10l, 10l, false));
            words.add(new Word("slovo84", "word4", 10l, 10l, false));
            wordDb.put(2l, words);
        }
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<LearnUnit> getData() {
        Set<Long> ids = listDb.keySet();
        List<LearnUnit> list = new ArrayList<LearnUnit>();
        for (Long id : ids) {
            list.add(listDb.get(id));
        }
        return list;
    }

    @RequestMapping(value = "/getwords/{listId}", method = RequestMethod.GET)
    public List<Word> getWords(@PathVariable("listId") Long listId) {
        return wordDb.get(listId);
    }


    @RequestMapping(value = "/{listId}", method = RequestMethod.GET)
    public LearnUnit getSingleData(@PathVariable("listId") Long listId) {
        return listDb.get(listId);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.PUT)
    public
    @ResponseBody
    LearnUnit updateWord(@RequestBody LearnUnit list, @PathVariable("wordId") Long wordId) {
        listDb.put(wordId, list);
        return list;
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.POST)
    public
    @ResponseBody
    LearnUnit postWord(@RequestBody LearnUnit list, @PathVariable("wordId") Long wordId) {
        listDb.put(wordId, list);
        return list;
    }
}
