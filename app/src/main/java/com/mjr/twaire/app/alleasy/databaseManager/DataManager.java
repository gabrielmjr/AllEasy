package com.mjr.twaire.app.alleasy.databaseManager;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import com.mjr.twaire.app.alleasy.util.DateNormalizer;
import com.mjr.twaire.app.alleasy.tools.DialogAlertData;

// Base de dados usando SQLiteOpenHelper
public class DataManager extends SQLiteOpenHelper {

	// Atributos
	private String TB_NAME;
	private final String COL_1 = "ID";
	private final String COL_2 = "data";
	private final String COL_2_MAIN = "version_code";
	private final String COL_3 = "result";
	private final String COL_3_MAIN = "installation_id";
	private final String COL_4 = "schedule";
    private final DateNormalizer DN = new DateNormalizer();

	// Construtor
	public DataManager(Context context, String DB_NAME, String TB_NAME) {
		super(context, DB_NAME, null, 1);
		setTableName(TB_NAME);

	}

	// onCreate da criação das tabelas
	@Override
	public void onCreate(SQLiteDatabase db) {

		// Base de dados sobre versão atual
		db.execSQL("CREATE TABLE IF NOT EXISTS " + getTableName()
                   + "("
                   + getCOL_1()
                   + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + getCOL_2_MAIN()
                   + " INTEGER, "
                   + getCOL_3_MAIN()
                   + " INTEGER)");

		// Base de dados dos cálculos
		db.execSQL("CREATE TABLE IF NOT EXISTS " + getTableName()
                   + "("
                   + getCOL_1()
                   + " INTEGER, "
                   + getCOL_2()
                   + " TEXT, "
                   + getCOL_3()
                   + " TEXT, "
                   + getCOL_4()
                   + " INTEGER)"
                   );
	}

	// onUpgrade obrigatório do SQLiteOpenHelper
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE " + getTableName());
		onCreate(db);
	}

	// Inserindo dados à tabela
	public boolean insertData(int COL_1, String COL_2, String COL_3) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues CV = new ContentValues();

		CV.put(getCOL_1(), COL_1);
		CV.put(getCOL_2(), COL_2);
		CV.put(getCOL_3(), COL_3);
		CV.put(getCOL_4(), DN.getDate());

		Long res = db.insert(getTableName(), null, CV);

		if (res == -1) {
			return false;
		} else {
			return true;
		}
	}

	public int initialize(int application_versionCode) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues CV = new ContentValues();
		Cursor cursor = db.rawQuery("SELECT * FROM " + getTableName(), null);
        int vC = 0;

        if (cursor.moveToLast()) {
             vC = cursor.getInt(1);       
        }
        
        if (vC != 0) {

            if (vC > application_versionCode) {
                return  -1; // App desatualizado

            } else if (vC == application_versionCode) {
                return 0; // Nada feito com o app

            } else if (vC < application_versionCode) {		
                CV.put(getCOL_2_MAIN(), application_versionCode);
                CV.put(getCOL_3_MAIN(), DN.getDate());
                db.insert(getTableName(), null, CV);
            
                return 1; // App atualizado

            } else {
                return 6;
            }

        } else {
            CV.put(getCOL_2_MAIN(), application_versionCode);
			CV.put(getCOL_3_MAIN(), DN.getDate());
            db.insert(getTableName(), null, CV);
            return 2; // Novo usuário
        }

	}

	// Setters and Getters
	private void setTableName(String TB_Name) {
		this.TB_NAME = TB_Name;
	}

	private String getTableName() {
		return this.TB_NAME;
	}

	public String getCOL_1() {
		return COL_1;
	}

	private String getCOL_2() {
		return COL_2;
	}

	private String getCOL_2_MAIN() {
		return COL_2_MAIN;
	}

	private String getCOL_3() {
		return COL_3;
	}

	private String getCOL_3_MAIN() {
		return COL_3_MAIN;
	}

	private String getCOL_4() {
		return COL_4;
    }
}

