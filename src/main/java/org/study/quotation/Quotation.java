package org.study.quotation;


import lombok.Getter;

@Getter
public class Quotation {

    private Long id;
    private String phrase;
    private String author;

    public Quotation(Long id, String phrase, String author) {
        this.id = id;
        this.phrase = phrase;
        this.author = author;
    }

}
