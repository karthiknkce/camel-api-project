package com.camel.api.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Component("apiResponseProcessor")
@Slf4j
public class ApiResponseProcessor implements Processor {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public void process(Exchange exchange) throws Exception {
        try {
            String responseBody = exchange.getIn().getBody(String.class);
            log.info("Processing API response of {} bytes", responseBody.length());
            
            if (responseBody != null && responseBody.startsWith("[")) {
                Object jsonResponse = objectMapper.readValue(responseBody, Object.class);
                log.info("Successfully parsed JSON response");
                exchange.getIn().setBody(jsonResponse);
            }
            
        } catch (Exception e) {
            log.error("Error processing API response: {}", e.getMessage());
            exchange.setProperty("processingError", e.getMessage());
        }
    }
}