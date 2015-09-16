package io.github.karolkalinski.vaadin;

import com.vaadin.data.util.BeanItem;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

public class BeanMatchers {
    public <T> Matcher<? super BeanItem<T>> hasEmptyProperties(String ... propertyName) {
        List<Matcher<? super T>> matcherList = new ArrayList<>();
        for (String property : propertyName) {
            Matcher<T> matcher = hasProperty(property, isEmptyString());
            matcherList.add(matcher);
        }
        return hasProperty("bean", allOf(matcherList));
    }
}
