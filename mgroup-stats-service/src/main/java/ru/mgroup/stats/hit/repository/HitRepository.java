package ru.mgroup.stats.hit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mgroup.stats.hit.model.Hit;

public interface HitRepository extends JpaRepository<Hit, Long>, HitRepositoryCustom {
}
