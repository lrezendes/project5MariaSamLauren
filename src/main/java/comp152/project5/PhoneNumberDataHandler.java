package comp152.project5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberDataHandler {
    private HttpClient dataGrabber;
    private String webLocation;
    private String codePhone;
    private String prefixPhone;
    private String codeNames;
    private String countryNames;

    public PhoneNumberDataHandler(String webLocation){
        dataGrabber=HttpClient.newHttpClient();
        this.webLocation=webLocation;
    }

    public HashMap <String, String>getPhoneDataNames(){
        var httpBuilder= HttpRequest.newBuilder();
        var dataRequest=httpBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response=null;                                             //var isnt used bcuz you cannot assign a null value to var
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString()); //treats the bit of data returned as string
        }
        catch (IOException exception) {
            System.out.println("Error in network");
        }
        catch (InterruptedException e) {
            System.out.println("Error in data transfer");
        }
        if (response==null){
            System.out.println("HttpResponse response is null, exiting");
            System.exit(-1);
        }
        var responseBody=response.body();
        var gsonInterpreter=new Gson();
        var phoneDataNames=gsonInterpreter.fromJson(responseBody, HashMap.class);
        return phoneDataNames;
    }
    public HashMap<String, String> getPhoneDataPhone(){
        var httpBuilder=HttpRequest.newBuilder();
        var dataRequest=httpBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String>response=null;
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString()); //treats the bit of data returned as string
        }
        catch (IOException exception) {
            System.out.println("Error in network");
        }
        catch (InterruptedException e) {
            System.out.println("Error in data transfer");
        }
        if (response==null){
            System.out.println("HttpResponse response is null, exiting");
            System.exit(-1);
        }
        var responceBody=response.body();
        var gsonInterpreter=new Gson();
        var phoneDataPhone=gsonInterpreter.fromJson(responceBody, HashMap.class);
        return phoneDataPhone;

    }

}

