package com.momen.bookmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "language")
    private String language;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date", nullable = false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date releaseDate;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;
}