package com.GabrielMJr.Twaire.AllEasy;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.activity.BaseActivity;
import com.GabrielMJr.Twaire.AllEasy.adapter.MainAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Runnable {
	private Toolbar toolbar;
	
	private RecyclerView recyclerView;
	private MainAdapter mainAdapter;
	
	private List<CharSequence> optionsItems;

	private Handler handler;
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
        setContentView(R.layout.splash_screen);
		closeSplashScreen();
    }
	
	private void closeSplashScreen () {
		handler = new Handler();
		handler.postDelayed(this, 2500);
	}

	@Override
	public void run () {
		setContentView(R.layout.activity_main);
		getViews();
		setSupportActionBar();
		initializeAttributes();
		buildRecyclerView();
	}
	
	private void getViews() {
		toolbar = findViewById(R.id.toolbar);
		recyclerView = findViewById(R.id.main_recycler_view);
	}
	
	private void setSupportActionBar() {
		setSupportActionBar(toolbar);
	}
	
	private void initializeAttributes () {
		optionsItems = new ArrayList<>();
		mainAdapter = new MainAdapter(getApplicationContext(), optionsItems);
	}
	
	private void buildRecyclerView () {
		optionsItems.add(getText(R.string.combinatorial_analysis));
		optionsItems.add(getText(R.string.kinematics));
		optionsItems.add(getText(R.string.functions));
		optionsItems.add(getText(R.string.hydrodynamics));
		recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
		recyclerView.setAdapter(mainAdapter);
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

	 // Abrir aba de "Arranjos" caso o botão arranjos for clicado
	 arranjos.setOnClickListener(
	 new OnClickListener() {
	 public void onClick(View view)
	 {
	 startActivity(new Intent(getApplicationContext(), Arranjos.class));
	 }
	 });

	 // Abrir aba de "combinação" caso o botão comb for clicado
	 comb.setOnClickListener(
	 new OnClickListener() {
	 public void onClick(View view)
	 {
	 startActivity(new Intent(getApplicationContext(), Combination.class));
	 }
	 });

	 // Abrir aba de "fatorial" caso o botão fat for clicado
	 fat.setOnClickListener(
	 new OnClickListener() {
	 public void onClick(View view)
	 {
	 startActivity(new Intent(getApplicationContext(), Fatorial.class));
	 }
	 });

	 // Abrir aba de "Função de segundo grau" caso o botão fsg for clicado
	 fsg.setOnClickListener(
	 new OnClickListener() {
	 public void onClick(View view)
	 {
	 startActivity(new Intent(getApplicationContext(), FSG.class));
	 }
	 });

	 // Abrir aba de "Vazão" caso  botão vaz for clicado;
	 vaz.setOnClickListener(
	 new OnClickListener(){
	 public void onClick(View view)
	 {
	 startActivity(new Intent(getApplicationContext(), FluidFlow_ActivityMain.class));
	 }
	 });

	 // Abrir aba de "Cinemática" caso o botão kinematic for clicado
	 kinematic.setOnClickListener( 
	 new OnClickListener() {
	 @Override
	 public void onClick(View view)
	 {
	 startActivity(new Intent(getApplicationContext(), Kinematic_ActivityMain.class));
	 }
	 });

	 }
	 }, 2500);*/
}
