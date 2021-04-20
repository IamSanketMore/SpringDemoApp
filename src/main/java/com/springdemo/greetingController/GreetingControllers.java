package com.springdemo.greetingController;

import com.springdemo.greetingModel.Greeting;
import com.springdemo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingControllers
{
    private static final String template ="Hello , %s!";
    private final AtomicLong counter = new AtomicLong();

    // curl localhost:8080/greeting
    @GetMapping("/greeting")
    public Greeting getGreeting() {
        return new Greeting(counter.incrementAndGet(), String.format(template, " "));
    }
    //curl -X GET "http://localhost:8080/param/greeting"
    //curl -X GET "http://localhost:8080/param/greeting?name=Sanket"
    @GetMapping("/param/greeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));

    }
    //>curl  -X POST -H "Content-Type:application/json" -d "{\"content\": \"Sanket, More\" }" http://localhost:8080/greeting/post
    @PostMapping("/greeting/post")
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getContent()));
    }

    //curl -X PUT "http://localhost:8080/put/greeting/?name=bhushan"
    @PutMapping("/greeting/put")
    public Greeting putGreeting(@RequestParam(value = "name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
