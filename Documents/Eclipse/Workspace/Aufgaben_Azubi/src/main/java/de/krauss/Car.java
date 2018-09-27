package de.krauss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Car implements Serializable
{

	/**
	 * Log4j logger
	 */
	private static final long serialVersionUID = 1257287804168043133L;
	private String f_Name;
	private String f_Marke;
	private int CAR_ID;
	private int f_Tacho;
	@XmlElement(name = "Reservierungen")
	private ArrayList<Reservierung> resv;

	/**
	 * Konstruktor zur Initalisierung der Arraylist f�r Reservierungen
	 */
	public Car()
	{
		resv = new ArrayList<Reservierung>();
	}

	/**
	 * 
	 * @return Gibt den Namen des Fahrzeuges zur�ck
	 */
	public String getF_Name()
	{
		return f_Name;
	}

	/**
	 * 
	 * @param f_Name Setzt den Namen des Fahrzeuges
	 */
	public void setF_Name(String f_Name)
	{
		this.f_Name = f_Name;
	}

	/**
	 * 
	 * @return Gibt die Marke des Fahrzeuges zur�ck
	 */
	public String getF_Marke()
	{
		return f_Marke;
	}

	/**
	 * 
	 * @param f_Marke Setzt die Marke des Fahrzeuges
	 */
	public void setF_Marke(String f_Marke)
	{
		this.f_Marke = f_Marke;
	}

	/**
	 * 
	 * @return Gibt den Tachostand des Fahrzeuges zur�ck
	 */
	public int getF_Tacho()
	{
		return f_Tacho;
	}

	/**
	 * 
	 * @param f_Tacho Setzt den Tachostamd des Fahrzeuges
	 */
	public void setF_Tacho(int f_Tacho)
	{
		this.f_Tacho = f_Tacho;
	}

	/**
	 * 
	 * @param r F�gt der Reservierungs-Arraylist eine Reservierung hinzu
	 */
	public void addResv(Reservierung r)
	{
		resv.add(r);
	}

	/**
	 * 
	 * @param f Datum welches �berpr�ft werden soll
	 * @return Gibt true zur�ck falls das Fahrzeug zu der Zeit reserviert ist
	 */
	public boolean isReservedOn(Date f)
	{
		for (Reservierung r : resv)
		{
			if (r.isReserved(f))
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Gibt die Liste mit Reservierungen f�r das Auto zur�ck
	 * 
	 * @return Liste mit Reservierungen
	 */
	public ArrayList<Reservierung> getReservs()
	{
		return resv;
	}

	/**
	 * 
	 * @return ID des Autos
	 */
	public int getCAR_ID()
	{
		return CAR_ID;
	}

	/**
	 * 
	 * @param cAR_ID Setzt ID des Atuos
	 */
	public void setCAR_ID(int cAR_ID)
	{
		CAR_ID = cAR_ID;
	}

}
