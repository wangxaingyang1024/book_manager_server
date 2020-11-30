package com.bookmanager;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.util.MyMD5Util;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.EmployeeDTO;
import com.bookmanager.user.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class BookmanagerApplicationTests {

    @Autowired
    private IEmployeeService employeeService ;

    @Test
    public void testLogin() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        EmployeeDTO employee = new EmployeeDTO("wqy","123");
        Result<Employee> result = employeeService.adminEmpLogin(employee);
        log.info(result.toString());
    }

    @Test
    public void testUUID(){
        StringBuilder str=new StringBuilder();//定义变长字符串bai
        Random random=new Random();
//随机生成数字，并添加到字符串
        for(int i=0;i<8;i++){
            str.append(random.nextInt(10));
        }
//将字符串转换为数字并du输出
        int num=Integer.parseInt(str.toString());
        System.out.println(num);
    }
}
