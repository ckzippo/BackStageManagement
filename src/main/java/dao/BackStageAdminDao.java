package dao;

import model.BackStageAdmin;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:4:29 PM
 */

public interface BackStageAdminDao {

    // 用户名密码校验
/*
    @Select("select acc, password, role, deptid from user where acc = #{acc} and password = #{password}")
*/
    BackStageAdmin validateAdmin(String name, String password);

    // 新增管理员
    public void addBackStageAdmin(BackStageAdmin backStageAdmin);

}
