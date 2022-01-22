//package com.allocations.repository;
//
//import com.allocations.model.Allotment;
//import com.allocations.model.AllotmentId;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public interface AllotmentRepository extends JpaRepository<Allotment, AllotmentId> {
//
//    @Query(value = "select a.allotmentId.employeeId from Allotment a where a.allotmentId.projectId in ?1")
//    List<Integer> findAllEmployeeIds(Integer projectId);
//    @Query(value = "select a.allotmentId.projectId from Allotment a where a.allotmentId.employeeId in ?1")
//    List<Integer> findAllProjectIds(Integer employeeId);
//    @Query(value = "select a from Allotment a where a.allotmentNum in ?1")
//    List<Allotment> findByAllotmentNum(Integer id);
//}
