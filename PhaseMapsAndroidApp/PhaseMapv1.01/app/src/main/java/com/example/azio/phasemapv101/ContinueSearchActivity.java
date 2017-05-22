package com.example.azio.phasemapv101;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ContinueSearchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback,
        LocationListener {

    GoogleApiClient mGoogleApiClient;
    Place mLastPlace;
    Marker mCurrLocationMarker;
    private GoogleMap mMap;
    ListView recentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_route);

        Button btnUser = (Button) findViewById(R.id.userLocation);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recentList = (ListView) findViewById(R.id.recentList);
        final ArrayList<String> arr = getHistory();
        ArrayList<String> arr2 = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            StringTokenizer st = new StringTokenizer(arr.get(i), ",");
            arr2.add(st.nextToken());
        }

        recentList.setAdapter(new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, arr2));
        recentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringTokenizer st = new StringTokenizer(arr.get(position), ",");
                String name = st.nextToken();
                double lat = Double.parseDouble(st.nextToken());
                double lang = Double.parseDouble(st.nextToken());

                Intent intent = new Intent(ContinueSearchActivity.this, Route.class);
                intent.putExtra("placeLat", lat);
                intent.putExtra("placeLang", lang);
                intent.putExtra("placeName", name);
                startActivity(intent);

            }
        });


        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.destination);
        autocompleteFragment.setHint("Search Destination");
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                mLastPlace = place;
                if (mCurrLocationMarker != null) {
                    mCurrLocationMarker.remove();
                }
                Toast.makeText(getBaseContext(), "Selected " + place.getName().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ContinueSearchActivity.this, Route.class);
                intent.putExtra("placeLat", place.getLatLng().latitude);
                intent.putExtra("placeLang", place.getLatLng().longitude);
                intent.putExtra("placeName", place.getName().toString());

                updateHistory(place.getName().toString(), place.getLatLng().latitude, place.getLatLng().longitude);
                startActivity(intent);
            }

            @Override
            public void onError(Status status) {

            }
        });

    }

//        Button btnDestination = (Button) findViewById(R.id.destination);
//        btnDestination.setOnClickListener(new View.OnClickListener() {
//            @Override

    public void onClick(View v) {

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    public void updateHistory(String name, double lat, double lang) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "history.txt");
            if (!file.exists()) {
                file.mkdirs();
            }

            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw, true);
            pw.println(name + "," + lat + "," + lang);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHistory() {
        ArrayList<String> adapter = new ArrayList<>();
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "history.txt");
            if (!file.exists()) {
                file.mkdirs();
            }

            Scanner sc = new Scanner(file);
            ArrayList<String> arr = new ArrayList<>();

            while (sc.hasNext()) {
                arr.add(sc.nextLine());
            }

            for (int i = 0; i < 5; i++) {
                int j = arr.size() - 1 - i;
                if (j >= 0) {
                    adapter.add(arr.get(j));
                }
            }

        } catch (Exception e) {
        }

        return adapter;
    }
}

