package com.agutierrez.springBootSwagger.parserJson.services;

import org.springframework.stereotype.Service;

@Service
public interface JsonParserService {
    Object getValuebyJsonPath(String json, String path);
}
