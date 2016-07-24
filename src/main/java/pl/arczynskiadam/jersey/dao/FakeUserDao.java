package pl.arczynskiadam.jersey.dao;

import com.google.common.collect.Lists;
import pl.arczynskiadam.jersey.security.User;

import java.util.List;

public class FakeUserDao {

    public static User findUserByName(String name) {
        User user = new User();
        if ("admin".equals(name)) {
            List<String> roles = Lists.newArrayList("admin");
            user.setRoles(roles);
        }
        return user;
    }
}
