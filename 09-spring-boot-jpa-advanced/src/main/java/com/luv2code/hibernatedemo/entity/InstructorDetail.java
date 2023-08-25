package com.luv2code.hibernatedemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;
}