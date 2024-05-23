package com.cstan18.skyrimalchemycalculatorouterapi.controller;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@NoArgsConstructor
public class AlchemyController {

    @GetMapping(value = "/test")
    public String swaggerUiTestEndpoint() {
        return "Success";
    }

}
