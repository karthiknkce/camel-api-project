package com.camel.api.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiService {
    
    public void processApiData(Object data) {
        log.info("Processing API data in service layer");
    }
}