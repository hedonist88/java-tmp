package ru.mgroup.stats.hit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mgroup.stats.hit.mapper.HitDto;
import ru.mgroup.stats.hit.service.HitService;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class HitController {
    @Autowired
    private HitService hitService;

    @PostMapping("/hit")
    public void create(@RequestBody List<HitDto> hitDtoList){
        hitService.create(hitDtoList);
    }

    @GetMapping("/hit")
    public ResponseEntity<List<HitDto>> get(
        @RequestParam(value = "start", required = false) String start,
        @RequestParam(value = "end", required = false) String end,
        @PositiveOrZero @RequestParam(value = "from", defaultValue = "0") int from,
        @Positive @RequestParam(value = "size", defaultValue = "100") int size,
        @RequestParam(value = "app", required = true) String app,
        @RequestParam(value = "entity", required = true) String entity,
        @RequestParam(value = "iid", required = true) String iid,
        @RequestParam(value = "prop", required = true) String prop
    ) {
        return ResponseEntity.ok(hitService.get(
                HitDto.builder()
                .app(app)
                .entity(entity)
                .iid(iid)
                .prop(prop)
                .build(),
                start,
                end,
                from,
                size));
    }
}
