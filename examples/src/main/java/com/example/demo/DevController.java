package com.example.demo;

import com.example.demo.dto.RatingDto;
import com.example.demo.dto.ThumpsUpDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("api/test")
public class DevController {

    @GetMapping()
    public void spamMethod() {
        log.info("Started method");
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            Thread thread = new Thread(() -> {
                log.info("Thread started {}", finalI);
                final Random random = new Random();
                final int millis = random.nextInt(1000);
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Thread {} execution finished for {}", finalI, millis);
            });
            thread.start();
        }
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public void retrieveUsers() {}

    @PostMapping(consumes = "application/vnd.restdemo.thumpsup+json")
    public void thumpsUpRating(@RequestBody ThumpsUpDto thumpsUpDto) {
        log.info(String.valueOf(thumpsUpDto.isLike()));
    }

    @PostMapping(consumes = "application/vnd.restdemo.rating+json")
    public void starRating(@RequestBody RatingDto ratingDto) {
        log.info(ratingDto.toString());
    }
}
