package com.example.businessapp.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.businessapp.R;
import com.example.businessapp.db.models.Data;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MapsActivity<val> extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
   Button pin_loc;
    private GoogleMap.OnCameraIdleListener onCameraIdleListener;
    ImageView i1;
    String lat,longt;
DatabaseReference databaseReference;
Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        databaseReference= FirebaseDatabase.getInstance().getReference("Latlng");
      //  String lattitude,longitude;
       /* zoom_in = (Button) findViewById(R.id.zoom_in);
        zoom_out = (Button) findViewById(R.id.zoom_out);*/
       // i1 = (ImageView) findViewById(R.id.img);
       pin_loc=(Button)findViewById(R.id.pin_location);

       SupportMapFragment mapFragment = (SupportMapFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        pin_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id= databaseReference.push().getKey();
                String lattitude=  lat;
                String longtude=longt;

                Data data=new Data(id,lattitude,longtude);
                 databaseReference.child(id).setValue(data);
                databaseReference.setValue(data);
                startActivity(new Intent(MapsActivity.this,BrandActivity.class));
            }
        });






    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setMarker();
        uDesign();
        getLocation();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);





       // mMap.getUiSettings().setMyLocationButtonEnabled(true);

       // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15.0f));

        mMap.getUiSettings().setMapToolbarEnabled(true);





        }
public void setMarker()
{
    LatLng sydney = new LatLng(28.673738, 77.290055);
    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker ")).setDraggable(true);
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15.0f));

}
public void uDesign()
{
    mMap.getUiSettings().setZoomControlsEnabled(true);
    mMap.getUiSettings().setMyLocationButtonEnabled(true);
}
public void getLocation()
{
    mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
        @Override
        public void onMarkerDragStart(Marker marker) {

        }

        @Override
        public void onMarkerDrag(Marker marker) {

        }

        @Override
        public void onMarkerDragEnd(final Marker marker) {
final LatLng latLng=marker.getPosition();
            Toast.makeText(
                    MapsActivity.this,
                    "Lat " +latLng.latitude + " "
                            + "Long " +latLng.longitude,
                    Toast.LENGTH_LONG).show();
            lat= String.valueOf(latLng.latitude);
            longt=String.valueOf(latLng.longitude);


        }
    });



}













    private void position(val klcc) {
    }


}
