import java.util.Scanner;

public class PRODIGY_SD_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter original unit (Celsius, Fahrenheit, Kelvin): ");
        String originalUnit = scanner.next().toLowerCase();

        double celsius = 0, fahrenheit = 0, kelvin = 0;

        switch (originalUnit) {
            case "celsius":
                celsius = temperature;
                fahrenheit = celsiusToFahrenheit(celsius);
                kelvin = celsiusToKelvin(celsius);
                break;
            case "fahrenheit":
                fahrenheit = temperature;
                celsius = fahrenheitToCelsius(fahrenheit);
                kelvin = celsiusToKelvin(celsius);
                break;
            case "kelvin":
                kelvin = temperature;
                celsius = kelvinToCelsius(kelvin);
                fahrenheit = celsiusToFahrenheit(celsius);
                break;
            default:
                System.out.println("Invalid original unit.");
                System.exit(1);
        }

        System.out.println("Converted Temperatures:");
        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
