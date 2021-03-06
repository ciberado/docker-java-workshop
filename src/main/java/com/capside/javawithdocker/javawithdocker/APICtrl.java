package com.capside.javawithdocker.javawithdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javi
 */
@RestController
public class APICtrl {
    
    @GetMapping(path = "/messages", params = "type=greetings")
    public Message greetings(@RequestParam(defaultValue = "dear") String name) {
        return new Message(String.format("Greetings %s.", name));
    }
    
    @GetMapping(path = "/messages", params = "type=oops")
    public void shutdownByABug() {
        System.exit(0);
    }
}
