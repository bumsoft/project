package com.erica.project.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/accessDenied")
    public String accessDenied()
    {
        return "Common/accessDenied";
    }
}
