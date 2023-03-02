package ru.mgroup.stats.hit.repository;

import ru.mgroup.stats.hit.mapper.HitDto;
import ru.mgroup.stats.hit.model.Hit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HitRepositoryCustomImpl implements HitRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Hit> getHitStatistics(HitDto hitDto, String start, String end, int from, int size) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Hit> criteriaQuery = criteriaBuilder.createQuery(Hit.class);
        Root<Hit> root = criteriaQuery.from(Hit.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.get("app"), hitDto.getApp()));
        predicates.add(criteriaBuilder.equal(root.get("entity"), hitDto.getEntity()));
        predicates.add(criteriaBuilder.equal(root.get("iid"), hitDto.getIid()));
        predicates.add(criteriaBuilder.equal(root.get("prop"), hitDto.getProp()));

        if (start != null && !start.isBlank()) {
            predicates.add(criteriaBuilder.greaterThan(root.get("timestamp").as(LocalDateTime.class),
                    LocalDateTime.parse(start)));
        }
        if (end != null && !start.isBlank()) {
            predicates.add(criteriaBuilder.lessThan(root.get("timestamp").as(LocalDateTime.class),
                    LocalDateTime.parse(end)));
        }

        Predicate finalPredicate
                = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

        criteriaQuery.where(finalPredicate);

        return em.createQuery(criteriaQuery).setMaxResults(size).setFirstResult(from / size).getResultList();
    }
}
