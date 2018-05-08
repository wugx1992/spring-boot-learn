package indi.gxwu.mybatis.mapper;

import indi.gxwu.mybatis.entity.Hotel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HotelMapper {

    List<Hotel> getAll();

    Hotel getOne(int id);

    int insert(Hotel hotel);

    int update(Hotel hotel);

    int delete(int id);
}
