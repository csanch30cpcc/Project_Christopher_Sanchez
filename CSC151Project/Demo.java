import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads insurance policy information from PolicyInformation.txt, creates
 * Policy objects, and displays the policy details and smoker totals.
 */
public class Demo {

    /**
     * Reads all policy records from the input file, stores them in an
     * ArrayList, and displays each policy and the smoker/non-smoker totals.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<Policy>();
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            Scanner inputFile = new Scanner(new File("PolicyInformation.txt"));

            while (inputFile.hasNextLine()) {
                String policyNumberLine = inputFile.nextLine().trim();

                // Ignore blank lines between policy records.
                if (policyNumberLine.isEmpty()) {
                    continue;
                }

                int policyNumber = Integer.parseInt(policyNumberLine);
                String providerName = inputFile.nextLine().trim();
                String firstName = inputFile.nextLine().trim();
                String lastName = inputFile.nextLine().trim();
                int age = Integer.parseInt(inputFile.nextLine().trim());
                String smokingStatus = inputFile.nextLine().trim();
                double height = Double.parseDouble(inputFile.nextLine().trim());
                double weight = Double.parseDouble(inputFile.nextLine().trim());

                Policy policy = new Policy(policyNumber, providerName,
                        firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
            }

            inputFile.close();

            for (Policy policy : policies) {
                System.out.println();
                System.out.println("Policy Number: " + policy.getPolicyNumber());
                System.out.println();
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println();
                System.out.println("Policyholder's First Name: " + policy.getFirstName());
                System.out.println();
                System.out.println("Policyholder's Last Name: " + policy.getLastName());
                System.out.println();
                System.out.println("Policyholder's Age: " + policy.getAge());
                System.out.println();
                System.out.println("Policyholder's Smoking Status (smoker/non-smoker): "
                        + policy.getSmokingStatus());
                System.out.println();
                System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
                System.out.println();
                System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
                System.out.println();
                System.out.println("Policyholder's BMI: "
                        + twoPlaces.format(policy.calculateBMI()));
                System.out.println();
                System.out.println("Policy Price: $"
                        + twoPlaces.format(policy.calculatePolicyPrice()));
                System.out.println();

                if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else if (policy.getSmokingStatus().equalsIgnoreCase("non-smoker")) {
                    nonSmokerCount++;
                }
            }

            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println();
            System.out.println("The number of policies with a non-smoker is: "
                    + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt could not be found.");
            System.out.println("Place the file in the same folder as the Java source files.");
        } catch (NumberFormatException e) {
            System.out.println("Error: The policy information file contains an invalid number.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: A policy record in PolicyInformation.txt is incomplete.");
        }
    }
}
