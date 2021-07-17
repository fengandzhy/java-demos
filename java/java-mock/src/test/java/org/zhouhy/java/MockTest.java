package org.zhouhy.java;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.zhouhy.java.entity.Dummy;
import org.zhouhy.java.repository.DummyRepository;
import org.zhouhy.java.service.DummyService;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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

    


}
