package kth.milad.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
//@Table(name = "observation")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String msg;
    private LocalDateTime timeStamp;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> conditions;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "encounter")
    private Encounter encounter;
}
