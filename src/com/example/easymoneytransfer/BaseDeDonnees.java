package com.example.easymoneytransfer;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDonnees extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "easymoneytransfert";
	private static final String AGENCE_TABLE_NAME = "agences";
	private static final String AGENCE_COLUMN_ID = "ID_agence";
	private static final String AGENCE_COLUMN_NAME = "NomAgence";
	private static final String AGENCE_COLUMN_DESCRIPTION = "Description";
	private static final String AGENCE_COLUMN_VILLE = "Ville";
	private static final String AGENCE_COLUMN_LOGO = "logo";
	private static final String SOUS_AGENCE_TABLE_NAME = "sousagences";
	private static final String SOUS_AGENCE_COLUMN_ID = "ID_sousagence";
	private static final String SOUS_AGENCE_COLUMN_NAME = "NomSousAgence";
	private static final String SOUS_AGENCE_COLUMN_VILLE = "NomVille";
	private static final String SOUS_AGENCE_COLUMN_ID_AGENCE = "ID_agence";
	private static final String TAUX_TRANSFERT_TABLE_NAME = "tauxdetransfert";
	private static final String TAUX_TRANSFERT_COLUMN_ID = "ID_tauxtransfert";
	private static final String TAUX_TRANSFERT_COLUMN_MONTANTMIN = "MontantMin";
	private static final String TAUX_TRANSFERT_COLUMN_MONTANTMAX = "MontantMax";
	private static final String TAUX_TRANSFERT_COLUMN_TAUX = "TauxTransfert";
	private static final String TAUX_TRANSFERT_COLUMN_ID_AGENCE = "NomAgence";
	
	public BaseDeDonnees(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		

		db.execSQL(
			"CREATE TABLE IF NOT EXISTS "+ AGENCE_TABLE_NAME +" ("+
				AGENCE_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
				AGENCE_COLUMN_NAME +" TEXT, "+
				AGENCE_COLUMN_DESCRIPTION +" TEXT, "+
				AGENCE_COLUMN_VILLE +" TEXT, "+
				AGENCE_COLUMN_LOGO +" TEXT);"
		);

		db.execSQL(
			"CREATE TABLE IF NOT EXISTS "+ SOUS_AGENCE_TABLE_NAME +" ("+
				SOUS_AGENCE_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
				SOUS_AGENCE_COLUMN_NAME +" TEXT, "+
				SOUS_AGENCE_COLUMN_VILLE +" TEXT, "+
				SOUS_AGENCE_COLUMN_ID_AGENCE +" INTEGER);"	
		);
		db.execSQL(
			"CREATE TABLE IF NOT EXISTS "+ TAUX_TRANSFERT_TABLE_NAME +" ("+
				TAUX_TRANSFERT_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
				TAUX_TRANSFERT_COLUMN_ID_AGENCE +" TEXT, "+
				TAUX_TRANSFERT_COLUMN_MONTANTMIN +" INTEGER, "+
				TAUX_TRANSFERT_COLUMN_MONTANTMAX +" INTEGER, "+
				TAUX_TRANSFERT_COLUMN_TAUX +" INTEGER);"
		);
		this.insertAgences(db);
		this.insertSousAgences(db);
		this.insertTaux(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS "+AGENCE_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+SOUS_AGENCE_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS "+TAUX_TRANSFERT_TABLE_NAME);
		onCreate(db);
	}
	
	public boolean insertAgences(SQLiteDatabase db){
		
		ContentValues cv1 = new ContentValues();
		cv1.put(AGENCE_COLUMN_NAME, "Campost");
		cv1.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie Campost");
		cv1.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv1.put(AGENCE_COLUMN_LOGO, "campost");
		ContentValues cv2 = new ContentValues();
		cv2.put(AGENCE_COLUMN_NAME, "C-CASH");
		cv2.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie C-CASH");
		cv2.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv2.put(AGENCE_COLUMN_LOGO, "c_cash");
		ContentValues cv3 = new ContentValues();
		cv3.put(AGENCE_COLUMN_NAME, "Emi Money");
		cv3.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie Emi Money");
		cv3.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv3.put(AGENCE_COLUMN_LOGO, "emi_money");
		ContentValues cv4 = new ContentValues();
		cv4.put(AGENCE_COLUMN_NAME, "Express Exchange");
		cv4.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie Express Exchange");
		cv4.put(AGENCE_COLUMN_VILLE, "Yaoundé,Douala,Bangangté,Bertoua,Batouri,Belabo,Nguelemendouka,Yokadouma," +
				"Dimako,Lomie,Maroua,Kousseri,Mora,Bafang,Bafoussam,Bandjoun,Dschang,Buea,Limbe,Kumba");
		cv4.put(AGENCE_COLUMN_LOGO, "express_exchange");
		ContentValues cv5 = new ContentValues();
		cv5.put(AGENCE_COLUMN_NAME, "Express Union");
		cv5.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie Express Union");
		cv5.put(AGENCE_COLUMN_VILLE, "Yaoundé,Bertoua,Batouri,Belabo,Nguelemendouka,Yokadouma," +
				"Dimako,Lomie,Maroua,Kousseri,Mora,Bafang,Bafoussam,Bandjoun,Dschang,Buea,Limbe,Kumba");
		cv5.put(AGENCE_COLUMN_LOGO, "express_union");
		ContentValues cv6 = new ContentValues();
		cv6.put(AGENCE_COLUMN_NAME, "moneyGram");
		cv6.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie MoneyGram");
		cv6.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv6.put(AGENCE_COLUMN_LOGO, "money_gram");
		ContentValues cv7 = new ContentValues();
		cv7.put(AGENCE_COLUMN_NAME, "MTN Money");
		cv7.put(AGENCE_COLUMN_DESCRIPTION, "Compagne MTN Money");
		cv7.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv7.put(AGENCE_COLUMN_LOGO, "mtn_money");
		ContentValues cv8 = new ContentValues();
		cv8.put(AGENCE_COLUMN_NAME, "Orange Money");
		cv8.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie Orange Money");
		cv8.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv8.put(AGENCE_COLUMN_LOGO, "orange_money");
		ContentValues cv9 = new ContentValues();
		cv9.put(AGENCE_COLUMN_NAME, "Western Union");
		cv9.put(AGENCE_COLUMN_DESCRIPTION, "Compagnie Western Union");
		cv9.put(AGENCE_COLUMN_VILLE, "Yaoundé");
		cv9.put(AGENCE_COLUMN_LOGO, "western_union");
		db.insert(AGENCE_TABLE_NAME, null, cv1);
		db.insert(AGENCE_TABLE_NAME, null, cv2);
		db.insert(AGENCE_TABLE_NAME, null, cv3);
		db.insert(AGENCE_TABLE_NAME, null, cv4);
		db.insert(AGENCE_TABLE_NAME, null, cv5);
		db.insert(AGENCE_TABLE_NAME, null, cv6);
		db.insert(AGENCE_TABLE_NAME, null, cv7);
		db.insert(AGENCE_TABLE_NAME, null, cv8);
		db.insert(AGENCE_TABLE_NAME, null, cv9);
		return true;
	}
	
	public boolean insertSousAgences(SQLiteDatabase db){
		
		ContentValues cv1 = new ContentValues();
		cv1.put(SOUS_AGENCE_COLUMN_NAME, "Campost");
		ContentValues cv2 = new ContentValues();
		cv2.put(SOUS_AGENCE_COLUMN_NAME, "C-CASH");
		ContentValues cv3 = new ContentValues();
		cv3.put(SOUS_AGENCE_COLUMN_NAME, "Emi Money");
		ContentValues cv4 = new ContentValues();
		cv4.put(SOUS_AGENCE_COLUMN_NAME, "Express Exchange");
		ContentValues cv5 = new ContentValues();
		cv5.put(SOUS_AGENCE_COLUMN_NAME, "Byemassie");
		cv5.put(SOUS_AGENCE_COLUMN_VILLE, "Yaoundé");
		cv5.put(SOUS_AGENCE_COLUMN_ID_AGENCE, "Express Union");
		ContentValues cv6 = new ContentValues();
		cv6.put(SOUS_AGENCE_COLUMN_NAME, "Etoudi");
		cv6.put(SOUS_AGENCE_COLUMN_VILLE, "Yaoundé");
		cv6.put(SOUS_AGENCE_COLUMN_ID_AGENCE, "MoneyGram");
		ContentValues cv7 = new ContentValues();
		cv7.put(SOUS_AGENCE_COLUMN_NAME, "MTN Money");
		ContentValues cv8 = new ContentValues();
		cv8.put(SOUS_AGENCE_COLUMN_NAME, "Orange Money");
		ContentValues cv9 = new ContentValues();
		cv9.put(SOUS_AGENCE_COLUMN_NAME, "Western Union");
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv1);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv2);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv3);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv4);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv5);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv6);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv7);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv8);
		db.insert(SOUS_AGENCE_TABLE_NAME, null, cv9);
		return true;
	}
	
	public boolean insertTaux(SQLiteDatabase db){
		
		ContentValues cv1 = new ContentValues();
		cv1.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv1.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 1);
		cv1.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 15000);
		cv1.put(TAUX_TRANSFERT_COLUMN_TAUX, 400);
		ContentValues cv2 = new ContentValues();
		cv2.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv2.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 15001);
		cv2.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 25000);
		cv2.put(TAUX_TRANSFERT_COLUMN_TAUX, 500);
		ContentValues cv3 = new ContentValues();
		cv3.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv3.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 25001);
		cv3.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 50000);
		cv3.put(TAUX_TRANSFERT_COLUMN_TAUX, 1000);
		ContentValues cv7 = new ContentValues();
		cv7.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv7.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 50001);
		cv7.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 75000);
		cv7.put(TAUX_TRANSFERT_COLUMN_TAUX, 1500);
		ContentValues cv8 = new ContentValues();
		cv8.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv8.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 75001);
		cv8.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 100000);
		cv8.put(TAUX_TRANSFERT_COLUMN_TAUX, 2000);
		ContentValues cv19 = new ContentValues();
		cv19.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv19.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 100001);
		cv19.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 200000);
		cv19.put(TAUX_TRANSFERT_COLUMN_TAUX, 2300);
		ContentValues cv18 = new ContentValues();
		cv18.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv18.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 200001);
		cv18.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 300000);
		cv18.put(TAUX_TRANSFERT_COLUMN_TAUX, 2600);
		ContentValues cv17 = new ContentValues();
		cv17.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv17.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 300001);
		cv17.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 400000);
		cv17.put(TAUX_TRANSFERT_COLUMN_TAUX, 3700);
		ContentValues cv16 = new ContentValues();
		cv16.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Exchange");
		cv16.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 400001);
		cv16.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 5800000);
		cv16.put(TAUX_TRANSFERT_COLUMN_TAUX, 17000);
		ContentValues cv4 = new ContentValues();
		cv4.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Union");
		cv4.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 1);
		cv4.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 10000);
		cv4.put(TAUX_TRANSFERT_COLUMN_TAUX, 400);
		ContentValues cv5 = new ContentValues();
		cv5.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Express Union");
		cv5.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 15001);
		cv5.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 25000);
		cv5.put(TAUX_TRANSFERT_COLUMN_TAUX, 600);
		ContentValues cv6 = new ContentValues();
		ContentValues cv12 = new ContentValues();
		cv12.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "MTN Money");
		cv12.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 5);
		cv12.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 5000);
		cv12.put(TAUX_TRANSFERT_COLUMN_TAUX, 100);
		ContentValues cv13 = new ContentValues();
		cv13.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "MTN Money");
		cv13.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 5005);
		cv13.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 25000);
		cv13.put(TAUX_TRANSFERT_COLUMN_TAUX, 250);
		ContentValues cv14 = new ContentValues();
		cv14.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "MTN Money");
		cv14.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 25005);
		cv14.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 50000);
		cv14.put(TAUX_TRANSFERT_COLUMN_TAUX, 500);
		ContentValues cv15 = new ContentValues();
		cv15.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "MTN Money");
		cv15.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 50005);
		cv15.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 100000);
		cv15.put(TAUX_TRANSFERT_COLUMN_TAUX, 700);
		cv6.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Orange Money");
		cv6.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 100);
		cv6.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 5000);
		cv6.put(TAUX_TRANSFERT_COLUMN_TAUX, 200);
		ContentValues cv9 = new ContentValues();
		cv9.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Orange Money");
		cv9.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 5001);
		cv9.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 10000);
		cv9.put(TAUX_TRANSFERT_COLUMN_TAUX, 250);
		ContentValues cv10 = new ContentValues();
		cv10.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Orange Money");
		cv10.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 10001);
		cv10.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 25000);
		cv10.put(TAUX_TRANSFERT_COLUMN_TAUX, 500);
		ContentValues cv11 = new ContentValues();
		cv11.put(TAUX_TRANSFERT_COLUMN_ID_AGENCE, "Orange Money");
		cv11.put(TAUX_TRANSFERT_COLUMN_MONTANTMIN, 25001);
		cv11.put(TAUX_TRANSFERT_COLUMN_MONTANTMAX, 30000);
		cv11.put(TAUX_TRANSFERT_COLUMN_TAUX, 850);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv1);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv2);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv3);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv7);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv8);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv4);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv5);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv12);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv13);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv14);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv15);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv6);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv9);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv10);
		db.insert(TAUX_TRANSFERT_TABLE_NAME, null, cv11);
		return true;
	}
	
	/**
	 * Cette méthode permettra de récupérer toutes les agences sans critères de choix
	 * */
	public ArrayList<String> getAllAgences(){

		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> array_list = new ArrayList<String>();
		Cursor res = db.rawQuery("select * from "+ AGENCE_TABLE_NAME, null);
		res.moveToFirst();
		
		while(!res.isAfterLast()){
			array_list.add(res.getString(res.getColumnIndex(AGENCE_COLUMN_NAME)));
			res.moveToNext();
		}
		return array_list;
	}
	
	public ArrayList<ArrayList<String>> getAllSousAgencces(){

		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> array_list0 = new ArrayList<String>();
		ArrayList<ArrayList<String>> array_list = new ArrayList<ArrayList<String>>();
		Cursor res = db.rawQuery("select * from "+ SOUS_AGENCE_TABLE_NAME +" where "+ SOUS_AGENCE_COLUMN_ID_AGENCE+ "= 'Express Union'", null);
		res.moveToFirst();
		
		if(res.getCount()<=0){
			return null;
		}
		
		while(!res.isAfterLast()){
			array_list0.add(res.getString(res.getColumnIndex(SOUS_AGENCE_COLUMN_NAME)));
			array_list0.add(res.getString(res.getColumnIndex(SOUS_AGENCE_COLUMN_VILLE)));
			array_list.add(array_list0);
			res.moveToNext();
		}
		
		return array_list;
	}
	
	/**
	 * Cette méthode permettra de récupérer toutes les agences et le taux de transfert correspondant au montant renseigné, 
	 * en fonction de la ville d'origine et celle de destination
	 * @param montant c'est le montant que l'utilisateur souhaite transférer 
	 * @param origine c'est la ville d'origine
	 * @param destination c'est la ville de destination
	 * */
	public ArrayList<String> getTauxAgences(int montant, String origine, String destination){
		
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<String> array_list = new ArrayList<String>();
		String requête = "select "+ TAUX_TRANSFERT_COLUMN_ID_AGENCE+", "+ TAUX_TRANSFERT_COLUMN_TAUX+
						" from "+ TAUX_TRANSFERT_TABLE_NAME +
						" where "+ TAUX_TRANSFERT_COLUMN_MONTANTMIN+ "<= "+montant+
						" and "+montant+" <="+ TAUX_TRANSFERT_COLUMN_MONTANTMAX+
						" and "+ TAUX_TRANSFERT_COLUMN_ID_AGENCE +" in " +
						"(select " +AGENCE_COLUMN_NAME +" from " + AGENCE_TABLE_NAME+
						" where " +AGENCE_COLUMN_VILLE +" like '%"+origine+"%' and "+AGENCE_COLUMN_VILLE+" like '%"+destination+"%')";

		Cursor res = db.rawQuery(requête+";", null);
		
		Cursor res1 = db.rawQuery(
				"select "+AGENCE_COLUMN_LOGO+ 
				" from "+AGENCE_TABLE_NAME+
				" where "+AGENCE_COLUMN_NAME+
				" in (select "+TAUX_TRANSFERT_COLUMN_ID_AGENCE+" from ("+requête+"));", null);
		
		if(res.getCount()<=0 || res1.getCount()<=0){
			if(res1.getCount()<=0){
				System.out.println("Requête échouée");
			}
			return null;
		}
		
		res.moveToFirst();
		res1.moveToFirst();
		
		System.out.println("Requête réussie");
		while(!res.isAfterLast()&& !res1.isAfterLast()){
			array_list.add(res.getString(res.getColumnIndex(TAUX_TRANSFERT_COLUMN_ID_AGENCE)));
			array_list.add(res.getString(res.getColumnIndex(TAUX_TRANSFERT_COLUMN_TAUX)));
			array_list.add(res1.getString(res1.getColumnIndex(AGENCE_COLUMN_LOGO)));
			System.out.println(array_list);
			res.moveToNext();
			res1.moveToNext();
		}
		
		return array_list;
	}
}












