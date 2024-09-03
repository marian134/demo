package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@Slf4j
public class MyController {


    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/info")
    public ResponseEntity<?> logInfo(){
        log.info("Esto es un Log tipo Info");
        return ResponseEntity.ok("Esto es un log tipo info.");
    }
    @GetMapping("/error")
    public ResponseEntity<?> logError(){
        log.error("Esto es un Log tipo Info");
        return ResponseEntity.ok("Esto es un log tipo info.");
    }

    @GetMapping("/debug")
    public ResponseEntity<?> logDebug(){
        log.debug("Esto es un Log tipo debug");
        return ResponseEntity.ok("Esto es un log tipo debug.");
    }
}
