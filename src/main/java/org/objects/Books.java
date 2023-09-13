package org.objects;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Books {
    String title;

    String author;

    String price;
}
