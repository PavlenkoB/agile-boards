package ua.com.mycompany.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@Controller
//@RequestMapping("/")
@Slf4j
public class RootController {
    @GetMapping
    public String getMainPage() {
        System.out.println("Looking in the index controller.........");
        return "index";
    }
}

