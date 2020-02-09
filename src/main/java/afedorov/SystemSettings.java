package afedorov;

public class SystemSettings {

    private static int sumPassTwoExam = 17;
    private static double sumPassOneExam = 6.5;
    private static int countPassedCredit = 4;

    public static int getSumPassTwoExam() {
        return sumPassTwoExam;
    }

    public static void setSumPassTwoExam(int sumPassTwoExam) {
        SystemSettings.sumPassTwoExam = sumPassTwoExam;
    }

    public static double getSumPassOneExam() {
        return sumPassOneExam;
    }

    public static void setSumPassOneExam(double sumPassOneExam) {
        SystemSettings.sumPassOneExam = sumPassOneExam;
    }

    public static int getCountPassedCredit() {
        return countPassedCredit;
    }
}
