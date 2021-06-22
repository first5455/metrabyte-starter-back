package com.example.project.projectdata;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ProjectData {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Integer rating;
    private LocalDate dates;

    public ProjectData() {
    }

    public ProjectData(Long id, String name, String description, Integer rating,LocalDate dates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.dates = dates;
    }

    public ProjectData(String name, String description, Integer rating,LocalDate dates) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.dates = dates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "ProjectData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
