package in28minutes.testing.service;

import in28minutes.testing.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {


    public Item retrieve(){
        return new Item(1,"ball",10,100);
    }
}
