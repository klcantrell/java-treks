package com.kalcantrell;

public class StringListItem extends MyListItem<String> {

    public StringListItem(String value) {
        this.value = value;
    }

    public boolean isGreaterThan(String compareValue) {
        return value.compareTo(compareValue) > 0;
    }
}
