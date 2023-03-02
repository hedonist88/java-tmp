package ru.mgroup.stats.hit.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_stat")
@Builder
@Getter
@Setter
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class Hit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(nullable = false, length = 100)
    private String app;
    @NotNull
    @Column(nullable = false, length = 1000)
    private String entity;
    @NotNull
    @Column(nullable = false, length = 100)
    private String iid;
    @Column(nullable = false, length = 1000)
    private String prop;
    @NotNull
    @Column(nullable = false, length = 1000)
    private String meta;
    @Column(nullable = false, length = 15)
    private String ip;
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
