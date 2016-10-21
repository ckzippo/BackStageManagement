package service.imple;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.InvokeHttpUtil;

import java.util.ArrayList;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:4:07 PM
 */
@Service
public class UserServiceImple implements UserService {

    @Autowired
    private InvokeHttpUtil invokeHttpUtil;

    public boolean addUser(User user) {
        return invokeHttpUtil.AddUser("29297",user);
    }

    public ArrayList<User> qryUsersBykeyword(String keyword) {
        return invokeHttpUtil.QryUser(keyword);
    }

    public User qryUserById(String id) {
        return invokeHttpUtil.QryUserById(id);
    }

    public boolean updateUser(User user) {
        return invokeHttpUtil.ModUser(user);
    }
}
