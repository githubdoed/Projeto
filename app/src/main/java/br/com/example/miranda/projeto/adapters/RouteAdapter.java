package br.com.example.miranda.projeto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.example.miranda.projeto.R;
import br.com.example.miranda.projeto.services.RouteResult;

public class RouteAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<RouteResult> listRouteResult;

    public RouteAdapter(Context context, List<RouteResult> listRouteResult) {
        this.listRouteResult = listRouteResult;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listRouteResult.size();
    }

    @Override
    public Object getItem(int position) {
        return listRouteResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adp_routes, parent, false);
        TextView route = (TextView) convertView.findViewById(R.id.textView2);
        route.setText(listRouteResult.get(position).getNmRoute());
        return convertView;
    }
}