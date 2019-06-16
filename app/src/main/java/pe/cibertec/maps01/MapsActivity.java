package pe.cibertec.maps01;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {  //mapa listo
        mMap = googleMap;

        CustomInfoWindowAdapter customInfoWindowAdapter=new CustomInfoWindowAdapter(this);
        mMap.setInfoWindowAdapter(customInfoWindowAdapter);


        //Si ya cargó el mapa
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLng cibertecSanIsidro = new LatLng(-12.1041533, -77.0559932);
                mMap.addMarker(new MarkerOptions()
                        .position(cibertecSanIsidro)
                        .title("Cibertec")
                        .snippet("Sede San Ididro")
                        .draggable(true));
               // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cibertecSanIsidro, 16));


                // Add a marker in Sydney and move the camera
                LatLng cibertec = new LatLng(-12.122648, -77.0304797);
                mMap.addMarker(new MarkerOptions()
                        .position(cibertec)
                        .title("Cibertec")
                        .snippet("Sede Miraflores")
                        //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));
               // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cibertec, 20));
               // mMap.animateCamera(CameraUpdateFactory.zoomIn());
               // mMap.animateCamera(CameraUpdateFactory.zoomTo(10),3000,null);

                //Region
                LatLngBounds latLngBounds=new LatLngBounds.Builder()
                        .include(cibertec)
                        .include(cibertecSanIsidro)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,13));
                mMap.addPolyline(new PolylineOptions().add(cibertec,cibertecSanIsidro)
                        .width(5)
                        .color(Color.DKGRAY));

                mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                    @Override
                    public void onMarkerDragStart(Marker marker) {

                    }

                    @Override
                    public void onMarkerDrag(Marker marker) {

                    }

                    @Override
                    public void onMarkerDragEnd(Marker marker) {
                        Toast.makeText(getApplicationContext(),"Latitude" +marker.getPosition().latitude + "\n"
                                        + "Longitud " + marker.getPosition().longitude,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(cibertec));
    }
}
