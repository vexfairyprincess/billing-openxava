package org.samm.billing.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Direction {

    @Column(length = 30)
    String publicPlace;

    @Column(length = 5)
    int postalCode;

    @Column(length = 30)
    String city;

    @Column(length = 30)
    String province;
}
