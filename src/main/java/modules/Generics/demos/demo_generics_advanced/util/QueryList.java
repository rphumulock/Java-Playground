package modules.Generics.demos.demo_generics_advanced.util;

import modules.Generics.demos.demo_generics_advanced.model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <T extends QueryItem> List<T> getMatches(List<T> items,
                                                           String field, String value) {

        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

//    public static <S extends QueryItem> List<S> getMatches(List<S> items,
//                                                           String field, String value) {
//
//        List<S> matches = new ArrayList<>();
//        for (var item : items) {
//            if (item.matchFieldValue(field, value)) {
//                matches.add(item);
//            }
//        }
//        return matches;
//    }

    public List<T> getMatches(String field, String value) {

        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
