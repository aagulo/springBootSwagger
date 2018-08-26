package com.agutierrez.springBootSwagger.parserJson.controller;

import com.agutierrez.springBootSwagger.parserJson.services.JsonParserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parser")
public class ParserJsonController {

    @Autowired
    @Qualifier("JsonParserService")
    private JsonParserService jsonParserService;

    @RequestMapping(value = "/valuePath", method = RequestMethod.POST)
    public ResponseEntity<String> getValueByPath(@RequestBody String json, @RequestParam(name = "path", required = true) String jsonPath) {
        Gson gson = new Gson();
        try {
            Object value = jsonParserService.getValuebyJsonPath(json, jsonPath);
            return new ResponseEntity<>(gson.toJson(value), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
