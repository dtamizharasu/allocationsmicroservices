package com.allocations.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVoMain {
    // List of Project with List of Mapped Employees
    private Integer allotmentId;
    private Set<ResponseVoSub> responseVoSubs;

}
