package com.example.aplicativomural;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapAdapter;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import java.util.ArrayList;
import java.util.Objects;

public class FragmentMapaCadastroEvento extends Fragment {
    public FragmentMapaCadastroEventoListener listener;
    MapView mapView = null;

    public interface FragmentMapaCadastroEventoListener {
        void onClickMapa(String endereco);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("ResourceType") View v = inflater.inflate(R.layout.fragment_mapa_cadastro_evento, container, false);
        //Gereciamento do mapa
        mapView = v.findViewById(R.id.mapa_cadastro_evento);

        Context ctx = Objects.requireNonNull(getContext());
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        mapView.setTileSource(TileSourceFactory.MAPNIK);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView.onResume();
        mapView.setMultiTouchControls(true);
        mapView.setMapListener(new MapAdapter() {
            @Override
            public boolean onScroll(ScrollEvent event) {
                Log.i("Script","onScroll()");
                return super.onScroll(event);
            }
        });
        MapController mapController = (MapController) mapView.getController();
        GeoPoint point = new GeoPoint(-15.6372,-47.6357);
        mapController.setZoom(16);
        //mapController.animateTo(point);
        addMarker(point);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentMapaCadastroEventoListener){
            listener = (FragmentMapaCadastroEventoListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    public void addMarker(GeoPoint center){
        Marker marker = new Marker(mapView);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker, MapView mapView) {
                Log.i("Script","onMarkerClick()");
                return false;
            }
        });
        marker.setOnMarkerDragListener(new Marker.OnMarkerDragListener() {
            @Override
            public void onMarkerDrag(Marker marker) {
                Log.i("Script","onMarkerDrag()");
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Log.i("Script","onMarkerDragEnd()");
            }

            @Override
            public void onMarkerDragStart(Marker marker) {
                Log.i("Script","onMarkerDragStart()");
            }
        });
        MapController mapController = (MapController) mapView.getController();
        mapController.animateTo(center);
        mapView.getOverlays().clear();
        Overlay touchOverlay = new Overlay(Objects.requireNonNull(getActivity())){
            ItemizedIconOverlay<OverlayItem> anotherItemizedIconOverlay = null;
            @Override
            public void draw(Canvas arg0, MapView arg1, boolean arg2) {

            }
            @Override
            public boolean onSingleTapConfirmed(final MotionEvent e, final MapView mapView) {

                //final Drawable marker = Objects.requireNonNull(getActivity()).getResources();
                Projection proj = mapView.getProjection();
                GeoPoint loc = (GeoPoint) proj.fromPixels((int)e.getX(), (int)e.getY());
                String longitude = Double.toString(((double)loc.getLongitudeE6())/1000000);
                String latitude = Double.toString(((double)loc.getLatitudeE6())/1000000);
                System.out.println("- Latitude = " + latitude + ", Longitude = " + longitude );
                ArrayList<OverlayItem> overlayArray = new ArrayList<OverlayItem>();
                OverlayItem mapItem = new OverlayItem("", "", new GeoPoint((((double)loc.getLatitudeE6())/1000000), (((double)loc.getLongitudeE6())/1000000)));
                overlayArray.add(mapItem);
                if(anotherItemizedIconOverlay==null){
                    anotherItemizedIconOverlay = new ItemizedIconOverlay<OverlayItem>(Objects.requireNonNull(getActivity()), overlayArray,null);
                    mapView.getOverlays().add(anotherItemizedIconOverlay);
                    mapView.invalidate();
                }else{
                    mapView.getOverlays().remove(anotherItemizedIconOverlay);
                    mapView.invalidate();
                    anotherItemizedIconOverlay = new ItemizedIconOverlay<OverlayItem>(Objects.requireNonNull(getActivity()), overlayArray,null);
                    mapView.getOverlays().add(anotherItemizedIconOverlay);
                }
                return true;
            }
        };
        mapView.getOverlays().add(touchOverlay);
        mapView.invalidate();
    }
}
