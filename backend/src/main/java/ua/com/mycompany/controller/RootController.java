package ua.com.mycompany.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@RestController
@RequestMapping("/")
@Slf4j
public class RootController {
    @GetMapping
    public String getMainPage() {
        System.out.println("Looking in the index controller.........");
        return "index";
    }
}

