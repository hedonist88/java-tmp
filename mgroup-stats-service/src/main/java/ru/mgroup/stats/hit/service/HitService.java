package ru.mgroup.stats.hit.service;

import ru.mgroup.stats.hit.mapper.HitDto;

import java.util.List;

public interface HitService {
    void create(List<HitDto> hitDtoList);
    List<HitDto> get(HitDto hitDto, String start, String end, int from, int size);
}
