package com.gabrielmjr.alleasy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.activity.BaseActivity;
import com.gabrielmjr.alleasy.activity.SettingsActivity;
import com.gabrielmjr.alleasy.activity.math.combinatorial_analysis.CombinatorialAnalysisActivityMain;
import com.gabrielmjr.alleasy.activity.math.function.FunctionActivityMain;
import com.gabrielmjr.alleasy.activity.physic.kinematic.KinematicActivityMain;
import com.gabrielmjr.alleasy.activity.physic.vaz.FluidFlow_ActivityMain;
import com.gabrielmjr.alleasy.adapter.MainAdapter;
import com.gabrielmjr.alleasy.adapter.MainAdapter.OnOptionsClickListener;
import com.gabrielmjr.alleasy.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements OnOptionsClickListener {

    @Override
    protected void initializeActivity() {
        setContentView(R.layout.splash_screen);
        closeSplashScreen();
    }

	private Toolbar toolbar;

	private RecyclerView recyclerView;
	private MainAdapter mainAdapter;

	private List<Activity> optionsItems;

	/* 
	 private String title;
	 private String message;
	 private final String DB_NAME = "app_info";
	 private final String TB_NAME = "version_info";
	 private int updaterStatus;
	 private int lastChoosenTheme;
	 private String lastChoosenLang;

	 private DataManager DM;
	 private DialogAlertData dialogAlertData;
	 private Drawable icon;
	 private int versionCode;
	 private PackageInfo packageInfo;
	 private Handler handler;
	 private final Context context = this;

	 private Settings settings;
	 private SharedPreferences sharedPreferences;
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
		getHandler().postDelayed(this, 2500);
    }

	private void closeSplashScreen() {
        handler = new Handler();
		handler.postDelayed(this, 2500);
	}

	@Override
	public void run() {
		setContentView(R.layout.activity_main);  
        getViews();                       
        setSupportActionBar();
        initializeAttributes();
        buildRecyclerView();
	}

	@Override
    protected void getViews() {
		toolbar = findViewById(R.id.toolbar);
		recyclerView = findViewById(R.id.main_recycler_view);
	}

	private void setSupportActionBar() {
		setSupportActionBar(toolbar);
	}

	@Override
    protected void initializeAttributes() {
		optionsItems = new ArrayList<>();
		mainAdapter = new MainAdapter(getApplicationContext(), optionsItems, this);
	}

	private void buildRecyclerView() {
		optionsItems.add(new Activity(getText(R.string.combinatorial_analysis), CombinatorialAnalysisActivityMain.class));
		optionsItems.add(new Activity(getText(R.string.kinematics), KinematicActivityMain.class));
		optionsItems.add(new Activity(getText(R.string.functions), FunctionActivityMain.class));
        optionsItems.add(new Activity(getText(R.string.fluid_flow), FluidFlow_ActivityMain.class));
		recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
		recyclerView.setAdapter(mainAdapter);
	}

	@Override
	public void onOptionsClick(int position) {
		startActivity(new Intent(getApplicationContext(), optionsItems.get(position).getClassId()));
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                return true;
        }
        return false;
    }

	/*handler = new Handler();
	 handler.postDelayed(new Runnable() {
	 @Override
	 public void run()
	 {
	 settings = new Settings();
	 //settings.loadTheme();

	 sharedPreferences = getSharedPreferences(settings.SHARED_PREFERENCES_CONFIG_NAME, 0);                
	 lastChoosenTheme = sharedPreferences.getInt(settings.THEME_ID, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
	 if (AppCompatDelegate.getDefaultNightMode() != lastChoosenTheme)
	 {
	 AppCompatDelegate.setDefaultNightMode(lastChoosenTheme);
	 //startActivity(new Intent(getApplicationContext(), MainActivity.class));
	 recreate();
	 }

	 // Loading language
	 sharedPreferences = getSharedPreferences(settings.SHARED_PREFERENCES_CONFIG_LANG_NAME, 0);
	 lastChoosenLang = sharedPreferences.getString(settings.LANG_ID, null);
	 if (lastChoosenLang != null && lastChoosenLang != settings.getLang(getApplicationContext()))
	 {
	 // Set locale
	 Locale locale = new Locale(lastChoosenLang);
	 locale.setDefault(locale);

	 // Get resources
	 Resources resources = getResources();
	 Configuration config = resources.getConfiguration();

	 // Set configuration
	 config.setLocale(locale);

	 // And finally update resources
	 resources.updateConfiguration(config, resources.getDisplayMetrics());
	 }

	 setContentView(R.layout.splash_screen);

	 try
	 {
	 packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
	 }
	 catch (PackageManager.NameNotFoundException e)
	 {}
	 versionCode = packageInfo.versionCode;

	 DM = new DataManager(getApplicationContext(), DB_NAME, TB_NAME);
	 updaterStatus = DM.initialize(versionCode);

	 if (updaterStatus == 2)
	 {
	 welcome = findViewById(R.id.welcome);
	 welcome.setText(R.string.welcome);
	 }

	 dialogAlertData = new DialogAlertData(context);
	 }
	 }, 1);


	 handler.postDelayed(new Runnable() {
	 @Override
	 public void run()
	 {
	 setTheme(R.style.AppTheme);
	 setContentView(R.layout.activity_main);
	 toolbar = findViewById(R.id.toolbar);
	 setSupportActionBar(toolbar);

	 arranjos = findViewById(R.id.arrj);
	 comb = findViewById(R.id.comb);
	 fat = findViewById(R.id.fat);
	 fsg = findViewById(R.id.fsg);
	 vaz = findViewById(R.id.vaz);
	 kinematic = findViewById(R.id.kinematic);

	 if (updaterStatus == -1)
	 {

	 }
	 else if (updaterStatus == 0)
	 {

	 }
	 else if (updaterStatus == 1)
	 {
	 title = (String)getText(R.string.update_title);
	 message = (String)getText(R.string.update_message);
	 icon = getDrawable(R.mipmap.ic_launcher);
	 dialogAlertData.alertDialog(title, message, icon).show();
	 }

	*/
     
     
}
