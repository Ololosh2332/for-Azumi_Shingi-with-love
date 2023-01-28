public class Racer {
    String name;
    int racerId;
    int age;
    double luck;
    double preparation;
    double personalProblems;
    boolean live = true;

    double totalTime;

    public Racer (int racerId, String name, int age){
        this.racerId = racerId;
        this.name = name;
        this.age = age;
    }
    public String speakName (String name){
        return name;
    }
    public int speakAge (int age){
        return age;
    }
    public int speakId (int racerId){ return racerId; }

    public double setPreparation (int age) { return age*0.8; }

    public double personalProblems(int age){
        return age*1.5;
    }

    public double luckCalc (int age, double preparation, double personalProblems){
        return this.luck=age*preparation*personalProblems*Math.random();
    }

    public double setTotalTime (double ringTime){
        return this.totalTime+=ringTime;
    }
    public static void getTotalTime (double totalTime, String name){
        System.out.println("общее время гонщика "+name+": "+totalTime);
    }
}
