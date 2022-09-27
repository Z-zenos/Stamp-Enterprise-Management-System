package com.icheck.backend.controller;

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
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        Boolean rsp = packService.delete(id);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/package")
    public ResponseEntity<PacksResponse> search(@RequestParam(name = "code", required = false, defaultValue = "") String code,
                                                            @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                                            @RequestParam(name = "page", required = false, defaultValue = "-1") int page,
                                                            @RequestParam(name = "size", required = false, defaultValue = "-1") int size){

        PacksResponse rsp = null;
        if (code.isEmpty() == true && name.isEmpty() == true){
            if (page > 0 && size > 0){
                Pageable pageable = (Pageable) PageRequest.of(page - 1, size);
                rsp = packService.findPagination(pageable);
            }else{
                rsp = packService.getAll();
            }
        }else{
            if (page < 0 && size < 0){
                if (code.isEmpty() == true && name.isEmpty() == false){
                    rsp = packService.getByName(name);
                }else
                if (code.isEmpty() == false && name.isEmpty() == true){
                    rsp = packService.getByCode(code);
                }else{
                    rsp = packService.getByCodeAndName(code, name);
                }

            }
        }
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }



}
