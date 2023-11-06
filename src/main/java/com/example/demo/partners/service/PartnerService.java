package com.example.demo.partners.service;

import com.example.demo.admin.model.MemberParam;
import com.example.demo.partners.entity.Partner;
import com.example.demo.partners.service.dto.RegisterInput;

import java.util.List;

public interface PartnerService {
    boolean register(RegisterInput parameter);
    List<Partner> list(MemberParam parameter);
    List<Partner> info(String userName);
    List<Partner> getAllRestaurantsExceptAdmin();
}
