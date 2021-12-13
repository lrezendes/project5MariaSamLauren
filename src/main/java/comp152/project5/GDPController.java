/* Maria Barczuk
 * Bridgewater State University
 * COMP 152-001: Computer Science II F21
 * Dr. John F. Santore
 * Fall 2021
 * Project 5
 * Currently Due on December 12th, 2021 @ 11:59 P.M.
 */

// Java Package:
package comp152.project5;

// Java Import Statement(s):
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

// Public 'GDPController' Class that Implements Initializable:
public class GDPController implements Initializable {

    // Private 'Year' TextField Variable to Represent the GDP Data's 'date' Value:
    @FXML
    private TextField Year;

    // Private 'CountryName' TextField Variable to Represent the GDP Data's 'countryiso3code' Value:
    @FXML
    private TextField CountryName;

    // Private 'GDPData' TextField Variable to Represent the GDP Data's 'value':
    @FXML
    private TextField GDPData;

    // Private 'List Control' ListView Variable to Represent GDP Values (Such as 'year', 'countryiso3code', and 'value' Values):
    @FXML
    private ListView<GDPDataHandler.GDPDataType> GDPListControl;

    // Private 'GDPModel' Variable to Represent the 'GDPDataHandler' Class's Data:
    private GDPDataHandler GDPModel;

    // Public 'loadDataUSA' Method:
    public void loadDataUSA() {

        // Creating 'siteUSA' to Represent the URL Containing GDP Data from the USA:
        var siteUSA = "http://api.worldbank.org/v2/countries/USA/indicators/NY.GDP.MKTP.CD?per_page=5000&format=json";

        // Creating 'paramsUSA' to Obtain Possible Query Parameters for 'siteUSA':
        var paramsUSA = getQueryParams();

        // Creating 'queryUSA' to Gather URL Query by Adding 'siteUSA' and 'paramsUSA':
        var queryUSA = siteUSA + paramsUSA;

        GDPModel = new GDPDataHandler(queryUSA);

        // Creating 'listDataUSA' to Use the 'GDPModel' to Obtain Data:
        var listDataUSA = GDPModel.getData();

        // Creating 'displayDataUSA' to Display 'listDataUSA' Value:
        ObservableList<GDPDataHandler.GDPDataType> displayDataUSA = FXCollections.observableArrayList(listDataUSA);

        // Using 'GDPListControl' to Add GDP Values (from GDPDataType) to 'displayDataUSA' Variable:
        GDPListControl.setItems(displayDataUSA);

    }

}