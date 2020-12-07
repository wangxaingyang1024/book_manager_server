package com.bookmanager;

import com.bookmanager.setting.model.Employee;
import com.bookmanager.setting.vo.Result;
import com.bookmanager.user.dto.EmpLoginDTO;
import com.bookmanager.user.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

@SpringBootTest
@Slf4j
public class BookmanagerApplicationTests {

    @Autowired
    private IEmployeeService employeeService ;

    @Test
    public void testLogin() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        EmpLoginDTO employee = new EmpLoginDTO("wqy","123");
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

    @Test
    public void test03(){
        System.out.println(new Date());
    }
}
