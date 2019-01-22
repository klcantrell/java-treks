package com.kalcantrell;

public class StringListItem extends MyListItem<String> {
    private String value;

    public boolean isGreaterThan(String compareValue) {
        return value.compareTo(compareValue) > 0;
    }
}
