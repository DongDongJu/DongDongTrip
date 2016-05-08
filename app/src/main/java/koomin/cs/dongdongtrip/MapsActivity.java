package koomin.cs.dongdongtrip;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/*
	Kookmin University
	20103347 SeoDongJu
	use android google map template
*/
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Integer index = null;
    List<LatLng> latLngList = null;
    List<String> StateName = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setLatLngList(); // set LatLng

        Intent mapIntent = getIntent();
        index = mapIntent.getIntExtra("index",0); //get index data from prev activity
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(latLngList.get(index)).title(StateName.get(index)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngList.get(index),14));

        //add marker
    }
    private void setLatLngList(){
        latLngList = new ArrayList<>();
        LatLng kbg = new LatLng(37.579617, 126.977041);
        LatLng nst = new LatLng(37.5511736,126.9860379);
        LatLng srm = new LatLng(37.5599568,126.9731133);
        latLngList.add(srm);
        latLngList.add(kbg);
        latLngList.add(nst);

        StateName = new ArrayList<>();
        StateName.add(new String("숭례문"));
        StateName.add(new String("경복궁"));
        StateName.add(new String("N남산타워"));
    }
    public void onBackPressed(){

        //end
        Toast.makeText(getApplicationContext(),"you clicked "+StateName.get(index),Toast.LENGTH_LONG).show();
        super.onBackPressed();
    }
}
