package com.rafaelsf80.d4w.hotels;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class DataTask extends AsyncTask<Void, Integer, Boolean> {
	
    private final String TAG = getClass().getSimpleName();
	private final String url = "https://script.googleusercontent.com/macros/echo?user_content_key=jC1P2Fd5jS_HXzG7DI8i5fnjPxb3iX9LGHhmEkvdBD4_HtKg9euRDqhsT14DadEJDGjmJTZL_1wtV4ctYAz8R_OQV8YW7mCgm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnDkrjYXUsX96kHDOoP8IPGjNyfLdkXIk-OqZs7D_N5wsaikPxxMJZeyi3eD6jFknQCjHK1wJ9k37&lib=MetPFVXDwnph9dqLON6lqDbPoDC-lvsGV";

    ArrayList<Item> items;
    protected Main activ;
    private ProgressDialog dialog;
    private Bundle savedInstanceState;
	
	public DataTask(Main activ, Bundle savedInstanceState)
    {
		this.activ = activ;
		this.savedInstanceState = savedInstanceState;
		this.items = new ArrayList<Item>();
		dialog = new ProgressDialog(activ);
        Log.d(TAG, "DataTask constructor");
    }
	
	@Override
    protected void onPreExecute() {
        dialog.setMessage("Loading, please wait.");
        dialog.show();
    }
	
    @Override
    protected Boolean doInBackground(Void... params)
    {
		// grab JSON from the URL above and store it in the items class
		RequestQueue mQueue = Volley.newRequestQueue(activ);
		StringRequest mRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
			@Override
			public void onResponse(String s) {

				// handle response
				Log.d(TAG, "Response: " + s);
				try {
					JSONArray objects = new JSONArray(s);
					for (int j = 0; j < objects.length(); j++) {
						JSONObject jsonobject = objects.getJSONObject(j);
						Item item = new Item();
						item.nombre_actividad = jsonobject.getString("actividad");
						item.descripcion = jsonobject.getString("descripcion");
						item.disponibles = jsonobject.getString("disponibles");
						item.total_plazas = jsonobject.getString("plazas");
						item.reservadas = jsonobject.getString("habitaciones");
						item.color = jsonobject.getString("color");
						items.add(item);

						Log.d(TAG, item.toString());

						if (savedInstanceState == null) {
							FragmentTransaction transaction = activ.getSupportFragmentManager().beginTransaction();
							activ.fragment = new SlidingTabsColorsFragment();
							transaction.replace(R.id.sample_content_fragment, activ.fragment);
							transaction.commit();
						}

						for (int i=0; i<items.size(); i++) {

							int total = Integer.parseInt(items.get(i).total_plazas);
							int available = Integer.parseInt(items.get(i).disponibles);

							int color = Color.BLUE;  //default color
							String colorString = items.get(i).color;

							if (colorString.compareTo("BLUE") == 0)
								color = Color.BLUE;
							if (colorString.compareTo("MAGENTA") == 0)
								color = Color.MAGENTA;
							if (colorString.compareTo("RED") == 0)
								color = Color.RED;
							if (colorString.compareTo("DKGRAY") == 0)
								color = Color.DKGRAY;
							if (colorString.compareTo("YELLOW") == 0)
								color = Color.YELLOW;
							if (colorString.compareTo("GREEN") == 0)
								color = Color.GREEN;
							if (colorString.compareTo("CYAN") == 0)
								color = Color.CYAN;
							if (colorString.compareTo("BLACK") == 0)
								color = Color.BLACK;

							activ.fragment.mTabs.add(new SlidingTabsColorsFragment.SamplePagerItem(
									items.get(i).nombre_actividad, // Title
									items.get(i).descripcion,
									total,
									available,
									items.get(i).reservadas,
									color, // Indicator color
									Color.GRAY // Divider color
							));
						}
					}
				} catch (Exception e) {
					Log.d(TAG, "Error loading Config: " + e.toString());
				}
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError volleyError) {
				Log.d(TAG, "Response: " + volleyError.toString());
			}
		});

		mQueue.add(mRequest);

		return true;
	}

    @Override
    protected void onPostExecute(Boolean b)
    {
    	if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
 }