public class Car {
	//OOP Concept: Abstraction
		//protect data by making 

	private String model;
	private float price, miles;
	private int model_year, vin;
	private boolean is_used;

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getMiles() {
		return this.miles;
	}

	public void setMiles(float miles) {
		this.miles = miles;
	}

	public int getModelYear() {
		return this.model_year;
	}

	public void setModelYear(int model_year) {
		this.model_year = model_year;
	}

	public int getVin() {
		return this.vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public boolean isUsed() {
		return this.is_used;
	}

	public void setIsUsed(boolean is_used) {
		this.is_used = is_used;
	}

}