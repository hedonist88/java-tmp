package ru.mgroup.stats.hit.mapper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StatHitsResponseDto {
    private String app;
    private String uri;
    private long hits;
}
