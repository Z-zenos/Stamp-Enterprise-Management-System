package com.icheck.backend.controller;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.request.PackRequest;
import com.icheck.backend.response.PackResponse;
import com.icheck.backend.response.PacksResponse;
import com.icheck.backend.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackController {
    @Autowired
    private PackService packService;

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
        Pack pack = packService.getById(id);
        PackResponse rsp = packService.delete(pack);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/package")
    public ResponseEntity<PacksResponse> search(@RequestBody PackRequest packRequest){
        PacksResponse packsResponse = packService.search(packRequest);
        return new ResponseEntity<>(packsResponse, HttpStatus.OK);
    }



}
