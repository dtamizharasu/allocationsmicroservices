//
//package com.allocations.controller;
//
//import com.allocations.model.Allocation;
//import com.allocations.model.Allotment;
//import com.allocations.model.AllotmentId;
//import com.allocations.service.AllocationService;
//import com.allocations.service.AllocationServiceV2;
//import com.allocations.vo.ResponseVoMain;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Set;
//
//
///*
// * Allocation Microservices APIs
// * 1. Get All Allocation Details
// * 2. Get Allocation with Project and Employees details By Id
// * 3. Get the Allocation Details
// * 4. Add New Allocation
// * 5. Update Allocation Details
// * 6. Delete Allocation Details
// * */
//
//// Swagger URL - http://localhost:8083/swagger-ui/
//
//@Api(value = "Swagger - 2 AllocationControllerV2")
//@RestController
//@RequestMapping("/api/allocation/v2")
//public class AllocationControllerV2 {
//
//    @Autowired
//    AllocationServiceV2 service;
//
//    /*
//     * Get All the Allocation Details
//     * @return - Return List Of Allocation
//     */
//    @ApiOperation(value = "Get All Allotment with Projects and Employees Details",
//            response = ResponseVoMain.class, tags = "AllotmentV2")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success|OK"),
//            @ApiResponse(code = 401, message = "not authorized!"),
//            @ApiResponse(code = 403, message = "forbidden!!!"),
//            @ApiResponse(code = 404, message = "not found!!!") })
//    @GetMapping("/allAllotment")
//    public Set<ResponseVoMain> getAllAllocation(){
//        return service.findAllAllotment();
//    }
//
//    /**
//     * Get Allocation Record BY Id
//     * @param id - Allotment Id
//     * @return - Allocation
//     */
//    @ApiOperation(value = "Get All Allotment with Projects and Employees Details",
//            response = ResponseVoMain.class, tags = "AllotmentV2")
//    @GetMapping("/{id}")
//    public ResponseVoMain findAllotmentById(@PathVariable Integer id){
//        return service.findByAllotmentById(id);
//    }
//
//    /**
//     * @param allotment - Allotment Records
//     * @return - Saved Allocation Record
//     */
//    @ApiOperation(value = "Allocate the Project to Employee",
//            response = Allocation.class, tags = "AllotmentV2")
//    @PostMapping("/addHrs")
//    public Allotment saveAllocation(@RequestBody Allotment allotment) throws Exception {
//        return service.saveAllocation(allotment).getBody();
//    }
//
//    /**
//     * @param allotment - Allotment Records
//     * @return - Updated Allotment Record
//     */
//    @ApiOperation(value = "Update Allotment to an Employee",
//            response = Allocation.class, tags = "AllotmentV2")
//    @PutMapping("/updateHrs")
//    public Allotment updateAllocation(@RequestBody Allotment allotment){
//        return service.updateAllocation(allotment);
//    }
//
//    /**
//     * @param employeeId - Employee id
//     * @return - All Mapped Projects Ids
//     */
//    @ApiOperation(value = "Get All Mapped Project Ids for Single Employee",
//            response = ResponseEntity.class, tags = "AllotmentV2")
//    @GetMapping("/projectIds/{id}")
//    public ResponseEntity<int[]> getProjectIds(@PathVariable Integer employeeId){
//
//        return service.getProjectIds(employeeId);
//    }
//
//    /**
//     * @param projectId - Project id
//     * @return - All Mapped Employee Ids
//     */
//    @ApiOperation(value = "Get All Mapped Employee Ids for Single Project",
//            response = ResponseEntity.class, tags = "AllotmentV2")
//    @GetMapping("/employeeIds/{id}")
//    public ResponseEntity<int[]> getEmployeeIds(@PathVariable Integer projectId){
//
//        return service.getEmpIds(projectId);
//    }
//
//    /**
//     * @param id - Allocation Id
//     * @return - Deleted Message
//     */
//    @ApiOperation(value = "Remove the Employee From Allocation",
//            response = String.class, tags = "AllotmentV2")
//    @DeleteMapping("/{id}")
//    public String deleteAllocationById(@PathVariable AllotmentId id){
//        service.deleteAllotmentById(id);
//        return "Allotment Details Deleted";
//    }
//}
