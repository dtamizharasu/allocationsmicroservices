package com.allocations.service;

import com.allocations.model.Allocation;
import com.allocations.repository.AllocationRepository;
import com.allocations.vo.ResponseVoMain;
import com.allocations.vo.ResponseVoSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AllocationService {

    @Autowired
    AllocationRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public Set<ResponseVoMain> findAllAllotment(){
        Set<ResponseVoMain> responseVoMains = new HashSet<>();
        List<Allocation> allocationId = repository.findAll();

        allocationId.forEach(allocation ->{
            ResponseVoMain responseVoMain = new ResponseVoMain();
            Set<ResponseVoSub> responseVoSubs = new HashSet<>();
            ResponseVoSub result =
            restTemplate.getForObject("http://Project-Service/api/project/project/"
                            +allocation.getProjectId(),ResponseVoSub.class);

            responseVoSubs.add(result);
            responseVoMain.setAllotmentId(allocation.getAllotmentId());
            responseVoMain.setResponseVoSubs(responseVoSubs);
            responseVoMains.add(responseVoMain);
        });

        return responseVoMains;
    }

    public ResponseVoMain findByAllotmentById(Integer id){
        ResponseVoMain responseVoMain = new ResponseVoMain();
        Set<ResponseVoSub> responseVoSubs = new HashSet<>();
        List<Integer> projectIds = repository.findAllProjectIds(id);

        if (!projectIds.isEmpty()) {
            projectIds.forEach(prId ->{
                ResponseVoSub result = restTemplate
                        .getForObject("http://Project-Service/api/project/project/" + prId, ResponseVoSub.class);
                responseVoSubs.add(result);
            });
            responseVoMain.setResponseVoSubs(responseVoSubs);
            responseVoMain.setAllotmentId(id);
        }

        return responseVoMain;
    }

    public Allocation getAllocationByID(Integer id){
        return repository.getById(id);
    }

    public Allocation updateAllocation(Allocation emp){
        return repository.save(emp);
    }

    public ResponseEntity<Allocation> saveAllocation(Allocation emp) throws Exception {
        List<Integer> projectIds = repository.findAllProjectIdByEmpId(emp.getEmpId());
        if(projectIds.contains(emp.getProjectId())){
            throw new Exception("Employee Already Mapped this Project");
        }
        return ResponseEntity.ok(repository.save(emp));
    }

    public void deleteAllocationById(Integer id){
        repository.deleteById(id);
    }

    public ResponseEntity<int[]> getProjectIds(Integer empId){
        ResponseEntity<int[]> responseEntity = null;
        int[] ids;
        List<Integer> listIds = repository.findAllProjectIdByEmpId(empId);
        if(!listIds.isEmpty()){
            ids = new int[listIds.size()];
            ids =   listIds.stream().mapToInt(Integer::intValue).toArray();
            responseEntity = new ResponseEntity<>(ids, HttpStatus.ACCEPTED);
        }

        return responseEntity;
    }

    public ResponseEntity<int[]> getEmpIds(Integer projectId){
        ResponseEntity<int[]> responseEntity = null;
        int[] ids;
        List<Integer> listIds = repository.findAllEmployeeIds(projectId);

        if(!listIds.isEmpty()){
            ids = new int[listIds.size()];
            ids =   listIds.stream().mapToInt(Integer::intValue).toArray();
            responseEntity = new ResponseEntity<>(ids, HttpStatus.ACCEPTED);
        }

        return responseEntity;
    }
 }
