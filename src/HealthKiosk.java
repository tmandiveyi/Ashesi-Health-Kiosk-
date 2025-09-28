import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter service code(P/T/L/C): ");
        char service = input.next().toUpperCase().charAt(0);

        switch (service) {
            case 'P':
                System.out.println("Go to Pharmacy Desk!");
                break;
            case 'T':
                System.out.println("Go to Triage Desk!");
                break;
            case 'L':
                System.out.println("Go to Lab Desk!");
                break;
            case 'C':
                System.out.println("Go to Counselling Desk!");
                break;
            default:
                System.out.println("Invalid service code!");
                break;
        }
        System.out.println("Enter health metric(1 for BMI, 2 for Dosage round-up, 3 for simple trig helper): ");
        int healthMetric = input.nextInt();

        double bmi = 0;
        switch (healthMetric) {
            case 1:
                System.out.println("Enter weight(kgs): ");
                double weight = input.nextDouble();
                System.out.println("Enter height(metres): ");
                double height = input.nextDouble();

                bmi = weight / (height * height);

                String category;

                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 25.0) {
                    category = "Normal";
                } else if (bmi < 30.0) {
                    category = "Overweight";
                } else {
                    category = "Obese";
                }

                System.out.println("BMI: " + Math.round(bmi * 10.0) / 10.0 + "  Category: " + category);


            case 2:

                System.out.println("Enter the dosage required: ");
                double dosage = input.nextDouble();
                int tablets = (int) Math.ceil(dosage / 250.0);
                System.out.println("Number of tablets: " + tablets);
                break;

            case 3:
                System.out.print("Enter the angle (degrees): ");
                double angle = input.nextDouble();

                double radians = Math.toRadians(angle);

                double sinVal = Math.round(Math.sin(radians) * 1000) / 1000.0;
                double cosVal = Math.round(Math.cos(radians) * 1000) / 1000.0;

                System.out.println("sin(" + angle + "°) = " + sinVal);
                System.out.println("cos(" + angle + "°) = " + cosVal);
                break;

        }

        //Task 3
        int letterNumber = (int) (Math.random() * 26);
        char randomChar = (char) ('A' + letterNumber);

        int numOne = 3 + (int) (Math.random() * 7);
        int numTwo = 3 + (int) (Math.random() * 7);
        int numThree = 3 + (int) (Math.random() * 7);
        int numFour = 3 + (int) (Math.random() * 7);

        String shortID = "" + randomChar + numOne + numTwo + numThree + numFour;
        System.out.println("Generated ID: " + shortID);

        if (shortID.length() != 5) {
            System.out.println("Invalid length");
        } else if (!Character.isLetter(shortID.charAt(0))) {
            System.out.println("Invalid: first char must be a letter.");
        } else if (!(Character.isDigit(shortID.charAt(1)) &&
                Character.isDigit(shortID.charAt(2)) &&
                Character.isDigit(shortID.charAt(3)) &&
                Character.isDigit(shortID.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("ID OK");
        }

        // Task 4
        System.out.print("Enter your name: ");
        char name = input.next().toUpperCase().charAt(0);

        int shift = 2;
        char base = 'A';
        char shifted = (char) (base + (name - base + shift) % 26);
        String lastTwo = shortID.substring(shortID.length() - 2);

        String finalCode = shifted + lastTwo + "-" + Math.round(bmi);
        System.out.println("Display Code: " + finalCode);

        System.out.println(" ");
        System.out.println("Your unique health code is generated as follows: ");

        if (service=='P') {
            System.out.println("Summary: PHARMACY || ID="+shortID+" || Code="+finalCode);
        } else if (service=='T') {
            System.out.println("Summary: TRIAGE || ID="+shortID+" || BMI="+Math.round(bmi * 10.0) / 10.0+" || Code="+finalCode);
        } else if (service=='L') {
            System.out.println("Summary: LAB || ID="+shortID+" || Code="+finalCode);
        } else if (service=='C') {
            System.out.println("Summary: COUNSELLING || ID="+shortID+" || Code="+finalCode);
        }

        input.close();



    }
}
