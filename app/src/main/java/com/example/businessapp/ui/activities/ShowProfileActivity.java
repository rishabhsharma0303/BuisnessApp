package com.example.businessapp.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.businessapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ShowProfileActivity extends AppCompatActivity /*implements OnMapReadyCallback*/ {
//DatabaseReference databaseReference;
//FirebaseDatabase mref;
    DatabaseReference mref;

    ImageView showimage;
    TextView name,buisness_name,area_name,conatct_no;
    String name_show;
    String buisness_show;
    String area_name_show;
    String contact_show;
    TextView days_for_work;
    ArrayList<String> getWorking_days=new ArrayList<>();
  private Uri imagepath;
    String path;
   StorageReference mStorageRef;
   UploadTask uploadTask;
    GoogleMap googleMap;
    MapFragment mapFragment;
    Double lat,log;
    LinearLayout map_layout;
    private GoogleMap mMap;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
        showimage=(ImageView)findViewById(R.id.showimag);
      name=(TextView) findViewById(R.id.get_name);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        map_layout=(LinearLayout)findViewById(R.id.map_layout);

        buisness_name=(TextView) findViewById(R.id.get_business_name);
       area_name=(TextView) findViewById(R.id.get_area_name);
        conatct_no=(TextView) findViewById(R.id.get_contact_no);
      //  days_for_work=(TextView)findViewById(R.id.tv_days_for_work);
        days_for_work=(TextView)findViewById(R.id.get_wrkingdays_name);
        loadWithGlide();

       // mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.maps);
       // map_layout=(MapView)getSupportFragmentManager().findFragmentById(map_layout);
       mref= FirebaseDatabase.getInstance().getReference("Latlng");
/*        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lat= Double.parseDouble(dataSnapshot.child("lattitude").getValue(String.class));
                log=  Double.parseDouble(dataSnapshot.child("longitude").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
//        SupportMapFragment mapFragment = (SupportMapFragment) this.getSupportFragmentManager()
//                .findFragmentById(R.id.maps);
//        mapFragment.getMapAsync(this);


      mref= FirebaseDatabase.getInstance().getReference("Profile_data");

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    //  imagepath= (Uri) dataSnapshot.child("filepath").getValue();
                    //   imagepath=Uri.parse(dataSnapshot.child("filepath").getValue(String.class));
//showimage.setImageURI(Uri.parse(path));
//                    showimage.setImageURI(imagepath);
                    //   getImage();
                    name_show=dataSnapshot.child("userName").getValue(String.class);
             name.setText(name_show);
             buisness_show=dataSnapshot.child("shopName").getValue(String.class);
             buisness_name.setText(buisness_show);
             area_name_show=dataSnapshot.child("area_name").getValue(String.class);
             area_name.setText(area_name_show);
             contact_show=dataSnapshot.child("contact_number").getValue(String.class);
             conatct_no.setText(contact_show);
            /* String image_url=dataSnapshot.child("img_url").getValue(String.class);
                    StorageReference ref=mStorageRef.child("images/");*/




             //loadWithGlide();
            // String url="https://firebasestorage.googleapis.com/v0/b/businessapp-64366.appspot.com/o/images%2F217725464?alt=media&token=65a304f6-0acc-4320-a4ee-9f18e8e623ab";

            //StorageReference storageReference=FirebaseStorage.getInstance().getReference();
          //  int i;

//           Glide.with(ShowProfileActivity.this)
//                     .load(url)
//                  .into(showimage);

         /* mStorageRef.child("images/").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri).resize(50,50).into(showimage);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });*/
//            String link=dataSnapshot.child("filepath").getValue(String.class);
//           Picasso.get().load(link).into(showimage);
          //  int j= Integer.parseInt(getIntent().getStringExtra("size_days"));
/*for (int i=0;i<j;i++){
    getWorking_days= (ArrayList<String>) dataSnapshot.child("workingDays").getValue();
}*/
                    getWorking_days= (ArrayList<String>) dataSnapshot.child("workingDays").getValue();

               // days_for_work.setText((CharSequence) getWorking_days);
                   // days_for_work.append(( getWorking_days);

//       for(int i=0;i<getWorking_days.size();i++){
//                      days_for_work.append(getWorking_days.get(i));
//                        // days_for_work.setText(getWorking_days.get(i));
//                 days_for_work.append(",");
//
//         }




          //   blank_tv.setText(name_show);

 /*                buisness_show=dataSnapshot.getValue(String.class);
               area_name_show=dataSnapshot.getValue(String.class);
                contact_show=dataSnapshot.getValue(String.class);
                name.setText(name_show);
                buisness_name.setText(buisness_show);
                area_name.setText(area_name_show);
                conatct_no.setText(contact_show);*/
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
               Log.w("rishabh", "Failed to read value.", databaseError.toException());
            }
        });


      //  Bundle bundle=getIntent().getExtras();
    //   String n= getIntent().getStringExtra("name");

