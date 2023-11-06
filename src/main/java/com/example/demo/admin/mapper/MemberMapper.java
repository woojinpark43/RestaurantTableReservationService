package com.example.demo.admin.mapper;

import com.example.demo.admin.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> selectList(MemberDto parameter);

}
