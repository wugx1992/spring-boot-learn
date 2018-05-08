package indi.gxwu.mybatis.mapper;

import indi.gxwu.mybatis.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void getAllTest(){
        List<City> cityList = cityMapper.getAll();
        System.out.println(cityList);
    }


    @Test
    public void getOneTest(){
        City city = cityMapper.getOne(1);
        System.out.println(city);
    }
}
