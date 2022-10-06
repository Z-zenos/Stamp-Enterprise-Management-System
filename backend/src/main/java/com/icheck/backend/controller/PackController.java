package com.icheck.backend.controller;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.request.pack_request.AddPackRequest;
import com.icheck.backend.request.pack_request.PackRequest;
import com.icheck.backend.request.pack_request.UpdatePackRequest;
import com.icheck.backend.response.pack_response.*;
import com.icheck.backend.DAO.PackDao;
import com.icheck.backend.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class PackController {
    @Autowired
    private PackService packService;
    @Autowired
    private PackDao dao;

    @PostMapping("/package")
    public ResponseEntity<AddPackResponse> add(@RequestBody AddPackRequest request){
        AddPackResponse rsp = packService.add(request);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @PutMapping("/package/{id}")
    public ResponseEntity<UpdatePackResponse> update(@PathVariable("id") Long id,
                                               @RequestBody UpdatePackRequest request){
        request.setId(id);
        UpdatePackResponse rsp = packService.update(request);
        return new ResponseEntity<>(rsp, HttpStatus.OK);

    }
    @DeleteMapping("package/{id}")
    public ResponseEntity<DeletePackResponse> delete(@PathVariable("id") Long id){
        DeletePackResponse rsp = packService.delete(id);
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
