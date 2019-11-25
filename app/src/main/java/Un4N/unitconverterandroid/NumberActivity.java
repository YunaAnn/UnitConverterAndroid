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

    private int binary;
    private int octal;
    private int decimal;
    private String hex = "";

    private int remainder;
    private int i;
    private int step;

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
                octal = 0;
                decimal = 0;
                hex = " ";
                binaryConvertion();
            }
        });

        octalButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                binary = 0;
                decimal = 0;
                hex = " ";
                octalConvertion();
            }
        });

        decimalButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                binary = 0;
                octal = 0;
                hex = " ";
                decimalConvertion();
            }
        });

        hexButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                binary = 0;
                octal = 0;
                decimal = 0;
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
        binaryBox.setText(" ");
        octalBox.setText(" ");
        decimalBox.setText(" ");
        hexBox.setText(" ");
        status.setText("Status : OK");
    }

    private void binaryConvertion()
    {
        try
        {
            binary = Integer.parseInt(binaryBox.getText().toString());
            /*Octal*/
            octalBox.setText(String.valueOf(binaryToOctal(binary)));
            /*decimal*/
            decimalBox.setText(String.valueOf(binaryToDecimal(binary)));
            /*hex*/
            hexBox.setText(String.valueOf(binaryToHex(binary)));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : No data inserted. Try again. Error -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private int binaryToOctal(int binary)
    {
        i = 0;
        while(binary != 0)
        {
            decimal += (binary % 10) * Math.pow(2,i);
            ++i;
            binary/=10;
        }
        i = 1;
        while (decimal != 0)
        {
            octal += (decimal % 8) * i;
            decimal /= 8;
            i *= 10;
        }
        return octal;
    }

    private int binaryToDecimal(int binary)
    {
        i = 0;
        while (binary != 0)
        {
            remainder = binary % 10;
            binary /= 10;
            decimal += remainder * Math.pow(2,i);
            ++i;
        }
        return decimal;
    }

    private String binaryToHex(int binary)
    {

    return hex;
    }

    private void octalConvertion()
    {
        try
        {
            octal = Integer.parseInt(octalBox.getText().toString());
            /*binary*/
            binaryBox.setText(String.valueOf(octalToBinary(octal)));
            /*decimal*/
            decimalBox.setText(String.valueOf(octalToDecimal(octal)));
            /*hex*/
            hexBox.setText(String.valueOf(octalToHex(octal)));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : No data inserted. Try again. Error -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private int octalToBinary(int octal)
    {
        i = 0;
        while(octal != 0)
        {
            decimal += (octal % 10) * Math.pow(8,i);
            ++i;
            octal /= 10;
        }
        i = 1;
        while (decimal != 0)
        {
            binary += (decimal % 2) * i;
            decimal /= 2;
            i *= 10;
        }
        return binary;
    }

    private int octalToDecimal(int octal)
    {
        i = 0;
        while(octal != 0)
        {
            decimal += (octal % 10) * Math.pow(8,i);
            ++i;
            octal /= 10;
        }
        return decimal;
    }

    private String octalToHex(int octal)
    {
        return hex;
    }

    private void decimalConvertion()
    {
        try
        {
            decimal = Integer.parseInt(decimalBox.getText().toString());
            /*binary*/
            binaryBox.setText(String.valueOf(decimalToBinary(decimal)));
            /*octal*/
            octalBox.setText(String.valueOf(decimalToOctal(decimal)));
             /*hex*/
            hexBox.setText(String.valueOf(decimalToHex(decimal)));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : No data inserted. Try again. Error -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private int decimalToBinary(int decimal)
    {
        step = 1;
        i = 1;
        while (decimal != 0)
        {
            remainder = decimal % 2;
            decimal /= 2;
            binary += remainder * i;
            i *= 10;
        }
        return binary;
    }

    private int decimalToOctal(int decimal)
    {
        i = 1;
        while (decimal != 0)
        {
            octal += (decimal % 8) * i;
            decimal /= 8;
            i *= 10;
        }
        return octal;
    }

    private String decimalToHex(int decimal)
    {
        return hex;
    }


    private void hexConvertion()
    {
        try
        {
            hex = decimalBox.getText().toString();
            /*binary*/
            binaryBox.setText(String.valueOf(hexToBinary(hex)));
            /*octal*/
            octalBox.setText(String.valueOf(hexToOctal(hex)));
            /*decimal*/
            decimalBox.setText(String.valueOf(hexToDecimal(hex)));
            status.setText("Status : OK");
        }
        catch(NumberFormatException e)
        {
            status.setText("Status : No data inserted. Try again. Error -> " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            status.setText("Status : Try again. Error ->" + e.getMessage());
            e.printStackTrace();
        }
    }

    private int hexToBinary(String hex)
    {
        return binary;
    }

    private int hexToOctal(String hex)
    {
        return octal;
    }

    private int hexToDecimal(String hex)
    {
        return decimal;
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
