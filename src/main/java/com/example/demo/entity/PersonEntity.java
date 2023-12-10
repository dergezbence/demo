package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class PersonEntity {
  @Id
  private Long id;
  private String name;
}
