package com.erica.community.controller.진범;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JBController {

    @GetMapping("/link1")
    public String link1()
    {
        return "진범/temp";
    }

}
