public class AddClass {
    private String className;
    private int creditHours;

    public AddClass(String className, int creditHours) {
        this.className = className;
        this.creditHours = creditHours;
    }
    public String getClassName() {
        return className;
    }

    public int getCreditHours() {
        return creditHours;
    }
}
