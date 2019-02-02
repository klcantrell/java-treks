package com.kalcantrell;

public class ThrowsKeywordExampleTest { // why isn't this throwing a compile time error?
    public void run() {
        ThrowsKeywordExample throwsKeywordExample = new ThrowsKeywordExample();
        System.out.println(throwsKeywordExample.divide());
    }
}
