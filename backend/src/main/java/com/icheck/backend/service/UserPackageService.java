package com.icheck.backend.service;

import com.icheck.backend.converter.BaseConverter;
import com.icheck.backend.entity.Pack;
import com.icheck.backend.entity.User;
import com.icheck.backend.entity.UserPackage;
import com.icheck.backend.repositority.PackRepo;
import com.icheck.backend.repositority.UserPackageRepo;
import com.icheck.backend.repositority.UserRepo;
import com.icheck.backend.request.user_package_request.AddUserPackageRequest;
import com.icheck.backend.response.user_packge_response.AddUserPackageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPackageService {
    @Autowired
    private UserPackageRepo repo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PackRepo packRepo;
    @Autowired
    private BaseConverter converter;

    public AddUserPackageResponse add(AddUserPackageRequest request) {
        User user = userRepo.findById(request.getUserId()).get();
        if (user == null){
            System.out.println("user khong ton tai");
            return null;
        }
        Pack pack = packRepo.findById(request.getPackId()).get();
        if (pack == null){
            System.out.println("Package khong ton tai");
            return null;
        }
        List<UserPackage> userPackages = repo.findByUserIdAndPackageId(request.getUserId(), request.getPackId());
        if (userPackages != null){
            if (userPackages.get(0).getStatus() == 0) userPackages.get(0).setStatus(1);
            else {
                System.out.println("Goi nguoi dung da ton tai, dang ki goi khac!");
                return null;
            }
            return converter.toResponse(userPackages.get(0), AddUserPackageResponse.class);
        }
        else
        {
            try{
                UserPackage userPackage = repo.save(userPackages.get(0));
            }
            catch (Exception e){
                e.getStackTrace();
                return null;
            }
            return converter.toResponse(userPackages.get(0), AddUserPackageResponse.class);
        }
    }
}
