package com.WSource.apiServer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity()
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String review;

    @ManyToOne
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "resource_id", nullable = false)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("post_id")
    private Resource resource;

}