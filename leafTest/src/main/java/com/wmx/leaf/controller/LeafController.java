package com.wmx.leaf.controller;



import com.wmx.leaf.service.LeafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeafController {

    @Autowired
    LeafService leafService;

    @GetMapping("/getId")
    public String say() {
        long id = leafService.genId();
        return id == -1 ? "" : String.valueOf(id);
    }
}
