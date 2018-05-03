package ua.com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Creator: Pavlenko Bohdan
 * Date: 27.04.2018
 * Project: agile-boards
 */
@Controller
@RequestMapping("/")
public class RootController {
    @GetMapping
    @ResponseBody
    public String getMainPage() {
        return "<a href='/swagger-ui.html'>Swagger UI</a>";
    }
}
