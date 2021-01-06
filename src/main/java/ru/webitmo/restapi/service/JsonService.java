package ru.webitmo.restapi.service;

import org.json.simple.JSONObject;

public interface JsonService {
    JSONObject get();
    Boolean create(JSONObject json);
    Boolean replace(JSONObject json);
    Boolean update(JSONObject json);
}
