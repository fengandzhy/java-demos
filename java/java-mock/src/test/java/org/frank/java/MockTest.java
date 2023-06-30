package org.frank.java;

import org.frank.java.entity.Dummy;
import org.frank.java.repository.DummyRepository;
import org.frank.java.service.DummyService;
import org.frank.java.service.ExampleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class MockTest {
    //@Mock创建了一个模拟。@InjectMocks创建类的一个实例，并将用@Mock或@Spy注释创建的模拟注入到这个实例中。
    @Mock
    private DummyRepository dummyRepository;

    @InjectMocks
    private DummyService dummyService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getDummyNameUpperCase() {
        Dummy mockedDummy = new Dummy("dm1", "Dummy 1", "This is dummy 1", 2000, true);
        when(dummyRepository.findById("dm1")).thenReturn(mockedDummy);

        String result = dummyService.getDummyNameUpperCase("dm1");
        verify(dummyRepository, times(1)).findById("dm1");
        assertThat(result, is("DM1"));
    }

    @Test
    public void testExampleService() {
        ExampleService exampleService = mock(ExampleService.class);
        // 设置让 add(1,2) 返回 100
        when(exampleService.add(1, 2)).thenReturn(100);
        exampleService.add(1, 2);
        // 校验是否调用过 add(1, 2) -> 校验通过
        verify(exampleService).add(1, 2);
        // 校验是否调用过 add(2, 2) -> 校验不通过
//        verify(exampleService).add(2, 2);
    }

    @Test
    public void testMockitoList() {
        List<String> mockList = mock(List.class);
        mockList.add("Pankaj");
        mockList.size();
        verify(mockList).add("Pankaj");
        verify(mockList, times(1)).size();

        verify(mockList, times(1)).size(); //same as normal verify method
        verify(mockList, atLeastOnce()).size(); // must be called at least once
        verify(mockList, atMost(2)).size(); // must be called at most 2 times
        verify(mockList, atLeast(1)).size(); // must be called at least once
        verify(mockList, never()).clear(); // must never be called

        verifyNoMoreInteractions(mockList); // 在这之前，凡是上面用道的mockList的方法都verify了，那么这个pass
        mockList.isEmpty();
        verify(mockList).isEmpty();
        // isEmpty() is not verified, so below will fail
        verifyNoMoreInteractions(mockList); // 如果上面的这方法mockList.isEmpty()没有被验证过，那么这里就不通过
    }
}
