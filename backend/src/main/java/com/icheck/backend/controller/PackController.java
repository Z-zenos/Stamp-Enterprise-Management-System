package com.icheck.backend.controller;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PackResponse;
import com.icheck.backend.response.PacksResponse;
import com.icheck.backend.DAO.PackDao;
import com.icheck.backend.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackController {
    @Autowired
    private PackService packService;
    @Autowired
    private PackDao dao;

    @PostMapping("/package")
    public ResponseEntity<PackResponse> add(@RequestBody PackRequest packRequest){
        PackResponse rsp = packService.save(packRequest);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @PutMapping("/package/{id}")
    public ResponseEntity<PackResponse> update(@PathVariable("id") Long id,
                                               @RequestBody PackRequest packRequest){
        packRequest.setId(id);
        PackResponse rsp = packService.save(packRequest);
        return new ResponseEntity<>(rsp, HttpStatus.OK);

    }
    @DeleteMapping("package/{id}")
    public ResponseEntity<PackResponse> delete(@PathVariable("id") Long id){
        Pack pack = dao.getById(id);
        PackResponse rsp = packService.delete(pack);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/packages")
    public ResponseEntity<PacksResponse> search(@RequestParam(name = "code", defaultValue = "", required = false) String code,
                                                @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                                @RequestParam(name = "status", required = false, defaultValue = "-1") String status){
        PacksResponse packsResponse = packService.search(code, name, Integer.valueOf(status));
        return new ResponseEntity<>(packsResponse, HttpStatus.OK);
    }
    @GetMapping("/package/{id}")
    public ResponseEntity<PackResponse> getById(@PathVariable(name = "id") Long id){
        PackResponse packResponse = packService.getById(id);
        return new ResponseEntity<>(packResponse, HttpStatus.OK);
    }


}
