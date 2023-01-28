import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество гонщиков:");
        int countRacer = sc.nextInt();
        ArrayList<Racer>racerList=new ArrayList<>();

        for (int i = 0; i<countRacer; i++){
            int racerId = i+1;
            System.out.println("Введите имя гонщика: ");
            String name = sc.next();
            System.out.println("Введите возраст гонщика: ");
            int age = sc.nextInt();
            Racer racer = new Racer (racerId, name, age);
            racerList.add(racer);
            System.out.println("Добавлена информация о гонщике: ");
            System.out.println("id гонщика "+racerList.get(i).speakId(racerId)+"\nИмя гонщика "+racerList.get(i).speakName(name)+"\nВозраст гонщика "+racerList.get(i).speakAge(age)+"\n\n");
        }

        for (int i = 0; i<countRacer; i++){
            racerList.get(i).setPreparation(racerList.get(i).age);
            racerList.get(i).personalProblems(racerList.get(i).age);
            racerList.get(i).luckCalc(racerList.get(i).age, racerList.get(i).preparation, racerList.get(i).personalProblems);
        }
        for (int i = 0; i<racerList.size(); i++){
            System.out.println(racerList.get(i).speakId(racerList.get(i).racerId));
            System.out.println(racerList.get(i).speakName(racerList.get(i).name));
            System.out.println(racerList.get(i).speakAge(racerList.get(i).age));
        }
        System.out.println("Введите количество кругов: ");
        int r = sc.nextInt();
        for (int i = 0; i<countRacer; i++){
            for (int j = 1; j<=r; j++){
                double rt = ringTime(racerList.get(i).luck, racerList.get(i).preparation, racerList.get(i).personalProblems);
                System.out.println("Круг "+j+" для гонщика "+racerList.get(i).speakName(racerList.get(i).name));
                System.out.println("\nРезультат круга равен "+rt);
                racerList.get(i).setTotalTime(rt);
            }
        }
        System.out.println("\n\n");
        for (int i=0; i<countRacer; i++){
            racerList.get(i).getTotalTime(racerList.get(i).totalTime, racerList.get(i).name);
        }
    }

    public static double ringTime (double luck, double preparation, double personalProblem){
        double ringTime = luck*preparation*personalProblem+60.00*Math.random();
        return ringTime;
    }
}