package com.icheck.backend.service;

import com.icheck.backend.DAO.PackDao;
import com.icheck.backend.DAO.UserDao;
import com.icheck.backend.converter.BaseConverter;
import com.icheck.backend.entity.Pack;
import com.icheck.backend.entity.User;
import com.icheck.backend.entity.UserPackage;
import com.icheck.backend.exception.ApiException;
import com.icheck.backend.exception.ErrorMessage;
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
    private BaseConverter converter;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PackDao packDao;

    public AddUserPackageResponse add(AddUserPackageRequest request) {
        User user = userDao.getById(request.getUserId());

        Pack pack = packDao.getById(request.getPackId());

        List<UserPackage> userPackages = repo.findByUserIdAndPackageId(request.getUserId(), request.getPackId());

        if (userPackages != null){
            if (userPackages.get(0).getStatus() == 0) userPackages.get(0).setStatus(1); // neu status = 0 -> set = 1
            else {
                throw new ApiException(ErrorMessage.USERPACKAGE_EXISTED); // Neu status = 1 -> throw exception
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
