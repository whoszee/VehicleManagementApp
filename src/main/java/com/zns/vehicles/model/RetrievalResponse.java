package com.zns.vehicles.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class RetrievalResponse {

	ArrayList<Car> car;
	ArrayList<Motorcycle> moto;
	ArrayList<Truck> truck;
	
	public List<Car> getCar() {
		return car;
	}
	public void setCar(ArrayList<Car> car) {
		this.car = car;
	}
	public ArrayList<Motorcycle> getMoto() {
		return moto;
	}
	public void setMoto(ArrayList<Motorcycle> moto) {
		this.moto = moto;
	}
	public ArrayList<Truck> getTruck() {
		return truck;
	}
	public void setTruck(ArrayList<Truck> truck) {
		this.truck = truck;
	}
	
	@Override
	public String toString() {
		return "RetrievalResponse [car=" + car + ", moto=" + moto + ", truck=" + truck + "]";
	}
}
