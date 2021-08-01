package in28minutes.testing.business;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("hello-world")
    public String hello(){
        return "hello-world";
    }
}
