package listener;

import lombok.extern.log4j.Log4j2;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Log4j2
public class TestFilterListener implements IMethodInterceptor {

    private static String suiteName = System.getProperty("suite");
    private static List<IMethodInstance> list = new ArrayList<>();

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        if (Objects.isNull(suiteName))
            return methods;

        for (IMethodInstance method : methods) {
            if (method.getInstance().getClass().isAnnotationPresent(TestSuites.class)) {
                filterTestSuite(method);
            }
        }
        return list;
    }

    private void filterTestSuite(IMethodInstance method) {
        if (method.getInstance().getClass().isAnnotationPresent(TestSuites.class)) {
            TestFeature[] values = method.getInstance().getClass().getAnnotation(TestSuites.class).value();

            if (Arrays.stream(values).anyMatch(s -> suiteName.equalsIgnoreCase(s.getSuiteName()))) {
                log.debug("ADDING " + suiteName + " -   " + method.getMethod().getMethodName());
                list.add(method);
            }

        }
    }

}
