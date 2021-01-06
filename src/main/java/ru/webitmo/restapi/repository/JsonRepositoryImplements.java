package ru.webitmo.restapi.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.webitmo.restapi.dto.Json;

@Repository
@RequiredArgsConstructor
public class JsonRepositoryImplements implements JsonRepository {
    private Json json;

    public Json getJson() {
        return json;
    }

    public Json setJson(Json json) {
        this.json = json;
        return json;
    }
}
