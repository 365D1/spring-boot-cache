package com._365d1.cache.dao;
// +----------------------------------------------------------------------
// | 官方网站: www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 
// +----------------------------------------------------------------------
// | 时　　间: 2020/6/7 12:46
// +----------------------------------------------------------------------
// | 代码创建: 朱荻 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import com._365d1.cache.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {

    @Select("select * from user where id = #{id}")
    User detail(@Param(value = "id") Integer id);

    @Update("UPDATE `user` SET nick_name = #{nickName} WHERE id = #{id}")
    void update(@Param(value = "nickName") String nickName, @Param(value = "id") Integer id);

    @Delete("DELETE FROM `user` WHERE id = #{id}")
    void delete(@Param(value = "id") Integer id);

}
