package ru.mgroup.stats.hit.repository;

import ru.mgroup.stats.hit.mapper.HitDto;
import ru.mgroup.stats.hit.model.Hit;

import java.util.List;

public interface HitRepositoryCustom {
    List<Hit> getHitStatistics(HitDto hitDto, String start, String end, int from, int size);
}
