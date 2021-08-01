package in28minutes.testing.business;

import in28minutes.testing.model.Item;
import in28minutes.testing.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item helloWorl(){
        return new Item(1,"ball",10,100);
    }

    @GetMapping("/dummy-item-service")
    public Item helloWorldServiceFromService(){
        return itemBusinessService.retrieve();
    }
}
