package de.krauss;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import de.krauss.handler.OracleDataBase;

public class FileManager implements Serializable
{

	private static final long serialVersionUID = -7316598012514218303L;

//	public static final int DUMP_FILE = 1, JAXB_FILE = 2, TXT_FILE = 3, XSTREAM_FILE = 4, JSON_FILE = 5;

	/**
	 * Log4j logger
	 */

//	private DumpFileHandler dumpFileHandler;
//	private JAXBFileHandler jaxbFileHandler;
//	private TxtFileHandler txtFileHandler;
//	private XStreamFileHandler xStreamFileHandler;
//	private JSonFileHandler jSonFileHandler;
	private OracleDataBase orcb;
//	private ArrayList<FileHandler> handlerList;

//	/**
//	 * 
//	 * @param option Die Methode mit welcher eingelesen werden soll
//	 * @param f      Die Datei aus welcher eingelesen werden soll
//	 * @return Die eingelesene Arraylist
//	 */
//	public ArrayList<Car> load(int option, File f)
//	{
//		switch (option)
//		{
//		case DUMP_FILE:
//			return dumpFileHandler.load(f);
//
//		case JAXB_FILE:
//			return jaxbFileHandler.load(f);
//
//		case TXT_FILE:
//			return txtFileHandler.load(f);
//
//		case XSTREAM_FILE:
//			return xStreamFileHandler.load(f);
//		case JSON_FILE:
//			return jSonFileHandler.load(f);
//		default:
//			return null;
//		}
//	}

//	/**
//	 * 
//	 * @param cars   Die Instanz der Klasse in welcher die Arraylist gespeichert ist
//	 * @param option Mit welcher Methode die Arraylist gespeichert werden soll
//	 * @param l      Der Logger mit welchem man dem User antworten kann
//	 */
//	public void safe(CarList cars, int option, Logger l)
//	{
//		switch (option)
//		{
//		case DUMP_FILE:
//			dumpFileHandler.safe(cars, null);
//			break;
//		case JAXB_FILE:
//			jaxbFileHandler.safe(cars, null);
//			break;
//		case TXT_FILE:
//			txtFileHandler.safe(cars, null);
//			break;
//		case XSTREAM_FILE:
//			xStreamFileHandler.safe(cars, null);
//			break;
//		case JSON_FILE:
//			jSonFileHandler.safe(cars, null);
//			break;
//		default:
//			l.warn("Fahrzeuge speichern wurde abgebrochen");
//			return;
//		}
//	}

	/**
	 * Konstruktor zur Initalisierung der Handler
	 * 
	 * @param l Reader zum Lesen der Usereingaben
	 */
	public FileManager(Logger l)
	{
		orcb = new OracleDataBase(l);
//		handlerList = new ArrayList<>();
//
//		dumpFileHandler = new DumpFileHandler();
//		jaxbFileHandler = new JAXBFileHandler();
//		txtFileHandler = new TxtFileHandler();
//		xStreamFileHandler = new XStreamFileHandler();
//		jSonFileHandler = new JSonFileHandler();
//
//		handlerList.add(dumpFileHandler);
//		handlerList.add(jSonFileHandler);
//		handlerList.add(jaxbFileHandler);
//		handlerList.add(xStreamFileHandler);
//		handlerList.add(txtFileHandler);

	}

//	/**
//	 * 
//	 * @return Den Handler f�r Dumpfiles
//	 */
//	public DumpFileHandler getDumpFileHandler()
//	{
//		return dumpFileHandler;
//	}
//
//	/**
//	 * 
//	 * @return Den Handler f�r JAXB-Files
//	 */
//	public JAXBFileHandler getJaxbFileHandler()
//	{
//		return jaxbFileHandler;
//	}
//
//	/**
//	 * 
//	 * @return Den Handler f�r Txt-Files
//	 */
//	public TxtFileHandler getTxtFileHandler()
//	{
//		return txtFileHandler;
//	}
//
//	/**
//	 * 
//	 * @return Den Handler f�r XML-Files
//	 */
//	public XStreamFileHandler getxStreamFileHandler()
//	{
//		return xStreamFileHandler;
//	}

	/**
	 * F�gt ein Auto der Datenbank hinzu
	 * 
	 * @param car Auto welches in der Datenbank gespeichert werden soll
	 */
	public void safeCarToDB(Car car)
	{
		orcb.addCar(car);
	}

	/**
	 * L�dt alle Autos samt Reservierungen aus der Datenbank ein
	 * 
	 * @return Die Arraylist beinhaltet die Autos mit Reservierungen aus der
	 *         Datenbank
	 */
	public ArrayList<Car> loadDatabase()
	{
		return orcb.loadDatabase();
	}

	/**
	 * L�scht ein Auto samt Reservierungen aus der Datenbank
	 * 
	 * @param id Die ID des Autos welches gel�scht werden soll
	 * @return Ob das l�schen aus der Datembank erfolgreich war
	 */
	public boolean delDatabase(int id)
	{
		orcb.deleteCarFromDatabase(id);
		return true;
	}

	/**
	 * F�gt der Datenbank eine Reservierung hinzu
	 * 
	 * @param r Reservierung welche hinzugef�gt werden soll
	 * @return Ob das hochladen funktioniert hat
	 */
	public boolean uploadRes(Reservierung r)
	{
		orcb.uploadRes(r);
		return true;
	}

	/**
	 * L�scht eine Reservierung aus der Datenbank
	 * 
	 * @param del Die zu l�schende Reservierung
	 * @return Ob das L�schen funktioniert hat
	 */
	public boolean deleteReservierung(Reservierung del)
	{
		orcb.deleteReservierung(del);
		return true;
	}

}
