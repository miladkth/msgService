package kth.milad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
//@Table(name = "encounter")
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private LocalDateTime timeStamp;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Observation> observations;
}
