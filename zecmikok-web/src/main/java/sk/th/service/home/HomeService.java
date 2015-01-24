package sk.th.service.home;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/wordservice")
@RestController
public class HomeService {

    Map<Long, WordList> wordDb = new HashMap<Long, WordList>();

    {
        wordDb.put(1l, new WordList(1l, "list1", 50l, 40l));
        wordDb.put(2l, new WordList(2l, "list2", 50l, 40l));
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<WordList> getData() {
        Set<Long> ids = wordDb.keySet();
        List<WordList> list = new ArrayList<WordList>();
        for (Long id : ids) {
            list.add(wordDb.get(id));
        }
        return list;
    }

    @RequestMapping(value = "/{listId}", method = RequestMethod.GET)
    public WordList getSingleData(@PathVariable("listId") Long listId) {
        return wordDb.get(listId);
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.PUT)
    public
    @ResponseBody
    WordList updateWord(@RequestBody WordList list, @PathVariable("wordId") Long wordId) {
        wordDb.put(wordId, list);
        return list;
    }

    @RequestMapping(value = "/{wordId}", method = RequestMethod.POST)
    public
    @ResponseBody
    WordList postWord(@RequestBody WordList list, @PathVariable("wordId") Long wordId) {
        wordDb.put(wordId, list);
        return list;
    }
}
