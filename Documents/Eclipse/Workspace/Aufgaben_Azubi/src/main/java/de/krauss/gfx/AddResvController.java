package de.krauss.gfx;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JOptionPane;

import de.krauss.Reservierung;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddResvController
{
	@FXML
	private DatePicker date_Start, date_Stop;

	@FXML
	private TextField textf_Stop, txtf_Start;

	@FXML
	private Label lbl_Resviert;

	@FXML
	private Button btn_Add;

	private Reservierung resv;

	/**
	 * F�gt dem Button einen Listener hinzu
	 * 
	 * @param main Gibt den MainFrameController mit, so dass man auf die Methoden
	 *             aus diesem zugreifen kann
	 */
	public void addButtonListener(MainFrameController main)
	{
		btn_Add.setOnAction(new EventHandler<ActionEvent>()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void handle(ActionEvent event)
			{
				LocalDate local_Start = date_Start.getValue();
				LocalDate local_Stop = date_Stop.getValue();

				String txtFromStart = txtf_Start.getText();
				String txtFromStop = textf_Stop.getText();

				int start_Hours = 0;
				int start_Minutes = 0;

				int stop_Hours = 0;
				int stop_Minutes = 0;

				if (txtFromStart.equals("") || !txtFromStart.contains(":") || txtFromStop.equals("")
						|| !txtFromStop.contains(":") || local_Start == null || local_Stop == null)
				{
					showErrorPane();
					return;
				}

				String[] txtSplitedStart = txtFromStart.split(":");

				String[] txtSplitedStop = txtFromStop.split(":");

				try
				{
					start_Hours = Integer.parseInt(txtSplitedStart[0]);
					if (start_Hours < 0 || start_Hours > 23)
					{
						showErrorPane();
						return;
					}

					start_Minutes = Integer.parseInt(txtSplitedStart[1]);
					if (start_Minutes < 0 || start_Minutes > 59)
					{
						showErrorPane();
						return;
					}

					stop_Hours = Integer.parseInt(txtSplitedStop[0]);
					if (stop_Hours < 0 || stop_Hours > 23)
					{
						showErrorPane();
						return;
					}

					stop_Minutes = Integer.parseInt(txtSplitedStop[1]);
					if (stop_Minutes < 0 || stop_Minutes > 59)
					{
						showErrorPane();
						return;
					}

				} catch (NumberFormatException e)
				{
					showErrorPane();
					return;
				}

				Instant insta_Start = Instant.from(local_Start.atStartOfDay(ZoneId.systemDefault()));
				Date start_Date = Date.from(insta_Start);
				start_Date.setHours(start_Hours);
				start_Date.setMinutes(start_Minutes);

				Instant insta_Stop = Instant.from(local_Stop.atStartOfDay(ZoneId.systemDefault()));
				Date stop_Date = Date.from(insta_Stop);
				stop_Date.setHours(stop_Hours);
				stop_Date.setMinutes(stop_Minutes);

				resv = new Reservierung(start_Date, stop_Date);

				if (main.isSelectCarAvaible(start_Date, stop_Date))
				{
					main.addReservierungToSelCar(resv);
					((Node) (event.getSource())).getScene().getWindow().hide();
				} else
				{
					lbl_Resviert.setVisible(true);
					new Thread(new Runnable()
					{
						@Override
						public void run()
						{
							try
							{
								Thread.sleep(2000);
							} catch (InterruptedException e)
							{
								e.printStackTrace();
							}
							lbl_Resviert.setVisible(false);
						}
					}).start();
				}
				return;
			}
		});

	}

	// Zeigt die Fehlermeldung an, dass die eingebene Zeit ung�ltig ist
	private void showErrorPane()
	{
		JOptionPane.showMessageDialog(null, "Bitte die Zeit g�ltig eingeben!", "Warnung", JOptionPane.WARNING_MESSAGE);
	}

}
