package com.pp.ExploreMockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

    @Mock
    private List list;

    @Test
    public void size_singleReturn() {
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
        assertEquals(10, list.size());
    }

    @Test
    public void size_multipleReturns() {
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    public void get_specificParameters() {
        when(list.get(0)).thenReturn("SomeString");
        assertEquals("SomeString", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void get_genericParameters() {
        when(list.get(anyInt())).thenReturn("SomeString");
        assertEquals("SomeString", list.get(0));
        assertEquals("SomeString", list.get(1));
    }

}


