package com.eric.moviego.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/{id}")
    public String get(@PathVariable Long id) throws InterruptedException {
        return "Get -> " + id;
    }
}
