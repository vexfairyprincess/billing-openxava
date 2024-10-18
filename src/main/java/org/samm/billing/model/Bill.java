package org.samm.billing.model;


import com.saam.billing.calculators.CalculatorNextNumberForYear;
import lombok.Getter;
import lombok.Setter;
import org.apache.xmlbeans.impl.soap.Detail;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter @Setter
public class Bill {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

    @DefaultValueCalculator(CurrentYearCalculator.class)
    @Column(length = 4)
    int year;

    @Column(length = 6)
    @DefaultValueCalculator(value = CalculatorNextNumberForYear.class,
    properties = @PropertyValue(name = "year"))
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Client client;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity")
    Collection<Detail> details;

    @Stereotype("MONEY")
    String observations;


}
