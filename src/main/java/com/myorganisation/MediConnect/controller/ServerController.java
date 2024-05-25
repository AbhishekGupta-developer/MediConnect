package com.myorganisation.MediConnect.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ServerController {

    private final Date startDate = new Date();

    @Value("${spring.application.name}")
    String applicationName;

    @Operation(summary = "Get server details", description = "Gets server details like status whether it's live or NOT")
    @GetMapping
    public ResponseEntity<?> serverDetails() {

        Date currentDate = new Date();

        Map<String, String> server = new LinkedHashMap<>();

        server.put("serverName", applicationName);
        server.put("serverStatus", "live");
        server.put("serverStartDate", new SimpleDateFormat("dd-MM-yyyy").format(startDate).toString());
        server.put("serverStartTime", new SimpleDateFormat("HH:mm:ss").format(startDate).toString());
        server.put("serverCurrentDate", new SimpleDateFormat("dd-MM-yyyy").format(currentDate).toString());
        server.put("serverCurrentTime", new SimpleDateFormat("HH:mm:ss").format(currentDate).toString());
        server.put("serverDeveloper", "Made with Love by Abhishek");

        return new ResponseEntity<>(server, HttpStatusCode.valueOf(200));
    }

}

