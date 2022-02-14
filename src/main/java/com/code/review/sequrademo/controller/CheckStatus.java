package com.code.review.sequrademo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CheckStatus {

    @GetMapping("/status")
    String status() {
        return "alive!";
    }

}