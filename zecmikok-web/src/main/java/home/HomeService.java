package home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tohy on 18.01.2015.
 */
@RequestMapping("/cont")
@RestController
public class HomeService {


    @RequestMapping(method = RequestMethod.GET)
    public Data getData() {
        Data data = new Data();
        data.setName("name");
        data.setSurname("surname");
        return data;
    }
}
