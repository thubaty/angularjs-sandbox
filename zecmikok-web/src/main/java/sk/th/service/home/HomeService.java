package sk.th.service.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/wordservice")
@RestController
//@Api(value = "users", description = "Endpoint for user management")
public class HomeService {

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<WordList> getData() {
        List<WordList> wordList = new ArrayList<WordList>();
        wordList.add(new WordList(1l, "list1", 50l, 40l));
        wordList.add(new WordList(2l, "list2", 50l, 40l));
        return wordList;
    }


}
