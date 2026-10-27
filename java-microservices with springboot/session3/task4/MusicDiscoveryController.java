package com.example.recommendationservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicDiscoveryController {

    private static final Logger logger = LoggerFactory.getLogger(MusicDiscoveryController.class);

    private final DiscoveryClient discoveryClient;

    public MusicDiscoveryController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/discover-music")
    public String discoverMusicService() {

//fetch all instances of ms
        List<ServiceInstance> instances =discoveryClient.getInstances("MusicService");

        if (instances.isEmpty()) {
            logger.warn("not instances found in eureka");

            return "Not instances found in Eureka.";
        }

//display the number of instances
        logger.info("MusicService instances found: {}", instances.size());

//print the host and port of instance
        for (ServiceInstance instance : instances) {

            String host = instance.getHost();
            int port = instance.getPort();

            logger.info("msicService host: {}", host);
            logger.info("musicService port: {}", port);
        }

        return "musicservice instances discovered";
    }
}