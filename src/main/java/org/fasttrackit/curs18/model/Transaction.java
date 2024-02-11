package org.fasttrackit.curs18.model;

import java.util.List;

public record Transaction(
        String id,
        String product,
        String type,
        Double amount
    ) {
}
