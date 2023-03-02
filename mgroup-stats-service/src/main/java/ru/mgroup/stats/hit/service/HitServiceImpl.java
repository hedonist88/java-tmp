package ru.mgroup.stats.hit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mgroup.stats.hit.mapper.HitDto;
import ru.mgroup.stats.hit.mapper.HitMapper;
import ru.mgroup.stats.hit.model.Hit;
import ru.mgroup.stats.hit.repository.HitRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HitServiceImpl implements HitService {
    private HitRepository hitRepository;

    @Autowired
    public HitServiceImpl(HitRepository hitRepository) {
        this.hitRepository = hitRepository;
    }

    @Override
    public void create(List<HitDto> hitDtoList) {
        hitDtoList.forEach(hitDto -> {
            hitRepository.save(HitMapper.toHit(hitDto));
        });

    }

    @Override
    public List<HitDto> get(HitDto hitDto, String start, String end, int from, int size) {
        List<Hit> hits = hitRepository.getHitStatistics(hitDto, start, end, from, size);
        return HitMapper.listToHitDto(hits);
    }
}
