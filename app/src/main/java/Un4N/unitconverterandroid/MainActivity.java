package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private double fahrenheit;
    private double celsius;
    private double kelvin;

    private TextInputEditText fahrenheitBox;
    private TextInputEditText celsiusBox;
    private TextInputEditText kelvinBox;
    private Button fahrenheitButton;
    private Button celsiusButton;
    private Button kelvinButton;
    private Button resetButton;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fahrenheitBox = (TextInputEditText) findViewById(R.id.fahrenheit_box);
        celsiusBox = (TextInputEditText) findViewById(R.id.celsius_box);
        kelvinBox = (TextInputEditText) findViewById(R.id.kelvin_box);
        fahrenheitButton = (Button) findViewById(R.id.fahrenheit_button);
        celsiusButton = (Button) findViewById(R.id.celsius_button);
        kelvinButton = (Button) findViewById(R.id.kelvin_button);
        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        fahrenheitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fahrenheitConvertion();
            }
        });

        celsiusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                celsiusConvertion();
            }
        });

        kelvinButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                kelvinConvertion();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                reset();
            }
        });
    }

    private void reset()
    {
        fahrenheitBox.setText(" ");
        celsiusBox.setText(" ");
        kelvinBox.setText(" ");
        status.setText("Status : OK");
    }

    private void fahrenheitConvertion()
    {
        try
        {
            fahrenheit = Double.parseDouble(fahrenheitBox.getText().toString());
            celsius = (fahrenheit - 32) / 1.8;
            kelvin = (fahrenheit + 459.67) / 1.8;
            celsiusBox.setText(String.valueOf(celsius));
            kelvinBox.setText(String.valueOf(kelvin));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void celsiusConvertion()
    {
        try {
            celsius = Double.parseDouble(celsiusBox.getText().toString());
            fahrenheit = celsius * 1.8 + 32;
            kelvin = celsius + 273.15;
            fahrenheitBox.setText(String.valueOf(fahrenheit));
            kelvinBox.setText(String.valueOf(kelvin));
            status.setText("Status : OK");
        }
         catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void kelvinConvertion()
    {
        try
        {
            kelvin = Double.parseDouble(kelvinBox.getText().toString());
            fahrenheit = kelvin * 1.8 - 459.67;
            celsius = kelvin - 273.15;
            fahrenheitBox.setText(String.valueOf(fahrenheit));
            celsiusBox.setText(String.valueOf(celsius));
            status.setText("Status : OK");
        }
         catch(NumberFormatException e)
        {
            status.setText("Status : Try again. Error -> NumberFormatException -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_main)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_length)
        {
            Intent intent = new Intent(this, LengthActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_number)
        {
            Intent intent = new Intent(this, NumberActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
