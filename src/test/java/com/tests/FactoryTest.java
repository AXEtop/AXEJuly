package com.tests;

import io.qameta.allure.Step;
import io.qameta.allure.testng.TestInstanceParameter;
import listener.TestSuites;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;

import static listener.TestFeature.FACTORY;

@Log4j2
@TestSuites(FACTORY)
public class FactoryTest extends AbstractApiTest {

    @TestInstanceParameter("Iteration")
    public String iterationName;

    private final String text;

    @Factory(dataProvider = "dp")
    public FactoryTest(String test) {
        iterationName = test;
        log.debug("FACTORY TEST -   " + test);
        this.text = test;
    }

    @DataProvider(name = "dp")
    public static Object[][] dataProvider() {
        return new Object[][]{ {"one"}, {"two"}, {"three"} };
    }

    @BeforeClass
    public void beforeClass() {

    }

    @BeforeMethod
    public void BeforeMethod() {

    }

    @Test
    public void testing() {
        doSmth(text);
    }

    @Step("Stepping {0}")
    private void doSmth(String text) {

    }

}
