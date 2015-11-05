package test.mine.mytest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.geo.Point;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Hop;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.hal.Jackson2HalModule;



import org.springframework.hateoas.hal.HalLinkDiscoverer;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.mine.mytest.R;
import test.mine.mytest.model.Place;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        */
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
        /*try {
            traverse();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public Object traverse() throws URISyntaxException {
        String url = "http://203.151.92.199:8888";
        ParameterizedTypeReference<Resource<Place>> resourceParameterizedTypeReference =
                new ParameterizedTypeReference<Resource<Place>>() {
                };
        Traverson traverson = new Traverson(new URI(url), MediaTypes.HAL_JSON);
        Resource<Place> placeResource = traverson.follow("$._embedded.place[0]._links.self.href")
                .toObject(resourceParameterizedTypeReference);
        Toast toast =  Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT);
        toast.show();
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            //new HttpRequestTask().execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }



    private class HttpRequestTask extends AsyncTask<Void,Void,Object> {
        @Override
        protected Object doInBackground(Void... params) {
            try{
                String url = "http://203.151.92.199:8888/";
                Traverson traverson = new Traverson(new URI(url), MediaTypes.HAL_JSON);
                //Map<String, Object> link_params = new HashMap<String, Object>();
                //int size = traverson.follow("places").toObject("$.page.totalElements");
                //link_params.put("name", "ECC");
                //ParameterizedTypeReference<Resource<Place>> resourceParameterizedTypeReference = new
                        //ParameterizedTypeReference<Resource<Place>>() {};
                // stuck at this
                //Resources<Place> placeResource = traverson.follow(Hop.rel("places")).toObject(resourceParameterizedTypeReference);
                //Resource<Place> placeResource = traverson.follow("$._embedded.places[1]._links.self.href").toObject(resourceParameterizedTypeReference);
                //List<Station> stations = traverson.follow(Hop.rel("places")).toObject(Station[].class);

                // stations = traverson.follow("train_service","$._embedded.train_service[0]._links.self.href").toObject(resourceParameterizedTypeReference);
                //Resource<Place> placeResource = traverson.follow("places", "$._embedded.places[0]._links.self.href").toObject(resourceParameterizedTypeReference);
                //Place place = placeResource.getContent();
                //String name = stations[0].getName();
                List<Place> places = new ArrayList<Place>();
                for(int i = 0;i<63;i++){
                    Place place = traverson.follow("places", "$._embedded.places[0]._links.self.href").toObject(Place.class);
                    places.add(place);
                }
                Place place = places.get(0);
                return place.getName();
                //return size+"";
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object obj) {
            //Something here
            String str = obj.toString();
            TextView placeName = (TextView) findViewById(R.id.placename_value);
            placeName.setText(str);
        }

    }

}