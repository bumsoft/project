package com.erica.community.controller.도희;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DHController {

    @GetMapping("/link3")
    public String link1()
    {
        return "도희/temp";
    }

}
