package com.allocations.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "allocation")
@NoArgsConstructor
@AllArgsConstructor
public class Allocation{

    @Id
    @GeneratedValue
    private Integer allocationId;

    @Column(name = "allotmentId")
    private Integer allotmentId;

    @Column(name = "empId")
    private Integer empId;

    @Column(name = "projectId")
    private Integer projectId;

    @Column(name = "contribution")
    private String contributionHRS;

}
