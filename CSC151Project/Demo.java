import java.util.Scanner;
import java.text.DecimalFormat;

public class Demo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");

        System.out.print("Please enter the Policy Number: ");
        int policyNumber = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String providerName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = keyboard.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double height = keyboard.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weight = keyboard.nextDouble();

        Policy policy = new Policy(policyNumber, providerName, firstName,
                                   lastName, age, smokingStatus, height, weight);

        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder’s Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + policy.getWeight() + " pounds");
        System.out.println("Policyholder’s BMI: " + twoPlaces.format(policy.calculateBMI()));
        System.out.println("Policy Price: $" + twoPlaces.format(policy.calculatePolicyPrice()));

        keyboard.close();
    }
}
