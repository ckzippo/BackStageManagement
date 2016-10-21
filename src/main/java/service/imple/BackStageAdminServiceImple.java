package service.imple;

import dao.BackStageAdminDao;
import model.BackStageAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BackStageAdminService;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:4:31 PM
 */
@Service
public class BackStageAdminServiceImple implements BackStageAdminService {
    @Autowired
    BackStageAdminDao backStageAdminDao;

    /**
     * 后台管理员用户名密码校验
     * @param name 用户名
     * @param password 密码
     * @return true 成功, false 失败
     */
    public BackStageAdmin validateAdmin(String name, String password) {
        return backStageAdminDao.validateAdmin(name, password);
    }

    /**
     * 新增管理员
     * @param backStageAdmin
     */
    public void addBackStageAdmin(BackStageAdmin backStageAdmin) {
        backStageAdminDao.addBackStageAdmin(backStageAdmin);
    }
}
