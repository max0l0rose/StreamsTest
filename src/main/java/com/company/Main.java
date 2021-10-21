package com.company;

import com.company.model.Department;
import com.company.model.Role;
import com.company.model.User;
import org.springframework.shell.table.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<User> ulist = new ArrayList<User>() {{
            add(new User("User1", new Department("Dep1"), Role.USER));
            add(new User("User2", new Department("Dep1"), Role.USER));
            add(new User("UserAdmin", new Department("Dep2"), Role.ADMIN));
        }};


        Object[][] uarr = ulist.stream()
                .map(u -> u.toStringsArray())
                .toArray(size -> new Object[size][]);
        //StringsArray sa = u;

        Object[][] sampleData = new String[][]{
                {"Header1", "Header2", "Header3", "Header4", "Header5" },
        };

//        Arrays.stream(sampleData)
//                .forEach(q -> {
//                        Arrays.stream(q)
//                                .forEach(a -> System.out.print(a + " "));
//                        System.out.println(": " + Arrays.stream(q).count());
//                    }
//               );

        Object[][] joined = Stream.concat(Arrays.stream(sampleData), Arrays.stream(uarr))
                .toArray(size -> new Object[size][]);
//                .forEach(q -> {
//                    Arrays.stream(q)
//                            .forEach(a -> System.out.print(a + " "));
//                    System.out.println(": " + Arrays.stream(q).count());
//                }
//        );

//        for (Object[] j : sampleData) {
//            for (Object a : j) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
//        }


        TableModel model = new ArrayTableModel(joined);
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addInnerBorder(BorderStyle.fancy_light).addHeaderBorder(BorderStyle.fancy_double)
                .on(CellMatchers.column(0)).addWrapper(new KeyValueTextWrapper()).addSizer(new AbsoluteWidthSizeConstraints(20))
                .on(CellMatchers.column(1)).addSizer(new AbsoluteWidthSizeConstraints(30))
                .on(CellMatchers.column(2)).addSizer(new AbsoluteWidthSizeConstraints(30));
        //tableBuilder.on(CellMatchers.ofType(LocalDate.class)).addFormatter(dateFormatter);

        System.out.println(tableBuilder.build().render(80));
    }
}
