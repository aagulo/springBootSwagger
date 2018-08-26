package com.agutierrez.springBootSwagger.parserJson.services;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;

@Service("JsonParserService")
public class JsonParserServiceImpl implements JsonParserService {

    @Override
    public Object getValuebyJsonPath(String json, String path) {
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        Object value = JsonPath.read(document, path);
        return value;
    };
}
