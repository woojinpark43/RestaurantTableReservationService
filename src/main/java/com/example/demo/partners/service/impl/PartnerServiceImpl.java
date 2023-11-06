package com.example.demo.partners.service.impl;

import com.example.demo.admin.model.MemberParam;
import com.example.demo.partners.entity.Partner;
import com.example.demo.partners.repository.PartnerRepository;
import com.example.demo.partners.service.PartnerService;
import com.example.demo.partners.service.dto.RegisterInput;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    @Override
    public boolean register(RegisterInput parameter) {

        Optional<Partner> optionalMember = partnerRepository.findById(parameter.getUserName());
        if(optionalMember.isPresent()){
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());

        partnerRepository.save(Partner.builder()
                .storeName(parameter.getStoreName())
                .location(parameter.getLocation())
                .userName(parameter.getUserName())
                .password(encPassword)
                .description(parameter.getDescription()).build());

        return true;
    }

    @Override
    public List<Partner> info(String userName) {

        return partnerRepository.findByUserNameStartingWithIgnoreCase(userName);
    }

    @Override
    public List<Partner> getAllRestaurantsExceptAdmin() {

        List<Partner> allJpa =  partnerRepository.findAll();
        List<Partner> ret = new ArrayList<>();
        for (Partner restaurant : allJpa) {
            if (!restaurant.isAdminYn()) {
                ret.add(restaurant);
            }
        }

        return ret;
    }

    @Override
    public List<Partner> list(MemberParam parameter) {

//        MemberDto parameter = new MemberDto();
//        List<MemberDto> list = memberMapper.selectList(parameter);
        if (parameter.getSearchType() == null || parameter.getSearchValue() == null
                || parameter.getSearchValue().equals("")) {
            return partnerRepository.findAll();
        }

//        @Query("SELECT p FROM Partner p WHERE p.searchType = :searchValue")
        List<Partner> ret = new ArrayList<>();

//        if(parameter.getSearchType().equals("all")) {
//            ret = partnerRepository.findAllBy(parameter.getSearchValue());
//        }
        if(parameter.getSearchType().equals("userName")) {
            ret = partnerRepository.findByUserNameStartingWithIgnoreCase(parameter.getSearchValue());
        }
        else if(parameter.getSearchType().equals("storeName")) {
            ret = partnerRepository.findByStoreNameStartingWithIgnoreCase(parameter.getSearchValue());
        }
        else if(parameter.getSearchType().equals("location")) {
            ret = partnerRepository.findByLocationStartingWithIgnoreCase(parameter.getSearchValue());
        }
        else if(parameter.getSearchType().equals("description")) {
            ret = partnerRepository.findByDescriptionStartingWithIgnoreCase(parameter.getSearchValue());
        }

        return ret;

//        return partnerRepository.findAll();

//        return list;
    }
}
