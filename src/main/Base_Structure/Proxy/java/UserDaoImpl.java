/**
 * Copyright (C), 2018-2020
 * FileName: UserDaoImpl
 * Author:   xjl
 * Date:     2020/3/10 13:30
 * Description: 实现类
 */
package Base_Structure.Proxy.java;

public class UserDaoImpl implements Base_Structure.Proxy.java.UserDao {

    @Override
    public void query(String name) {
        System.out.println(name);
    }
}
