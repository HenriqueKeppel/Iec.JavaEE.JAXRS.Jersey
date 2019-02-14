package com.javaee.keppel.jax_rs_jersey.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import com.javaee.keppel.jax_rs_jersey.domain.Vehicle;

public class VehicleServiceImpl implements VehicleService
{
	private List<Vehicle> vehicles = new ArrayList();
	private Integer actualId = 0;
	
	public VehicleServiceImpl()
	{
		for (int i = 0; i < 10; i++)
		{
			Vehicle vehicle = new Vehicle();
			vehicle.setId(i);
			vehicle.setName("Subaru" + i);
			vehicle.setYear(2018);
			vehicles.add(vehicle);
		}
	}
	
	public List<Vehicle> getAll()
	{
		return vehicles;
	}
	
	public Vehicle findById(Integer id)
	{
		//Optional<Vehicle> vehicleOptional = vehicles.stream()
		//.filter(vehicle -> vehicle.getId().equals(id)).findFirst();

		//return vehicleOptional.orElse(null);
		
		// lambda não funcionou		
		Vehicle vehicleOptional = null;
		
		for(int i = 0; i < vehicles.size(); i++)
		{
			if (vehicles.get(i).getId() == id)
				vehicleOptional = vehicles.get(i);
		}		
		return vehicleOptional;
	}
		
	public Vehicle saveVehicle(Vehicle vehicle)
	{
		if (vehicle.getId() != null)
			this.deleteById(vehicle.getId());
		else
		{
			actualId++;
			vehicle.setId(actualId);			
		}
		
		this.vehicles.add(vehicle);
		return vehicle;			
	}
	
	public void deleteById(Integer id)
	{
		// lambda não funcionou
		//this.vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
		// lambda não funcionou		
		
		for(int i = 0; i < vehicles.size(); i++)
		{
			if (vehicles.get(i).getId() == id)
				vehicles.remove(i);
		}		
	}

}
