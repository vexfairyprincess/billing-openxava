package org.samm.billing.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter

public class Product {

    @Id
    @Column(length = 9)
    int number;

    @Column(length = 50)
    @Required
    String description;

    @ManyToOne
    (fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    Category category;

    @Money
    BigDecimal price;

    @Files
    @Column(length = 32)
    String photos;

    @TextArea
    String observations;
}
