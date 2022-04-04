package com.hblack.amazonyandex.controller;

import com.hblack.amazonyandex.repository.LocalRepository;
import com.hblack.amazonyandex.service.AmazonService;
import com.hblack.amazonyandex.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagesController {

    //@Autowired
    //LocalRepository localRepository;

    @Autowired
    AmazonService amazonService;

    @Autowired
    LocalService localService;

    @GetMapping("/hello")
    public ResponseEntity hello() {
        System.out.println("request done");
        return ResponseEntity.ok("Hello");
    }

    //работает
    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok(localService.showAll());
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestParam String imagename) {
        localService.saveImage(imagename);
        return ResponseEntity.ok("saved");
    }

    /*@PostMapping("/delete")
    public ResponseEntity delete(@RequestParam String imagename) {
        localService.deleteImage(imagename);
        return ResponseEntity.ok("deleted");
    }*/



}
