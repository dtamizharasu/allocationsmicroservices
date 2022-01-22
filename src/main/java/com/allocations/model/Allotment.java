package com.allocations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allotment {

    @EmbeddedId
    private AllotmentId allotmentId;

    private Integer allotmentNum;
}
