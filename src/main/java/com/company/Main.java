package com.company;

import com.company.model.Department;
import com.company.model.Role;
import com.company.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> ulist = new ArrayList<User>() {{
            add(new User("User1", new Department("Dep1"), Role.USER));
            add(new User("User2", new Department("Dep1"), Role.USER));
            add(new User("UserAdmin", new Department("Dep2"), Role.ADMIN));
        }};


        Object[][] oarr = ulist.stream()
                .map(u -> u.toStringsArray())
                .toArray(size -> new Object[size][]);
        //StringsArray sa = u;

        Object[][] sampleData = new String[][]{
                {"qq11", "qq12", "www" },
                {"qq21", "qq22"},
                {"qq31", "qq32"},
        };

        Arrays.stream(sampleData).forEach(q ->
                                                  System.out.println(Arrays.stream(q).count())
        );
    }
}
