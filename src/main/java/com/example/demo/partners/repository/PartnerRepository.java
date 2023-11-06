package com.example.demo.partners.repository;

import com.example.demo.partners.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, String> {
    List<Partner> findByUserNameStartingWithIgnoreCase(String val);
    List<Partner> findByStoreNameStartingWithIgnoreCase(String val);
    List<Partner> findByLocationStartingWithIgnoreCase(String val);
    List<Partner> findByDescriptionStartingWithIgnoreCase(String val);
//    List<Partner> findAllBy(String val);

}

