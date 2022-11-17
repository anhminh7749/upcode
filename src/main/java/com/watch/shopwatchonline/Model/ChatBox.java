package com.watch.shopwatchonline.Model;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ChatBox")
public class ChatBox {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String room;
    @Column
    private String username;
    @Column
    private Short status;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User users;
}
