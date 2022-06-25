package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.print.attribute.standard.PrinterName;

import entities.Employee;

public class Program {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		String email = null;
		Double salary = null;
		Double sum = 0.00;
		
			Map<Employee, String> empregados = new TreeMap<>();

		System.out.print("Enter full file path: ");
		String link = sc.next();
		System.out.print("Enter salary: ");
		Double sal = sc.nextDouble();

		try {
			BufferedReader br = new BufferedReader(new FileReader(link));
			

			
			String line = br.readLine();			
			
			while (line != null) {
				
				String[] vect = line.split(",");
				name = vect[0];
				email = vect[1];
				salary = Double.parseDouble(vect[2]);
				
				if(name.charAt(0) == 'M') {
					sum += salary;
				}
				
				if(Double.parseDouble(vect[2]) >= sal) {
					

					Employee emp = new Employee(name, email, salary);
				
					empregados.put(emp, null);
				}
				
				line = br.readLine();	
				
			}

			System.out.println();
			
			for (Employee key : empregados.keySet()) {
				System.out.println(key.getEmail());
			}
			System.out.println("Sum of salary of people whose name starts with 'M': " +sum);

		} catch (Exception e) {
			System.out.println("Message: " + e.getMessage());

		}

	}

}
