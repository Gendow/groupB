package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class MapApplet extends PApplet {
	public static SimplePointMarker marker;
	static UnfoldingMap map;

	public void setup() {
		size(960, 800);
		
		map = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());

	    map.zoomAndPanTo(12, new Location(51.930, 5.660));
	        
	    MapUtils.createDefaultEventDispatcher(this, map);
	}
	 
	public void draw() {
		size(960, 800);
			
		map.draw();	
	}
			
		// HTTP GET request
		public static void sendGet() throws Exception {
		 
			String url = "https://maps.googleapis.com/maps/api/geocode/json?address={Haarweg+333+Wageningen}";
		 
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 
			// optional default is GET
			con.setRequestMethod("GET");
		 
			int responseCode = con.getResponseCode();
			
			BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
				
			// read from the URL
			Scanner scan = new Scanner(obj.openStream());
			String str = new String();
			while (scan.hasNext())
			    str += scan.nextLine();
			scan.close();
				
			JSONObject location = new JSONObject(str);
			double lat = location.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lat");
			double lng = location.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lng");
				
			Location haarwegWageningen = new Location(lat, lng);
			marker = new SimplePointMarker(haarwegWageningen);
			
			map.addMarker(marker);		
		}			
}
