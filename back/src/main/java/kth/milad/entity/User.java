package kth.milad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId; // Unique identifier shared across all users

    // Relationships with other entities
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private Doctor doctor;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private Others others;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private Patient patient;



}
