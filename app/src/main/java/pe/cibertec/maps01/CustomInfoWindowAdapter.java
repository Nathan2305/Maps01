package pe.cibertec.maps01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    Context context;

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
        TextView tvTitle, tvDescription, tvSchedule;
        ImageView imageView;
        imageView = view.findViewById(R.id.imageView);
        tvTitle = view.findViewById(R.id.tbTitle);
        tvDescription = view.findViewById(R.id.tbDescription);
        tvSchedule = view.findViewById(R.id.tbHorario);

        tvTitle.setText("Prueba");
        tvDescription.setText("Descripción");
        tvSchedule.setText("Horario");
        imageView.setImageResource(R.mipmap.ic_launcher);
        return view;
    }

    public CustomInfoWindowAdapter(Context context) {
        this.context = context;
    }
}
