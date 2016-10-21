package service;

import model.User;

import java.util.ArrayList;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:4:02 PM
 */
public interface UserService {

    //增加用户
    boolean addUser(User user);

    //根据关键字模糊查询用户
    ArrayList<User> qryUsersBykeyword(String keyword);

    //根据用户ID查询用户
    User qryUserById(String id);

    // 更新用户
    boolean updateUser(User user);

}
