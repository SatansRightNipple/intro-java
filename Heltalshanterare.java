import java.util.*;

public class Heltalshanterare { //tar in ett angivet antal heltal och beräknar snittet av dem och printar det
    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);
        Boolean found;
        String antal;
        found = false;

        do{
            System.out.print("Hur många heltal vill du ange? ");
            antal = in.nextLine();
            found = numCheck(antal);
            if (found) {
                if (Integer.parseInt(antal) < 1) {
                    System.out.println("Det måste vara större än 0.");
                    found = false;
                }
            }
        }while(!found);

        String heltal;
        int sum;
        int amountSingle;
        Map<String, Integer> numbers = new HashMap<>();

        amountSingle = 0;
        sum = 0;
 
        for(int i = 0; i < Integer.parseInt(antal); i++){
            found = false;
            do{
                System.out.print("Skriv in ett heltal: ");
                heltal = in.next();
                found = numCheck(heltal);
            }while(!found);

            if (numbers.get(heltal) == null) { //om talet inte redan är sparat i hashmapen så adderar jag 1 till amountSingle som är antalet tal som angets 1 gång
                amountSingle++;
                numbers.put(heltal,1);
            } else if(numbers.get(heltal) == 1){ //skulle hashmapen returnera 1 tar jag bort en på amountSingle och andrär hashmap värdet till 2 för att undvika att dra bort en till på amountSingle om man skrev in talet igen.
                amountSingle--;
                numbers.put(heltal,2);
            }

            sum = sum + Integer.parseInt(heltal);
        }
        System.out.println("Du angav " + antal + " heltal varav " + amountSingle + " av talen 1 gång endast.");
        meanValue(sum,Integer.parseInt(antal));
    }

    public static boolean numCheck(String input) { //kollar så inputen är en integer, returnerar true och false
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Ogiltligt heltal");
            return false;
        }
    }

    public static void meanValue(int sum, int antal) { //srkiver ut snittet av en summa och antalet element du tar snittet av
        long mean = Math.round(sum/antal);
        System.out.println("Medelvärdet av dina tal är: " + mean);
    }
}