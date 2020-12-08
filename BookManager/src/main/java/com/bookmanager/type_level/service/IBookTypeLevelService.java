package com.bookmanager.type_level.service;

import com.bookmanager.setting.model.BookTypeLevel;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.type_level.dto.BookTypeLevelDTO;

public interface IBookTypeLevelService {

    Result addBookType(BookTypeLevel bookTypeLevel);
}
