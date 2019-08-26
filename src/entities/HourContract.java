package entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private double valuePerHour;
	private int hours;

	public HourContract() {
	}

	/**
	 * @param date
	 * @param valuePerHour
	 * @param hours
	 */
	public HourContract(Date date, double valuePerHour, int hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the valuePerHour
	 */
	public double getValuePerHour() {
		return valuePerHour;
	}

	/**
	 * @param valuePerHour the valuePerHour to set
	 */
	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	public double totalValue() {
		return (hours * valuePerHour);
	}

}
