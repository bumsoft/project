package com.erica.community.controller.정현;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JHController {

    @GetMapping("/link4")
    public String link1()
    {
        return "정현/temp";
    }

}
