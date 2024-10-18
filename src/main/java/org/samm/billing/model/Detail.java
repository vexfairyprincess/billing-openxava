package org.samm.billing.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class Detail {

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product product;
}
