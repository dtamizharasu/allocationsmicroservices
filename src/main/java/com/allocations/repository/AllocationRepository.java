package com.allocations.repository;

import com.allocations.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation,Integer> {

    /*
    * Notes:
    * 1. Table Name should be same as Pojo Class Name i.e class name -Allocation
    * 2. Variable Name should be same as Pojo Class Name i.e allotmentId*/

    @Query(value = "select a.projectId from Allocation a where a.allotmentId in ?1")
    List<Integer> findAllProjectIds(int allotmentId);

    @Query(value = "select a.empId from Allocation a where a.projectId in ?1")
    List<Integer> findAllEmployeeIds(Integer projectIds);

    @Query(value = "select a.projectId from Allocation a where a.empId in ?1")
    List<Integer> findAllProjectIdByEmpId(Integer empId);

    @Query(value = "delete from Allocation a where a.projectId in ?1")
    List<Integer> deleteProjectById(int projId);

    @Query(value = "delete from Allocation a where a.empId in ?1")
    List<Integer> deleteEmployeeById(int empId);
}
