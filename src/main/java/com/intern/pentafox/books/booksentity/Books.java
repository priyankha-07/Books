package com.intern.pentafox.books.booksentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")

public class Books {
    @Id
    @Generated
    int id;
    String  name;
    int quantity;
    double price;

}
