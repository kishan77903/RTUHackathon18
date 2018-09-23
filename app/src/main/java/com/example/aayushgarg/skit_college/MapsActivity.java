package com.example.aayushgarg.skit_college;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

private Button button;
    private ProgressDialog progressBar;
    private GoogleMap mMap;
    private GoogleApiClient client;
    private Location lastlocation;
    private Marker currentLocationmMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    int PROXIMITY_RADIUS = 1000;
    double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
   progressBar=new ProgressDialog(this);
   button=(Button)findViewById(R.id.garg789);

   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
         if(!button.getText().equals("Search")) {

             startActivity(new Intent(MapsActivity.this, fetur.class));
         }
         else {

             progressBar.show();
             EditText tf_location = findViewById(R.id.TF_location1234);
             String location = tf_location.getText().toString();
             List<Address> addressList;


             if (!location.equals("")) {
                 Geocoder geocoder = new Geocoder(MapsActivity.this);

                 try {
                     addressList = geocoder.getFromLocationName(location, 5);

                     if (addressList != null) {
                         for (int i = 0; i < addressList.size(); i++) {
                             LatLng latLng = new LatLng(addressList.get(i).getLatitude(), addressList.get(i).getLongitude());
                             MarkerOptions markerOptions = new MarkerOptions();
                             markerOptions.position(latLng);
                             markerOptions.title(location);
                             mMap.addMarker(markerOptions);
                             mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                             mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                             latitude = addressList.get(i).getLatitude();
                             longitude = addressList.get(i).getLongitude();
                             progressBar.dismiss();
                             button.setText("Next..");
                         }
                         DataClass instance =DataClass.getInstance();

                         instance.setLat(String.valueOf(latitude));
                         instance.setLat(String.valueOf(longitude));

                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }


             }

         }


       }
   });
    }




    @Override

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
             mMap.setMyLocationEnabled(true);
        }
    }


    private String getUrl(double latitude , double longitude , String nearbyPlace)
        {

            StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
            googlePlaceUrl.append("location="+latitude+","+longitude);
            googlePlaceUrl.append("&radius="+PROXIMITY_RADIUS);
            googlePlaceUrl.append("&type="+nearbyPlace);
            googlePlaceUrl.append("&sensor=true");
            googlePlaceUrl.append("&key="+"AIzaSyBLEPBRfw7sMb73Mr88L91Jqh3tuE4mKsE");

            Log.d("MapsActivity", "url = "+googlePlaceUrl.toString());

            return googlePlaceUrl.toString();
        }







    public boolean checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED )
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION },REQUEST_LOCATION_CODE);
            }
            return false;

        }
        else
            return true;
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

  /*  void startSeaching( String aa)
    {
        progressBar.show();
        Object dataTransfer[] = new Object[3];
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
        dataTransfer[0] = mMap;

        String hospital = aa;
        String url = getUrl(latitude, longitude, hospital);



        dataTransfer[1] = url;
        dataTransfer[2]=hospital;
        getNearbyPlacesData.execute(dataTransfer);
        progressBar.dismiss();
    }*/




}

