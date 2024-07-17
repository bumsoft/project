package com.erica.community.controller.규식;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GSController {

    @GetMapping("/link2")
    public String link1()
    {
        return "규식/temp";
    }

}
