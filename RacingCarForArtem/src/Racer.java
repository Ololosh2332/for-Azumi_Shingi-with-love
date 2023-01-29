public class Racer {
    String name;
    int racerId;
    int age;
    double luck;
    double preparation;
    double personalProblems;
    boolean live = true;
    String car;

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

    public static String getCar (String name, String car){
        return "Машина гонщика "+name+" это "+car;
    }
    public void setCar (int car){
        if (car==1){
            this.car = "BMW";
        }
        if (car==2){
            this.car = "Subaru";
        }
        if (car==3){
            this.car="Ford";
        }
        if (car==4){
            this.car="Ferrari";
        }
    }
    public static double ringTime (double luck, double preparation, double personalProblem, String car){
        double ringTime = luck*preparation*personalProblem+60.00*Math.random();
        if (car.equals("BMW")){
            ringTime = ringTime*0.97;
        }
        if (car.equals("Subaru")){
            ringTime = ringTime*0.92;
        }
        if (car.equals("Ford")){
            ringTime = ringTime*1.1;
        }
        if (car.equals("Ferrari")){
            ringTime = ringTime*0.85;
        }

        return ringTime;
    }
}
