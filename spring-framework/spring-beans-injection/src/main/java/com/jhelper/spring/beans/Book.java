package com.jhelper.spring.beans;

public class Book {
  private final Author author;

  public Book(Author author) {
    this.author = author;
  }

  public String getAuthorName() {
    return author.getName();
  }
}
