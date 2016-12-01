package com.example.oscar.canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import static android.R.attr.path;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rectangulo) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout1);
            Lienzo fondo = new Lienzo(this);
            layout.addView(fondo);



        } else if (id == R.id.nav_circulo) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout1);
            Lienzo2 fondo2 = new Lienzo2(this);
            layout.addView(fondo2);
        } else if (id == R.id.nav_dibujar) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout1);
            Lienzo4 fondo4 = new Lienzo4(this);
            layout.addView(fondo4);

        } else if (id == R.id.nav_cuadrado) {
            RelativeLayout layout = (RelativeLayout) findViewById(R.id.Layout1);
            Lienzo3 fondo3 = new Lienzo3(this);
            layout.addView(fondo3);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*public class DrawDemo extends Activity {
        InternalView myView;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            super.onCreate(savedInstanceState);
            myView = new InternalView(this);
            setContentView(myView);
        }
        private class InternalView extends View{
            public InternalView(Context context){
                super(context);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.BLUE);
                canvas.drawPaint(paint);
                paint.setColor(Color.BLACK);
                paint.setAntiAlias(true);
                canvas.drawRect(16, 16, getWidth()-16, getHeight()-16, paint);

            }
        }
    }*/

    private class Lienzo extends View{
        Path path=new Path();
        float x=50;
        float y=50;
        String accion = "Nada";
        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            Paint pincel1=new Paint();

            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion == "move"){
                path.lineTo(x,y);
            }
            canvas.drawPath(path, pincel1);
            pincel1.setARGB(255,100,255,100);
            canvas.drawRect(x,y,x+150,y+200,pincel1);


        }

        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }

    private class Lienzo3 extends View{
        Path path=new Path();
        float x=50;
        float y=50;
        String accion = "Nada";
        public Lienzo3(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            Paint pincel1=new Paint();

            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion == "move"){
                path.lineTo(x,y);
            }
            canvas.drawPath(path, pincel1);
            pincel1.setARGB(255,0,0,255);
            canvas.drawRect(x,y,x+150,y+150,pincel1);


        }

        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }

    private class Lienzo2 extends View{
        Path path=new Path();
        float x=50;
        float y=50;
        String accion = "Nada";

        public Lienzo2(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            Paint pincel1=new Paint();

            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion == "move"){
                path.lineTo(x,y);
            }
            canvas.drawPath(path, pincel1);
            pincel1.setARGB(255,255,255,0);
            canvas.drawCircle(x,y,100,pincel1);

        }

        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }


    private class Lienzo4 extends View{
        Path path=new Path();
        float x=50;
        float y=50;
        String accion = "Nada";
        public Lienzo4(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            paint.setColor(Color.argb(250,255,70,200));

            if(accion == "down"){
                path.moveTo(x,y);
            }
            if(accion == "move"){
                path.lineTo(x,y);
            }
            canvas.drawPath(path, paint);


        }
        public boolean onTouchEvent(MotionEvent evento){
            int axion = evento.getAction();
            x=evento.getX();
            y=evento.getY();

            if(axion == MotionEvent.ACTION_DOWN){
                accion = "down";
            }
            if(axion == MotionEvent.ACTION_MOVE){
                accion = "move";
            }
            invalidate();
            return true;
        }

    }






}
