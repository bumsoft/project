package com.erica.project.home;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    /**
     * 구글맵 테스트
     */
    @GetMapping("/maps")
    public String maps(Model model)
    {

        Store loc1 = new Store("cu 1호점","시급 근무시간 등등", 37.299,126.837);
        Store loc2 = new Store("cu 2호점","시급 근무시간 등등", 37.300,126.839);

        List<Store> store_list = new ArrayList<>(Arrays.asList(loc1,loc2));
        model.addAttribute("store_list", store_list);
        return "maps";
    }

    @Getter
    static class Store {

        String name;
        double lat;
        double lng;
        String temp;

        public Store(String name, String temp, double lat, double lng)
        {
            this.name = name;
            this.lat = lat;
            this.lng = lng;
            this.temp = temp;
        }
    }
}
