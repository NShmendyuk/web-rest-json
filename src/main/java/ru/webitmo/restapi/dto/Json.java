package ru.webitmo.restapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@ToString
public class Json {
    Map<String, Object> values;
}
