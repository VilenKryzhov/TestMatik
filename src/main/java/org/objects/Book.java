package org.objects;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Book {
    String title;

    String Author;

    String price;

    public Book() {

    }
}
