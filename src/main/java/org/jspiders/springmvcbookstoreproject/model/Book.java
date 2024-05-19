package org.jspiders.springmvcbookstoreproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book_info")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
//    @Digits(integer = 10,fraction = 0,message = "Product ID must be an integer")
    private int bookId;




    @Column(name = "book_name")
    private String bookName;




    @Column(name = "book_publication")
    private String bookPublication;




    @Column(name = "book_author")
    private String bookAuthor;


    @Column(name = "book_price")
    private double bookPrice;
}
