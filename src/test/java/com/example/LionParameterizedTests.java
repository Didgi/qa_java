package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.*;

@RunWith(Parameterized.class)
public class LionParameterizedTests {
    @Mock
    Feline feline;
    @Parameterized.Parameter
    public String gender;
    @Parameterized.Parameter(1)
    public String ExceptionMessageExpected;
    @Parameterized.Parameter(2)
    public boolean hasManeExpected;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", "", true},
                {"Самка", "", false},
                {"Оно", "Используйте допустимые значения пола животного - самец или самка", false}
        };
    }

    @Test
    public void createLionDifferentGenderRightHasMane() throws Exception {
        try {
            Lion lion = new Lion(gender, feline);
            Assert.assertEquals(hasManeExpected, lion.hasMane);
        } catch (Exception e) {
            Assert.assertEquals(ExceptionMessageExpected, e.getMessage());
        }
    }
}
