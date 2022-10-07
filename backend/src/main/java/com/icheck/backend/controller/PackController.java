package com.icheck.backend.controller;

import com.icheck.backend.entity.Pack;
import com.icheck.backend.exception.ErrorMessage;
import com.icheck.backend.request.pack_request.AddPackRequest;
import com.icheck.backend.request.pack_request.PackRequest;
import com.icheck.backend.request.pack_request.UpdatePackRequest;
import com.icheck.backend.response.BaseResponse;
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
    private PackService service;
    @Autowired
    private PackDao dao;

    @PostMapping("/package")
    public ResponseEntity<BaseResponse<AddPackResponse>> add(@RequestBody AddPackRequest request){
        BaseResponse<AddPackResponse> rsp = new BaseResponse<>(ErrorMessage.SUCCESS, service.add(request));
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @PutMapping("/package/{id}")
    public ResponseEntity<BaseResponse<UpdatePackResponse>> update(@PathVariable("id") Long id,
                                               @RequestBody UpdatePackRequest request){
        request.setId(id);
        BaseResponse<UpdatePackResponse> rsp = new BaseResponse<>(ErrorMessage.SUCCESS, service.update(request));
        return new ResponseEntity<>(rsp, HttpStatus.OK);

    }
    @DeleteMapping("package/{id}")
    public ResponseEntity<BaseResponse<DeletePackResponse>> delete(@PathVariable("id") Long id){
        BaseResponse<DeletePackResponse> rsp = new BaseResponse<>(ErrorMessage.SUCCESS, service.delete(id));
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/packages")
    public ResponseEntity<BaseResponse<PacksResponse>> search(@RequestParam(name = "code", defaultValue = "", required = false) String code,
                                                @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                                @RequestParam(name = "status", required = false, defaultValue = "-1") String status){
        BaseResponse<PacksResponse> rsp = new BaseResponse<>(ErrorMessage.SUCCESS, service.search(code, name, Integer.valueOf(status)));
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/package/{id}")
    public ResponseEntity<BaseResponse<PackResponse>> getById(@PathVariable(name = "id") Long id){
        BaseResponse<PackResponse> rsp = new BaseResponse<>(ErrorMessage.SUCCESS, service.getById(id));
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }


}
