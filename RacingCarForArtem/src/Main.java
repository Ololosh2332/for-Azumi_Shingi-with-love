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
            System.out.println("Выберете машину Гонщика: \n1 - BMW\n2 - Subaru\n3 - Ford\n4 - Ferrari");
            racerList.get(i).setCar(sc.nextInt());
            System.out.println("Добавлена информация о гонщике: ");
            System.out.println("id гонщика "+racerList.get(i).speakId(racerId)+"\nИмя гонщика "+racerList.get(i).speakName(name)+"\nВозраст гонщика "+racerList.get(i).speakAge(age)+"\n"+racerList.get(i).getCar(racerList.get(i).name, racerList.get(i).car)+"\n");
        }

        for (int i = 0; i<countRacer; i++){
            racerList.get(i).setPreparation(racerList.get(i).age);
            racerList.get(i).personalProblems(racerList.get(i).age);
            racerList.get(i).luckCalc(racerList.get(i).age, racerList.get(i).preparation, racerList.get(i).personalProblems);
        }
       /* for (int i = 0; i<racerList.size(); i++){
            System.out.println(racerList.get(i).speakId(racerList.get(i).racerId));
            System.out.println(racerList.get(i).speakName(racerList.get(i).name));
            System.out.println(racerList.get(i).speakAge(racerList.get(i).age));
        } */
        System.out.println("Введите количество кругов: ");
        int r = sc.nextInt();
        for (int i = 0; i<countRacer; i++){
            for (int j = 1; j<=r; j++){
                double rt = Racer.ringTime(racerList.get(i).luck, racerList.get(i).preparation, racerList.get(i).personalProblems, racerList.get(i).car);
                System.out.println("Круг "+j+" для гонщика "+racerList.get(i).speakName(racerList.get(i).name));
                System.out.println(". Результат круга равен "+rt);
                racerList.get(i).setTotalTime(rt);
            }
        }
        System.out.println("\n");
        for (int i=0; i<countRacer; i++){
            racerList.get(i).getTotalTime(racerList.get(i).totalTime, racerList.get(i).name);
        }
        double forWinnerTime = racerList.get(0).totalTime;
        String winnerName = racerList.get(0).name;
        for (int i = 1; i<countRacer; i++){
            if (racerList.get(i).totalTime<forWinnerTime){
                forWinnerTime=racerList.get(i).totalTime;
                winnerName = racerList.get(i).name;
            }
        }
        System.out.println("\n*****\nПобедителем становится "+winnerName+"\nЕго время: "+forWinnerTime);
    }

}