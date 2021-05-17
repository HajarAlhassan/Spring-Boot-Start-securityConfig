package com.tts.Spring.Boot.Start.controller;

import com.tts.Spring.Boot.Start.model.Book;
import com.tts.Spring.Boot.Start.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SimpleController {
    // this value from the variables defineds in the application properties file
    @Value("${spring.application.name}")
    String appName;
    @Value("${name}")
    String name;
 @Autowired
    BookRepository repository;

    //below we are using an object for type Model
    // this describes a UI element that will apper in html
    // typically, these are used for template engine soulution

    public CommandLineRunner demo() {
        return (args) -> {

            repository.save(new Book("Red Queen","Mary Deelan"));
            repository.save(new Book("The Lord of the rings","Hajar"));
            repository.save(new Book("Shapes and colors","Ayaa Skef"));
        };
    }
    @GetMapping("/")
    public String homePage(Model model) {

        model.addAttribute("appName", name);
        model.addAttribute("books",repository.findAll());
        return "home";
    }
}
