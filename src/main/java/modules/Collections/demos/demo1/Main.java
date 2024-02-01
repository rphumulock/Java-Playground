package modules.Collections.demos.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        /**
         * These will all sort different and maybe not at all
         * depending on the type.
         *
         * Also Collection does not have a sort() method on it
         * but the extended interfaces will have concrete
         * classes that will implemented sort().
         */
        Collection<String> list = new ArrayList<>();
//        Collection<String> list = new TreeSet<>();
//        Collection<String> list = new ArrayList<>();


        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
//        list.sort(null);
    }
}
