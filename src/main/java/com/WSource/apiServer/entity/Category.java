package com.WSource.apiServer.entity;


import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String label;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() { return label; }

    public void setLabel(String label) { this.label = label; }

}
