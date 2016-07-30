package client;

import java.util.Scanner;

import exception.AutoException;
import model.Automotive;

public class SelectCarOption {
	public void makeChoice(Automotive auto) throws AutoException{
		Scanner sc = new Scanner(System.in);
		auto.printAutomotive();
		System.out.print("Please input the option set to modify:");
		String optionSetName = sc.nextLine();
		auto.printOptionSet(optionSetName);
		System.out.print("Please input the option you want:");
		String optionName = sc.nextLine();
		auto.setOptionChoice(optionSetName, optionName);
		auto.printChoices();
	}
}
