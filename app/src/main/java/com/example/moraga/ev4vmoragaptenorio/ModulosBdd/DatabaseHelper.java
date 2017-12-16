package com.example.moraga.ev4vmoragaptenorio.ModulosBdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.moraga.ev4vmoragaptenorio.R;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME="bd_st.db";
    private static final int DB_VERSION=2;
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCiudades="CREATE TABLE CIUDADES("+"_id INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE_CIUDAD TEXT, REGION TEXT, ESTADO TEXT);";
        String sqlLocales="CREATE TABLE LOCALES("+"_id INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE_LOCAL TEXT, TELEFONO INTEGER, EMAIL TEXT, DIRECCION TEXT, FECHA_CREACION TEXT , ESTADO TEXT, CIUDAD_ID INTEGER , FOTOID INTEGER );";
        String sqlClientes="CREATE TABLE CLIENTES("+"_id INTEGER PRIMARY KEY AUTOINCREMENT, RUT TEXT, NOMBRE_CLIENTE TEXT, APEPAT TEXT, APEMAT TEXT, TELEFONO INETEGER, EMAIL TEXT, FECHA_CREACION TEXT, CIUDAD_ID INTEGER , ESTADO TEXT);";
        String sqlDirecciones="CREATE TABLE DIRECCIONES("+"_id INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE_CALLE TEXT, NUMERO_CALLE INTEGER, FECHA_CREACION TEXT, LOCAL_ID INTEGER, ESTADO TEXT);";
        sqLiteDatabase.execSQL(sqlCiudades);
        sqLiteDatabase.execSQL(sqlClientes);
        sqLiteDatabase.execSQL(sqlLocales);
        sqLiteDatabase.execSQL(sqlDirecciones);
        sqLiteDatabase.execSQL("INSERT INTO DIRECCIONES(NOMBRE_CALLE, NUMERO_CALLE, FECHA_CREACION, LOCAL_ID, ESTADO) VALUES('COLON', 0355, '10-05-2016', 1 , 'ACTIVO');");
        Localadd(sqLiteDatabase);
        Ciudadadd(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CLIENTES");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CIUDADES");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DIRECCIONES");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOCALES");
        onCreate(sqLiteDatabase);
    }
    public void Localadd(SQLiteDatabase sqLiteDatabase){
        addLocal(sqLiteDatabase, new Locales("GLOBUS COMPUTACION",612224847,"ventas@globuscomputacion.cl","CARLOS BORIES 546","15-12-2017","ACTIVO",1,R.drawable.globus));
        addLocal(sqLiteDatabase, new Locales("JORESCOM LTDA.",612371212,"contacto@jorescom.cl","CRISTOBAL COLON 815","15-12-2017","ACTIVO",1,R.drawable.jorescomltda));
        addLocal(sqLiteDatabase, new Locales("SISTEMAS INFORMATICOS",963060229,"ventas@sistemasiinformaticos.cl","ESPAÑA 1032","15-12-2017","ACTIVO",1,R.drawable.sistemasinformaticos));
    }
    public void addLocal(SQLiteDatabase sqLiteDatabase, Locales locales){
        ContentValues values=new ContentValues();
        values.put("NOMBRE_LOCAL", locales.getNombreLocal());
        values.put("TELEFONO", locales.getTelefonoLocal());
        values.put("EMAIL", locales.getEmailLocal());
        values.put("DIRECCION", locales.getDireccion());
        values.put("FECHA_CREACION", locales.getFechaLocal());
        values.put("ESTADO", locales.getEstado());
        values.put("CIUDAD_ID", locales.getCiudadidL());
        values.put("FOTOID", locales.getFotoId());
        sqLiteDatabase.insert("LOCALES",null,values);
    }
    public void Ciudadadd(SQLiteDatabase sqLiteDatabase){
        addCiudad(sqLiteDatabase, new Ciudades("PUNTA ARENAS","MAGALLANES Y ANTARTICA CHILENA","ACTIVO"));
        addCiudad(sqLiteDatabase, new Ciudades("PUERTO NATALES","MAGALLANES Y ANTARTICA CHILENA","ACTIVO"));
        addCiudad(sqLiteDatabase, new Ciudades("PORVENIR","MAGALLANES Y ANTARTICA CHILENA","ACTIVO"));
        addCiudad(sqLiteDatabase, new Ciudades("PUERTO MONTT","LOS LAGOS","ACTIVO"));
        addCiudad(sqLiteDatabase, new Ciudades("VALDIVIA","LOS RIOS","ACTIVO"));
    }
    public void addCiudad(SQLiteDatabase sqLiteDatabase, Ciudades ciudades){
        ContentValues values=new ContentValues();
        values.put("NOMBRE_CIUDAD", ciudades.getNombreCiudad());
        values.put("REGION", ciudades.getRegion());
        values.put("ESTADO", ciudades.getEstado());
        sqLiteDatabase.insert("CIUDADES",null,values);
    }
    public List<Ciudades> listaciudades(){
        List<Ciudades> ciudades=new ArrayList<>();
        String sqlTxt="SELECT NOMBRE_CIUDAD, REGION, ESTADO FROM CIUDADES WHERE ESTADO='ACTIVO'";
        try {
            Cursor cursor=getReadableDatabase().rawQuery(sqlTxt,null);
            cursor.moveToFirst();
            do{
                ciudades.add(new Ciudades(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
            cursor.close();
        }catch (CursorIndexOutOfBoundsException e){
            ciudades=null;
        }
        return ciudades;
    }
    public void ingresarCliente(Clientes clientes){
        ContentValues valores=new ContentValues();
        valores.put("RUT", clientes.getRut());
        valores.put("NOMBRE_CLIENTE", clientes.getNombreCliente());
        valores.put("APEPAT", clientes.getApepat());
        valores.put("APEMAT", clientes.getApemat());
        valores.put("TELEFONO", clientes.getTelefonoCliente());
        valores.put("EMAIL", clientes.getEmailCliente());
        valores.put("FECHA_CREACION", clientes.getFechaCliente());
        valores.put("CIUDAD_ID", clientes.getCiudadidC());
        valores.put("ESTADO", clientes.getEstado());
        getWritableDatabase().insert("CLIENTES",null,valores);
    }
    public List<Clientes> listaclientes(){
        List<Clientes> clientes=new ArrayList<>();
        String sqlTxt="SELECT RUT, NOMBRE_CLIENTE, APEPAT, APEMAT, TELEFONO, EMAIL, FECHA_CREACION, CIUDAD_ID, ESTADO FROM CLIENTES WHERE ESTADO='ACTIVO'";
        try{
            Cursor cursor=getReadableDatabase().rawQuery(sqlTxt,null);
            cursor.moveToFirst();
            do{
                clientes.add(new Clientes(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7),cursor.getString(8)));
            }while (cursor.moveToNext());
            cursor.close();

        }catch (CursorIndexOutOfBoundsException e){
            clientes=null;
        }
        return clientes;
    }
    public List<Locales> localesList(){
        List<Locales> locales=new ArrayList<>();
        String sqlTxt="SELECT NOMBRE_LOCAL, TELEFONO, EMAIL, DIRECCION, FECHA_CREACION, ESTADO, CIUDAD_ID, FOTOID FROM LOCALES";
        try {
            Cursor cursor=getReadableDatabase().rawQuery(sqlTxt,null);
            cursor.moveToFirst();
            Locales local;
            do {
                local=new Locales(cursor.getString(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6),cursor.getInt(7));
                locales.add(local);
            }while (cursor.moveToNext());
        }catch (SQLiteException e){
            locales=null;
        }
        return locales;
    }
    public Locales idLocal(int id){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.query("LOCALES",new String[]{"_id"},"_id=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        Locales locales = new Locales(cursor.getInt(0));
        cursor.close();
        return locales;
    }
    public String[] LocalDatos(int id){
        Cursor cursor=getWritableDatabase().rawQuery("SELECT NOMBRE_LOCAL, TELEFONO, EMAIL, DIRECCION, FOTOID FROM LOCALES WHERE _id=?",new String[]{String.valueOf(id)});
        if(cursor!=null)
            cursor.moveToFirst();
        String NL=cursor.getString(0);
        int TF=cursor.getInt(1);
        String EL=cursor.getString(2);
        String DL=cursor.getString(3);
        int FI=cursor.getInt(4);
        String TFS= String.valueOf(TF);
        String FIS= String.valueOf(FI);
        String[] LocalDatos = new String[]{NL,TFS,EL,DL,FIS};
        return LocalDatos;
    }
}