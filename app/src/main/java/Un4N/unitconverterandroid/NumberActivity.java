package Un4N.unitconverterandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class NumberActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private String binary = "";
    private String octal = "";
    private String decimal = "";
    private String hex = "";

    private TextInputEditText binaryBox;
    private TextInputEditText octalBox;
    private TextInputEditText decimalBox;
    private TextInputEditText hexBox;
    private Button binaryButton;
    private Button octalButton;
    private Button decimalButton;
    private Button hexButton;
    private Button resetButton;
    private TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        binaryBox = (TextInputEditText) findViewById(R.id.binary_box);
        octalBox = (TextInputEditText) findViewById(R.id. octal_box);
        decimalBox = (TextInputEditText) findViewById(R.id.decimal_box);
        hexBox = (TextInputEditText) findViewById(R.id.hex_box);
        binaryButton = (Button) findViewById(R.id.binary_button);
        octalButton = (Button) findViewById(R.id.octal_button);
        decimalButton = (Button) findViewById(R.id.decimal_button);
        hexButton = (Button) findViewById(R.id.hex_button);
        resetButton = (Button) findViewById(R.id.reset);
        status = (TextView) findViewById(R.id.status);

        binaryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                binaryConvertion();
            }
        });

        octalButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                octalConvertion();
            }
        });

        decimalButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                decimalConvertion();
            }
        });

        hexButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                hexConvertion();
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
        binaryBox.setText("");
        octalBox.setText("");
        decimalBox.setText("");
        hexBox.setText("");
        status.setText("Status : OK");
    }

    private void binaryConvertion()
    {
        try
        {
            binary = binaryBox.getText().toString().toLowerCase();
            /*Octal*/
            octalBox.setText(Integer.toOctalString(Integer.parseInt(String.valueOf(binary),2)));
            /*decimal*/
            decimalBox.setText(Integer.toString(Integer.parseInt(String.valueOf(binary),2)));
            /*hex*/
            hexBox.setText(Integer.toHexString(Integer.parseInt(String.valueOf(binary),2)).toUpperCase());
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

    private void octalConvertion()
    {
        try
        {
            octal = octalBox.getText().toString().toLowerCase();
            /*binary*/
            binaryBox.setText(Integer.toBinaryString(Integer.parseInt(String.valueOf(octal),8)));
            /*decimal*/
            decimalBox.setText(Integer.toString(Integer.parseInt(String.valueOf(octal),8)));
            /*hex*/
            hexBox.setText(Integer.toHexString(Integer.parseInt(String.valueOf(octal),8)).toUpperCase());
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

    private void decimalConvertion()
    {
        try
        {
            decimal = decimalBox.getText().toString().toLowerCase();
            /*binary*/
            binaryBox.setText(Integer.toBinaryString(Integer.parseInt(decimal)));
            /*octal*/
            octalBox.setText(Integer.toOctalString(Integer.parseInt(decimal)));
             /*hex*/
            hexBox.setText(Integer.toHexString(Integer.parseInt(decimal)).toUpperCase());
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

    private void hexConvertion()
    {
        try
        {
            hex = hexBox.getText().toString().toLowerCase();
            /*binary*/
           binaryBox.setText(Integer.toBinaryString(Integer.parseInt(String.valueOf(hex),16)));
            /*octal*/
           octalBox.setText(Integer.toOctalString(Integer.parseInt(String.valueOf(hex),16)));
            /*decimal*/
            decimalBox.setText(Integer.toString(Integer.parseInt(String.valueOf(hex),16)));
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
