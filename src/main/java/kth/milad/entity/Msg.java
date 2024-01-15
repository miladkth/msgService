package kth.milad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
//@Table(name = "Msg")
public class Msg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content = "";
    private LocalDateTime timeStamp;
    private int sender; //här ska man lägga id för avsändaren som kan va en patient eller vad somhelst
    private int receiver; //samma här men för reciver

}
