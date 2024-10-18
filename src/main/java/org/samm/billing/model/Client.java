package org.samm.billing.model;


import lombok.*;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Client {

    @Id
    @Column(length = 6)
    int number;

    @Column(length = 50)
    @Required
    String name;

    @Embedded
    @NoFrame
    Direction direction;
}
