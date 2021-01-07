package ru.webitmo.restapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import ru.webitmo.restapi.service.JsonService;

@RestController
@RequestMapping("/json_entity")
@Slf4j
@RequiredArgsConstructor
public class JsonRestController {
    private final JsonService jsonService;

    //    запрос с методом GET возвращает объект. Если объект не был создан, вернуть null
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject getJson() {
        log.info("got GET request");
        return jsonService.get();
    }

    //    запрос с методом POST сохраняет объект (например, в переменную).
    //    Если объект уже был сохранен, вернуть ошибку 400 Bad request.
    // {"name": "me","value": "123"}
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createJson(@RequestBody JSONObject json) {
        log.info("got POST request");
        if (jsonService.create(json)) {
            return new ResponseEntity<>("object created.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("object exist already", HttpStatus.BAD_REQUEST);
        }
    }

    //    запрос с методом PUT перезаписывает объект, который ранее был сохранен методом POST.
    //    Если объект не был создан, вернуть ошибку 400 Bad request.
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> replaceJson(@RequestBody JSONObject json) {
        log.info("got PUT request");
        if (jsonService.replace(json)) {
            return new ResponseEntity<>("object replaced.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("object doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

    //    запрос с методом PATCH изменяет ранее сохраненный объект,
    //    перезаписывая поля или добавляя новые из объекта переданного в теле запроса.
    //    Если объект не был создан, вернуть ошибку 400 Bad request.
    @ResponseStatus(value = HttpStatus.OK)
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateJson(@RequestBody JSONObject json) {
        log.info("got PATCH request");
        if (jsonService.update(json)) {
            return new ResponseEntity<>("object updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("object doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }
}