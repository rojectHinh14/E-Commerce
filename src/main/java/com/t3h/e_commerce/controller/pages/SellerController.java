package com.t3h.e_commerce.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SellerController {
    @GetMapping("/seller")
    public String seller(){
        return "guest/seller";
    }
}
