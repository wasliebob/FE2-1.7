package forestryextras.helpers.util;

public class EnergyHelper {

	public static int calculateEnergyStorage(int machineLevel)
	{
		switch(machineLevel)
		{
		case 0: return 0;
		case 1: return 10*100;
		case 2: return 100*100;
		case 3: return 1000*100;
		case 4: return 10000*100;
		default: return 0;
		}
	}
	
	public static int calculateEnergyOutput(int machineLevel)
	{
		return calculateEnergyStorage(machineLevel)/100;
	}
}