//        name.setText(getIntent().getStringExtra("name"));
//        buisness_name.setText(getIntent().getStringExtra("buisness"));
//        area_name.setText(getIntent().getStringExtra("area"));
//        conatct_no.setText(getIntent().getStringExtra("contact"));
      /*  databaseReference= FirebaseDatabase.getInstance().getReference("Profile_data").child("User");



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
//              String name=dataSnapshot.child("userName").getValue().toString();
//
//                String buisness=dataSnapshot.child("shopName").getValue().toString();
//                String area_name=dataSnapshot.child("area_name").getValue().toString();
//                String contact=dataSnapshot.child("contact_number").getValue().toString();
name.setText(dataSnapshot.child("userName").getValue().toString());
               buisness_name.setText(dataSnapshot.child("shopName").getValue().toString());
                area_name.setText(dataSnapshot.child("area_name").getValue().toString());
                name.setText(dataSnapshot.child("contact_number").getValue().toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


    }
    public void loadWithGlide() {
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
       // StorageReference storageReference = FirebaseStorage.getInstance().getReference("images/");
mStorageRef=FirebaseStorage.getInstance().getReference("images/");
        // ImageView in your Activity
        ImageView imageView = findViewById(R.id.showimag);

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(this /* context */)
                .load(mStorageRef)
                .into(imageView);
        // [END storage_load_with_glide]

    }
    public void getImage() {
        try {
            final File file=File.createTempFile("images","jpeg");
            mStorageRef.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(ShowProfileActivity.this,"Failed to load",Toast.LENGTH_SHORT).show();
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap=googleMap;
//       // googleMap = googleMap;
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//
//
//        //Edit the following as per you needs
//     //   mMap.setTrafficEnabled(true);
//      mMap.setIndoorEnabled(true);
//      mMap.setBuildingsEnabled(true);
//      mMap.setMaxZoomPreference(17.0f);
//
//
//mref.addChildEventListener(new ChildEventListener() {
//    @Override
//    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//      //  LatLng placeLocation = new LatLng(dataSnapshot.child("lattitude").getValue(Long.class),dataSnapshot.child("longitude").getValue(Long.class));
//   //     mMap.addMarker(new MarkerOptions().position(placeLocation)
//     //           .title(""));
//        LatLng latLng=new LatLng(dataSnapshot.child("lattitude").getValue(Double.class),dataSnapshot.child("longitude").getValue(Double.class)) ;
//    mMap.addMarker(new MarkerOptions().position(latLng));}
//
//    @Override
//    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//    }
//
//    @Override
//    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//    }
//
//    @Override
//    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//    }
//
//    @Override
//    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//    }
//});
//
//        //Make them global
//
////mMap.moveCamera(CameraUpdateFactory.newLatLng(placeLocation));
//       mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 1000, null);
//    }
}
