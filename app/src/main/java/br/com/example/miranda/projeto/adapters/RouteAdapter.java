package br.com.example.miranda.projeto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.example.miranda.projeto.R;
import br.com.example.miranda.projeto.services.pojos.Route;

public class RouteAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Route> routes;

    public RouteAdapter(Context context, List<Route> routes) {
        this.routes = routes;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return routes.size();
    }

    @Override
    public Object getItem(int position) {
        return routes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adp_routes, parent, false);
        TextView route = (TextView) convertView.findViewById(R.id.textView2);
        route.setText(routes.get(position).getLongName());
        return convertView;
    }
}