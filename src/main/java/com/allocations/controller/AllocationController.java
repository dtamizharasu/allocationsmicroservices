package com.allocations.controller;

import com.allocations.model.Allocation;
import com.allocations.service.AllocationService;
import com.allocations.vo.ResponseVoMain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


/*
 * Allocation Microservices APIs
 * 1. Get All Allocation Details
 * 2. Get Allocation with Project and Employees details By Id
 * 3. Get the Allocation Details
 * 4. Add New Allocation
 * 5. Update Allocation Details
 * 6. Delete Allocation Details
 * */
@Api(value = "Swagger - 2 AllocationController")
@RestController
@RequestMapping("/api/allocation")
public class AllocationController {

    @Autowired
    AllocationService service;

    /*
     * Get All the Allocation Details
     * @return - Return List Of Allocation
     */
    @ApiOperation(value = "Get All Allotment with Projects and Employees Details",
            response = ResponseVoMain.class, tags = "Allotment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/allAllotment")
    public Set<ResponseVoMain> getAllAllocation(){
        return service.findAllAllotment();
    }

    /**
     * Get Allocation Record BY Id
     * @param id - Allotment Id
     * @return - Allocation
     */
    @ApiOperation(value = "Get All Allotment with Projects and Employees Details",
            response = ResponseVoMain.class, tags = "Allotment")
    @GetMapping("/{id}")
    public ResponseVoMain findAllotmentById(@PathVariable Integer id){
        return service.findByAllotmentById(id);
    }

    /**
     * @param allocation - Allocation Records
     * @return - Saved Allocation Record
     */
    @ApiOperation(value = "Allocate the Project to Employee",
            response = Allocation.class, tags = "Allotment")
    @PostMapping("/addHrs")
    public Allocation saveAllocation(@RequestBody Allocation allocation) throws Exception {
        return service.saveAllocation(allocation).getBody();
    }

    /**
     * @param allocation - Allocation Records
     * @return - Updated Allocation Record
     */
    @ApiOperation(value = "Update Allocation to an Employee",
            response = Allocation.class, tags = "Allotment")
    @PutMapping("/updateHrs")
    public Allocation updateAllocation(@RequestBody Allocation allocation){
        return service.updateAllocation(allocation);
    }

    /**
     * @param id - Allocation Id
     * @return - Deleted Message
     */
    @ApiOperation(value = "Remove the Employee From Allocation",
            response = String.class, tags = "Allotment")
    @DeleteMapping("/{id}")
    public String deleteAllocationById(@PathVariable Integer id){
        service.deleteAllocationById(id);
        return "Allotment Details Deleted";
    }

    /**
     * @param id - Employee id
     * @return - All Mapped Projects Ids
     */
    @ApiOperation(value = "Get All Mapped Project Ids for Single Employee",
            response = ResponseEntity.class, tags = "Allotment")
    @GetMapping("/projectIds/{id}")
    public ResponseEntity<int[]> getProjectIds(@PathVariable Integer id){

        return service.getProjectIds(id);
    }

    /**
     * @param id - Project id
     * @return - All Mapped Employee Ids
     */
    @ApiOperation(value = "Get All Mapped Employee Ids for Single Project",
            response = ResponseEntity.class, tags = "Allotment")
    @GetMapping("/employeeIds/{id}")
    public ResponseEntity<int[]> getEmployeeIds(@PathVariable Integer id){

        return service.getEmpIds(id);
    }

}
