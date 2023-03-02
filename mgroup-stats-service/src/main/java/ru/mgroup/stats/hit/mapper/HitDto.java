package ru.mgroup.stats.hit.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HitDto {
    private String app;
    private String entity;
    private String iid;
    private String prop;
    private String meta;
    private String ip;
    private String timestamp;
}
