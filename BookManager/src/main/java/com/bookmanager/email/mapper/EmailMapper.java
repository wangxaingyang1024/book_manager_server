package com.bookmanager.email.mapper;

import com.bookmanager.email.dto.EmailDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {

    int insertEmail(String email , String verifyCode);

    int deleteEmail(String email);


    EmailDTO getCodeByEmail(String email);
}
