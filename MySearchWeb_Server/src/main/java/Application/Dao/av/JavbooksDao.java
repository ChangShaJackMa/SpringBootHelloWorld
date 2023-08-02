package Application.Dao.av;

import Application.POBJ.av.JavbooksPobj;
import org.apache.ibatis.annotations.*;

@Mapper
public interface JavbooksDao {
    @Results({
            @Result(property="mykey",column="mykey"),
            @Result(property="myvalue",column="myvalue")
    })
    @Select("select *from tmp where mykey=#{mykey}")
    JavbooksPobj select(@Param("mykey")String key);
}
