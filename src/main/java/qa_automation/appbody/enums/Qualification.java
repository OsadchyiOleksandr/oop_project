package qa_automation.appbody.enums;

/**
 * Enum with levels of Qualification
 */

public enum Qualification {
    DEFAULT("Not defined"),
    LOW("1-3 years"),
    MIDDLE("3-5 years"),
    HIGHT("5 ond more years");

    private String qalification;

    Qualification(String qalification) {
        // Constructor
        this.qalification = qalification;
    }

    public String getQualification() {
        // Getter
        return qalification;
    }
}