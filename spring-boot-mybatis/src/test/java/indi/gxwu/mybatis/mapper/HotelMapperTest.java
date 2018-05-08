package indi.gxwu.mybatis.mapper;

import indi.gxwu.mybatis.entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HotelMapperTest {

    @Autowired
    HotelMapper hotelMapper;


    @Test
    public void getAllTest(){
        List<Hotel> hotelList = hotelMapper.getAll();
        System.out.println(hotelList);
    }

    @Test
    public void getOneTest(){
        Hotel hotel = hotelMapper.getOne(1);
        System.out.println(hotel);
    }

    @Test
    public void insertTest(){
        Hotel hotel = new Hotel();
        hotel.setAddress("深圳福田区NEO大厦");
        hotel.setCityId(1);
        hotel.setName("福田NEO酒店");
        hotel.setZip("暂无");
        int result = hotelMapper.insert(hotel);
        System.out.println(result);
    }

    @Test
    public void updateTest(){
        Hotel hotel = new Hotel();
        hotel.setAddress("深圳南山大冲");
        hotel.setName("大冲花园");
        hotel.setZip("无");
        hotel.setCityId(1);
        hotel.setId(1);
        int result = hotelMapper.update(hotel);
        System.out.println(result);
    }
}
