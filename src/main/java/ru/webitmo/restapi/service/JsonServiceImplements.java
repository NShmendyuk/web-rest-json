package ru.webitmo.restapi.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import ru.webitmo.restapi.dto.Json;
import ru.webitmo.restapi.repository.JsonRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class JsonServiceImplements implements JsonService {
    private final JsonRepository jsonRepository;

    public JsonServiceImplements(JsonRepository jsonRepository) {
        this.jsonRepository = jsonRepository;
    }

    public JSONObject get() {
        return new JSONObject(jsonRepository.getJson().getValues());
    }

    public Boolean create(JSONObject json) {
        if (jsonRepository.getJson() != null) return false;
        Json jsonExist = new Json();
        jsonExist.setValues(createMap(json));
        jsonRepository.setJson(jsonExist);
        return true;
    }

    public Boolean replace(JSONObject json) {
        Json jsonExist = jsonRepository.getJson();
        if (jsonExist == null) return false;
        jsonExist.setValues(createMap(json));
        jsonRepository.setJson(jsonExist);
        return true;
    }

    public Boolean update(JSONObject json) {
        Json jsonExist = jsonRepository.getJson();
        if (jsonExist == null) return false;
        jsonExist.setValues(joinMap(json, jsonRepository.getJson()));
        jsonRepository.setJson(jsonExist);
        return true;
    }
    
    public Map<String, Object> createMap(JSONObject data) {
        Map<String, Object> map = new HashMap();
        Set keySet = data.keySet();
        keySet.forEach(keyStr -> map.put((String) keyStr, data.get(keyStr)));
        return map;
    }

    public Map<String, Object> joinMap(JSONObject jsonNewData, Json jsonToUpdate) {
        Map<String, Object> mapJoined = jsonToUpdate.getValues();
        Set keySetExist = mapJoined.keySet();
        Set keySetNew = jsonNewData.keySet();
        keySetNew.forEach(keyStr -> {
            if (!keySetExist.contains(keyStr)) {
                mapJoined.put((String) keyStr, jsonNewData.get(keyStr));
            }
        });
        return mapJoined;
    }
}