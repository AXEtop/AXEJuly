package listener;

public enum TestFeature {

    SMOKE("Smoke"),
    REGRESSION("Regression"),
    FACTORY("FACTORY");

    private String suite;

    public String getSuiteName() {
        return suite;
    }

    TestFeature(String suiteName) {
        this.suite = suiteName;
    }
}
