package com.allocations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AllotmentId implements Serializable {

    private Integer employeeId;
    private Integer projectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllotmentId that = (AllotmentId) o;

        if (!employeeId.equals(that.employeeId)) return false;
        return projectId.equals(that.projectId);
    }

    @Override
    public int hashCode() {
        int result = employeeId.hashCode();
        result = 31 * result + projectId.hashCode();
        return result;
    }
}
