package pl.arczynskiadam.demo.jersey2.dao;

import com.google.common.collect.Lists;
import pl.arczynskiadam.demo.jersey2.security.User;

import java.util.List;

public class FakeUserDao {

    public static User findUserByName(String name) {
        User user = null;
        if ("admin".equals(name)) {
            user = new User();
            List<String> roles = Lists.newArrayList("admin");
            user.setRoles(roles);
        } else if ("user".equals(name)) {
            user = new User();
            List<String> roles = Lists.newArrayList("user");
            user.setRoles(roles);
        }
        return user;
    }
}
