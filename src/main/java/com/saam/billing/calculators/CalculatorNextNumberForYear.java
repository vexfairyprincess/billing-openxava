package com.saam.billing.calculators;

import javax.persistence.*;
import lombok.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;

public class CalculatorNextNumberForYear implements ICalculator {

    @Getter @Setter
    int year;
    @Override
    public Object calculate() throws Exception {
        Query query = XPersistence.getManager().createQuery(
            "select max(b.number) from Bill b where b.year = :year"
        );
        query.setParameter("year", year);
        Integer lastNumber = (Integer) query.getSingleResult();
        return lastNumber == null? 1: lastNumber + 1;
    }
}
