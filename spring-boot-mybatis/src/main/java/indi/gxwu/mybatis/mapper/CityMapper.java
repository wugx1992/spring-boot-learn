package indi.gxwu.mybatis.mapper;


import indi.gxwu.mybatis.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM city")
    @Results({@Result(property = "createDate", column = "create_date")})
    List<City> getAll();

    @Select("select * from city where id=#{id}")
    @Results({@Result(property = "createDate", column = "create_date")})
    City getOne(int id);

    @Insert("insert into (id, country, createDate, map, name, state, uuid) values(id, country, createDate, map, name, state, uuid)")
    void insert(City city);

    @Update("update city set country=#{country} WHERE id=#{id}")
    void update(City city);

    @Delete("delete from city where id=#{id}")
    void delete(City city);

}
