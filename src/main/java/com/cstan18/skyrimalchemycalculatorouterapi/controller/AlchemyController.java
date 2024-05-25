package com.cstan18.skyrimalchemycalculatorouterapi.controller;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@NoArgsConstructor
public class AlchemyController {

    private static final Logger logger = LoggerFactory.getLogger(AlchemyController.class);

    @GetMapping(value = "/test")
    public String swaggerUiTestEndpoint() {
        logger.info("/test endpoint called");
        return "Success";
    }

}
