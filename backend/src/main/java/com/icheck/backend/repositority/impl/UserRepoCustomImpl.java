package com.icheck.backend.repositority.impl;

import com.icheck.backend.converter.BaseConverter;
import com.icheck.backend.entity.User;
import com.icheck.backend.repositority.UserRepoCustom;
import com.icheck.backend.response.user_response.UserResponse;
import com.icheck.backend.response.user_response.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component("userRepoCustom")
public class UserRepoCustomImpl implements UserRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private BaseConverter converter;
    @Override
    public UsersResponse search(String name, String email, String phone, String taxCode, String city, String district,String address, int status){
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sql.append("from User u where (u.name LIKE :name) " +
                    "and (u.phone LIKE :phone) " +
                "and (u.email LIKE :email) " +
                "and (u.taxCode LIKE :taxCode) " +
                "and (u.city LIKE :city) " +
                "and (u.district LIKE :district) " +
                "and (u.address LIKE :address) ");

        params.put("name", "%"+name+"%");
        params.put("phone", "%"+phone+"%");
        params.put("email", "%"+email+"%");
        params.put("taxCode", "%"+taxCode+"%");
        params.put("city", "%"+city+"%");
        params.put("district", "%"+district+"%");
        params.put("address", "%"+address+"%");

        if(status != -1){
            sql.append("and u.status LIKE :status");
            params.put("status", status);
        }
        Query query = entityManager.createQuery(sql.toString());
        params.forEach(query::setParameter);

        List<User> users =  query.getResultList();
        UsersResponse usersResponse = new UsersResponse();

        for (User item:users) {
            usersResponse.getUserResponseList().add(converter.toResponse(item, UserResponse.class));
        }
        return usersResponse;
    }
}
