package com.korit.library.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String bookSearch() {
        return "admin/book_search";
    }

    @GetMapping("/register")
    public String bookRegister() {
        return "admin/book_register";
    }

    @GetMapping("modification")
    public String bookModification() {
        return "admin/book_modification";
    }

}
