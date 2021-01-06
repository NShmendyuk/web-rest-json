package ru.webitmo.restapi.repository;

import ru.webitmo.restapi.dto.Json;

public interface JsonRepository {
    Json getJson();
    Json setJson(Json json);
}
