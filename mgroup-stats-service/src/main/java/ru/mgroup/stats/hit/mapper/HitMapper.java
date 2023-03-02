package ru.mgroup.stats.hit.mapper;

import ru.mgroup.stats.hit.model.Hit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class HitMapper {
    public static Hit toHit(HitDto hitDto) {
        Hit hit = Hit.builder()
                .app(hitDto.getApp())
                .ip(hitDto.getIp())
                .entity(hitDto.getEntity())
                .iid(hitDto.getIid())
                .prop(hitDto.getProp())
                .meta(hitDto.getMeta())
                .build();
        if (hitDto.getTimestamp() != null) {
            hit.setTimestamp(LocalDateTime.parse(hitDto.getTimestamp()));
        } else {
            hit.setTimestamp(LocalDateTime.now());
        }
        return hit;
    }

    public static HitDto toHitDto(Hit hit){
        return HitDto.builder()
                .app(hit.getApp())
                .ip(hit.getIp())
                .entity(hit.getEntity())
                .iid(hit.getIid())
                .prop(hit.getProp())
                .meta(hit.getMeta())
                .timestamp(hit.getTimestamp().toString())
                .build();
    }

    public static List<HitDto> listToHitDto(List<Hit> list) {
        return list.stream()
                .map(HitMapper::toHitDto)
                .collect(Collectors.toList());
    }
}
