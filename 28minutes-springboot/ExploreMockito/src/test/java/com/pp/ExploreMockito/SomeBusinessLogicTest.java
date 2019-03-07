package com.pp.ExploreMockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessLogicTest {
    @Mock
    private DataService dataService;

    private SomeBusinessLogic someBusinessLogic;

    @Before
    public void setup() {
        someBusinessLogic = new SomeBusinessLogic(dataService);
    }

    @Test
    public void findTheGreatestFromAllData() {
        when(dataService.retrieveAllData()).thenReturn(new int[] { 15, 10, 3 });
        int result = someBusinessLogic.findTheGreatestFromAllData();
        assertEquals(15, result);
    }
}