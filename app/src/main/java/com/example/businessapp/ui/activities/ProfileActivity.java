package com.example.businessapp.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.businessapp.R;
import com.example.businessapp.db.models.ProfileData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageView;
    Button buttonLoadImage;
    private Uri imageAddress;
    private static int RESULT_LOAD_IMAGE = 1;
    private static final int SELECT_PHOTO = 100;
    EditText name,shopname,contact_no,area_name;
  //  ProfileData profileData=new ProfileData();
    ArrayList<String> weekdays=new ArrayList<String>();
    RadioGroup radioGroup;
    boolean onSiteStatus;
    DatabaseReference databaseReference;
    int size;
    private StorageReference mStorageRef;
    FirebaseStorage storageref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
      imageView=(ImageView)findViewById(R.id.profile_image);
      name=(EditText)findViewById(R.id.name);
        name=(EditText)findViewById(R.id.name);
        shopname=(EditText)findViewById(R.id.shop_name);
        contact_no=(EditText)findViewById(R.id.contact_no);
       area_name=(EditText)findViewById(R.id.area_name);
       radioGroup=(RadioGroup)findViewById(R.id.yes_no) ;
      //  StorageReference mStorageRef;
        mStorageRef = FirebaseStorage.getInstance().getReference();

       databaseReference= FirebaseDatabase.getInstance().getReference("Profile_data");
       // databaseReference= FirebaseDatabase.getInstance().getReference().child("profiledata");
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     //   Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.yes){
onSiteStatus=true;
                }
                else {
                    onSiteStatus=false;

                }
            }
        });



    }


    public void chooseImage(View view) {
        openGallery();
    }

    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    imageAddress=selectedImage;


                    if (selectedImage != null) {
                        imageView.setImageURI(selectedImage);
                        imageInsertion();
                    }

                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            dataInsertion();

          //  imageInsertion();
//            String idd= databaseReference.push().getKey();
//            ProfileData profileData=new ProfileData();
//            profileData.setUserName( name.getText().toString());
//            profileData.setShopName(shopname.getText().toString());
//            profileData.setContact_number(contact_no.getText().toString());
//            profileData.setArea_name(area_name.getText().toString());
//            profileData.setWorkingDays(weekdays);
//            profileData.setFilepath(imageAddress);
//            profileData.setOnSite_service(onSiteStatus);
//            databaseReference.child("User").child(idd).setValue(profileData);

          //  getdataFirebase();
            startActivity(new Intent(ProfileActivity.this, ShowProfileActivity.class).putExtra("size_days",size));

            return false;
            // do something here
        }
        return super.onOptionsItemSelected(item);
    }

   private void imageInsertion() {
       Uri test=imageAddress;
       String t=null;
       if(imageAddress!=null){
       StorageReference ref=mStorageRef.child("images/"+imageAddress.getLastPathSegment());

         //  StorageReference ref=mStorageRef.child("Your Path" + "/" + "Image Name" + ".jpg");
           ref.putFile(imageAddress)
                  .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                      @Override
                       public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                          Toast.makeText(ProfileActivity.this,"uploaded",Toast.LENGTH_SHORT).show();
                          //Picasso.get().load().into();

                      }
                   })
                   .addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(ProfileActivity.this,"failed",Toast.LENGTH_SHORT).show();
                       }
                   });
        }else {
            Toast.makeText(ProfileActivity.this,"null",Toast.LENGTH_SHORT).show();
        }

    }


    private void runCode() {

     //   ProfileData profileData=new ProfileData(name.getText().toString(),shopname.getText().toString(),contact_no.getText().toString(),area_name.getText().toString(),onSiteStatus,imageAddress);
        String key=databaseReference.push().getKey();
       // databaseReference.child("user").setValue(profileData);
    }

    /* public void save(MenuItem item) {
         String id= databaseReference.push().getKey();
         ProfileData profileData=new ProfileData();
         profileData.setUserName( name.getText().toString());
         profileData.setShopName(shopname.getText().toString());
         profileData.setContact_number(contact_no.getText().toString());
         profileData.setArea_name(area_name.getText().toString());
      profileData.setWorkingDays(weekdays);
         profileData.setFilepath(imageAddress);
         profileData.setOnSite_service(onSiteStatus);

       //  Data data=new Data(id,Username,Shopname,Contact_no,Area_name,Working_days,Image,Site_service);
         //Data data=new Data();
 //        databaseReference.child(id).setValue(data);
 //        databaseReference.setValue(data);
         databaseReference.child("User").child(id).setValue(profileData);
         startActivity(new Intent(ProfileActivity.this,ShowProfileActivity.class));
     }
 */
    private void getData() {

    }

    public void selectCheckedItem(View view) {
        boolean checked=((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.sunday:
                if(checked)
                {
                    weekdays.add("Sunday");
                }else
                {
                  weekdays.remove("Sunday");
                }
                break;

            case R.id.monday:
                if(checked)
                {
                    weekdays.add("Monday");

                }else
                {
                    weekdays.remove("Monday");
                }
                break;

            case R.id.Tuesday:
                if(checked)
                {
                    weekdays.add("Tuesday");
                }else
                {
                    weekdays.remove("Tuesday");
                }
                break;
            case R.id.wed:
                if(checked)
                {
                    weekdays.add("Wednesday");
                }else
                {
                    weekdays.remove("Wednesday");
                }
                break;
            case R.id.thu:
                if(checked)
                {
                    weekdays.add("Thursday");
                }else
                {
                    weekdays.remove("Thursday");
                }
                break;
            case R.id.friday:
                if(checked)
                {
                    weekdays.add("Friday");
                }else
                {
                    weekdays.remove("Friday");
                }
                break;
            case R.id.saturday:
                if(checked)
                {
                    weekdays.add("Saturday");
                }else
                {
                    weekdays.remove("Saturday");
                }
                break;

        }
    }
    public void dataInsertion(){
        String ide= databaseReference.push().getKey();
        final ProfileData profileData=new ProfileData();
        profileData.setUserName( name.getText().toString());
        profileData.setShopName(shopname.getText().toString());
        profileData.setContact_number(contact_no.getText().toString());
        profileData.setArea_name(area_name.getText().toString());
        profileData.setWorkingDays(weekdays);
       profileData.setFilepath(imageAddress.toString());
        profileData.setOnSite_service(onSiteStatus);
        profileData.setImg_url(mStorageRef.toString());

        size=weekdays.size();
       // databaseReference.child("User").child(id).setValue(profileData);
       databaseReference.child(ide).setValue(profileData);
      // databaseReference.setValue(profileData);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().setValue(profileData);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void updateData()
    {

    }
public void getdataFirebase()
{
    databaseReference= FirebaseDatabase.getInstance().getReference("Profile_data").child("User");

    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             String name_show=dataSnapshot.getValue().toString();

            String buisness_show=dataSnapshot.getValue().toString();
             String area_name_show=dataSnapshot.child("area_name").getValue().toString();
               String contact_show=dataSnapshot.child("contact_number").getValue().toString();
               Intent i=new Intent(ProfileActivity.this,ShowProfileActivity.class);
               i.putExtra("name",name_show);
               i.putExtra("buisness",buisness_show);
               i.putExtra("area",area_name_show);
               i.putExtra("contact",contact_show);
          /*  name.setText(dataSnapshot.child("userName").getValue().toString());
            buisness_name.setText(dataSnapshot.child("shopName").getValue().toString());
            area_name.setText(dataSnapshot.child("area_name").getValue().toString());
            name.setText(dataSnapshot.child("contact_number").getValue().toString());*/


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}


}