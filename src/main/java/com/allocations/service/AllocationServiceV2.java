//package com.allocations.service;
//
//import com.allocations.model.Allocation;
//import com.allocations.model.Allotment;
//import com.allocations.model.AllotmentId;
//import com.allocations.repository.AllocationRepository;
//import com.allocations.repository.AllotmentRepository;
//import com.allocations.vo.ResponseVoMain;
//import com.allocations.vo.ResponseVoSub;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class AllocationServiceV2 {
//
//    @Autowired
//    AllotmentRepository repository;
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    public Set<ResponseVoMain> findAllAllotment(){
//        Set<ResponseVoMain> responseVoMains = new HashSet<>();
//        List<Allotment> allotmentList = repository.findAll();
//
//        allotmentList.forEach(allotment ->{
//            ResponseVoMain responseVoMain = new ResponseVoMain();
//            Set<ResponseVoSub> responseVoSubs = new HashSet<>();
//            ResponseVoSub result =
//            restTemplate.getForObject("http://localhost:8082/api/project/project/"
//                            +allotment.getAllotmentId().getProjectId(),ResponseVoSub.class);
//
//            responseVoSubs.add(result);
//            responseVoMain.setAllotmentId(allotment.getAllotmentNum());
//            responseVoMain.setResponseVoSubs(responseVoSubs);
//            responseVoMains.add(responseVoMain);
//        });
//
//        return responseVoMains;
//    }
//
//    public ResponseVoMain findByAllotmentById(Integer id){
//        ResponseVoMain responseVoMain = new ResponseVoMain();
//        Set<ResponseVoSub> responseVoSubs = new HashSet<>();
//        List<Integer> projectIds = repository.findByAllotmentNum(id).stream()
//                .map(f -> f.getAllotmentId().getProjectId())
//                .collect(Collectors.toList());
//
//        if (!projectIds.isEmpty()) {
//            projectIds.forEach(prId ->{
//                ResponseVoSub result = restTemplate
//                        .getForObject("http://localhost:8082/api/project/project/" + prId,
//                                ResponseVoSub.class);
//                responseVoSubs.add(result);
//            });
//            responseVoMain.setResponseVoSubs(responseVoSubs);
//            responseVoMain.setAllotmentId(id);
//        }
//
//        return responseVoMain;
//    }
//
//    public Allotment updateAllocation(Allotment allotment){
//        return repository.save(allotment);
//    }
//
//    public ResponseEntity<Allotment> saveAllocation(Allotment allotment) throws Exception {
//        Optional<Allotment> allotmentExists = repository.findById(allotment.getAllotmentId());
//        if(allotmentExists.isPresent()){
//            throw new Exception("Employee Already Mapped this Project");
//        }
//        return ResponseEntity.ok(repository.save(allotment));
//    }
//
//    public ResponseEntity<int[]> getProjectIds(Integer empId){
//        ResponseEntity<int[]> responseEntity = null;
//        int[] ids;
//        List<Integer> listIds = repository.findAllProjectIds(empId);
//        if(!listIds.isEmpty()){
//            ids = new int[listIds.size()];
//            ids =   listIds.stream().mapToInt(Integer::intValue).toArray();
//            responseEntity = new ResponseEntity<>(ids, HttpStatus.ACCEPTED);
//        }
//
//        return responseEntity;
//    }
//
//    public ResponseEntity<int[]> getEmpIds(Integer projectId){
//        ResponseEntity<int[]> responseEntity = null;
//        int[] ids;
//        List<Integer> listIds = repository.findAllEmployeeIds(projectId);
//
//        if(!listIds.isEmpty()){
//            ids = new int[listIds.size()];
//            ids =   listIds.stream().mapToInt(Integer::intValue).toArray();
//            responseEntity = new ResponseEntity<>(ids, HttpStatus.ACCEPTED);
//        }
//
//        return responseEntity;
//    }
//
//    public void deleteAllotmentById(AllotmentId id){
//        repository.deleteById(id);
//    }
// }
