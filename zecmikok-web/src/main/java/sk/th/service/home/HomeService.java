package sk.th.service.home;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/wordservice")
@RestController
public class HomeService {

    Map<Long, WordList> listDb = new HashMap<Long, WordList>();
    Map<Long, List<Word>> wordDb = new HashMap<Long, List<Word>>();


    {
        listDb.put(1l, new WordList(1l, "list1", 50l, 40l));
        listDb.put(2l, new WordList(2l, "list2", 50l, 40l));

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
    public List<WordList> getData() {
        Set<Long> ids = listDb.keySet();
        List<WordList> list = new ArrayList<WordList>();
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
    public WordList getSingleData(@PathVariable("listId") Long listId) {
        return listDb.get(listId);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.PUT)
    public
    @ResponseBody
    WordList updateWord(@RequestBody WordList list, @PathVariable("wordId") Long wordId) {
        listDb.put(wordId, list);
        return list;
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.POST)
    public
    @ResponseBody
    WordList postWord(@RequestBody WordList list, @PathVariable("wordId") Long wordId) {
        listDb.put(wordId, list);
        return list;
    }
}
