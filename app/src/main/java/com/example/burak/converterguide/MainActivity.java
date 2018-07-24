package com.example.burak.converterguide;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10;
    ImageView imgView,imgTemperature,imgHeight,imgSpeed,imgGas;
    boolean clicked = true;
    Spinner spinnerWeight, spinnerHeight,spinnerVolume,spinnerTemperature,spinnerSpeed;
    TextView support_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        imgView = (ImageView) findViewById(R.id.imgView);
        imgTemperature = (ImageView) findViewById(R.id.imgTemperature);
        imgHeight = (ImageView) findViewById(R.id.imgHeight);
        imgSpeed = (ImageView) findViewById(R.id.imgSpeed);
        imgGas = (ImageView) findViewById(R.id.imgGas);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);
        edit5 = (EditText) findViewById(R.id.edit5);
        edit6 = (EditText) findViewById(R.id.edit6);
        edit7 = (EditText) findViewById(R.id.edit7);
        edit8 = (EditText) findViewById(R.id.edit8);
        edit9 = (EditText) findViewById(R.id.edit9);
        edit10 = (EditText) findViewById(R.id.edit10);


        // add Spinner for volume measurements

        spinnerVolume = (Spinner) findViewById(R.id.spinnerVolume);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterVolume = ArrayAdapter.createFromResource(this,
                R.array.volume_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterVolume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerVolume.setAdapter(adapterVolume);

        spinnerVolume.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinnerVolume.getSelectedItemPosition() == 0) {
                    if (edit9.getText() !=null && edit10.getText() !=null) {
                        edit9.setText( "" );
                        edit10.setText( "" );
                    }
                    edit9.setHint("gallon");
                    edit10.setHint("liter");

                    // call methods for gallon-liter measurements

                    Hints(imgGas,"liter","gallon",edit9, edit10);


                    // call TextWatcher method for gallon-liter ------------------------------------------//

                    TextWatcherforWeight(3.78541,"liter",edit9, edit10);
                }


                if (spinnerVolume.getSelectedItemPosition() == 1) {
                    if (edit9.getText() !=null && edit10.getText() !=null) {
                        edit9.setText( "" );
                        edit10.setText( "" );
                    }
                    edit9.setHint("fluid oz");
                    edit10.setHint("liter");

                    // call methods for gallon-liter measurements

                    Hints(imgGas,"liter","fluid oz",edit9, edit10);


                    // call TextWatcher method for gallon-liter ------------------------------------------//

                    TextWatcherforWeight(0.0295735,"liter",edit9, edit10);


                }


                if (spinnerVolume.getSelectedItemPosition() == 2) {
                    if (edit9.getText() !=null && edit10.getText() !=null) {
                        edit9.setText( "" );
                        edit10.setText( "" );
                    }
                    edit9.setHint("gallon");
                    edit10.setHint("fluid oz");

                    // call methods for gallon-liter measurements

                    Hints(imgGas,"fluid oz","gallon",edit9, edit10);


                    // call TextWatcher method for gallon-liter ------------------------------------------//

                    TextWatcherforWeight(128,"fluid oz",edit9, edit10);

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        // add Spinner for temperature measurements

        spinnerTemperature = (Spinner) findViewById(R.id.spinnerTemperature);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterTemperature = ArrayAdapter.createFromResource(this,
                R.array.temperature_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterTemperature.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTemperature.setAdapter(adapterTemperature);

        spinnerTemperature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinnerTemperature.getSelectedItemPosition() == 0) {
                    if (edit3.getText() !=null && edit4.getText() !=null) {
                        edit3.setText( "" );
                        edit4.setText( "" );
                    }
                    edit3.setHint("°C");
                    edit4.setHint("°F");

                    // call methods for celsius-fahrenheit measurements

                    Hints(imgTemperature,"°F","°C",edit3, edit4);


                    // call TextWatcher method for celsius-fahrenheit ------------------------------------------//

                    TextWatcherforTemperature("°C",edit3,edit4);
                }



                if (spinnerTemperature.getSelectedItemPosition() == 1) {
                    if (edit3.getText() !=null && edit4.getText() !=null) {
                        edit3.setText( "" );
                        edit4.setText( "" );
                    }
                    edit3.setHint("°C");
                    edit4.setHint("°K");

                    // call methods for celsius-kelvin measurements

                    Hints(imgTemperature,"°K","°C",edit3, edit4);


                    // call TextWatcher method for celsius-kelvin ------------------------------------------//

                    TextWatcherforCelsiusKelvin( "°K",edit3,edit4 );


                }


                if (spinnerTemperature.getSelectedItemPosition() == 2) {
                    if (edit3.getText() !=null && edit4.getText() !=null) {
                        edit3.setText( "" );
                        edit4.setText( "" );
                    }
                    edit3.setHint("°F");
                    edit4.setHint("°K");

                    // call methods for gallon-liter measurements

                    Hints(imgTemperature,"°K","°F",edit3, edit4);


                    // call TextWatcher method for gallon-liter ------------------------------------------//

                    TextWatcherforFahrenheitKelvin( "°K",edit3,edit4 );


                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        // add Spinner for weight measurements

        spinnerWeight = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterWeight = ArrayAdapter.createFromResource(this,
                R.array.weight_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerWeight.setAdapter(adapterWeight);

        spinnerWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinnerWeight.getSelectedItemPosition() == 0) {
                    if ( !"".equals( edit1.getText()) && !"".equals( edit2.getText() )) {
                        edit1.setText( "" );
                        edit2.setText( "" );
                    }
                    edit1.setHint("pound");
                    edit2.setHint("kg");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgView,"kg", "pound",edit1,edit2);

                    // call TextWatcher method for pound-kg ------------------------------------------//

                    TextWatcherforWeight(0.453592,"kg",edit1,edit2);

                }


                if (spinnerWeight.getSelectedItemPosition() == 1) {
                    if (edit1.getText() !=null && edit2.getText() !=null) {
                        edit1.setText( "" );
                        edit2.setText( "" );
                    }
                    edit1.setHint("pound");
                    edit2.setHint("ounce");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgView,"ounce", "pound",edit1,edit2);

                    // call TextWatcher method for pound-oz ------------------------------------------//

                    TextWatcherforWeight(16,"ounce",edit1,edit2);
                }


                if (spinnerWeight.getSelectedItemPosition() == 2) {
                    if (edit1.getText() !=null && edit2.getText() !=null) {
                        edit1.setText( "" );
                        edit2.setText( "" );
                    }
                    edit1.setHint("ounce");
                    edit2.setHint("kg");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgView,"kg", "ounce",edit1,edit2);

                    // call TextWatcher method for ounce-kg ------------------------------------------//

                    TextWatcherforWeight(0.0283495,"kg",edit1,edit2);

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        // add Spinner for height measurements

        spinnerHeight = (Spinner) findViewById(R.id.spinnerHeight);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterHeight = ArrayAdapter.createFromResource(this,
                R.array.height_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterHeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerHeight.setAdapter(adapterHeight);

        spinnerHeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinnerHeight.getSelectedItemPosition() == 0) {
                    if (edit5.getText() !=null && edit6.getText() !=null) {
                        edit5.setText( "" );
                        edit6.setText( "" );
                    }
                    edit5.setHint("foot");
                    edit6.setHint("meter");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgHeight,"meter", "foot",edit5,edit6);

                    // call TextWatcher method for foot-meter ------------------------------------------//

                    TextWatcherforWeight(0.3048,"meter",edit5,edit6);

                }


                if (spinnerHeight.getSelectedItemPosition() == 1) {
                    if (edit5.getText() !=null && edit6.getText() !=null) {
                        edit5.setText( "" );
                        edit6.setText( "" );
                    }
                    edit5.setHint("inch");
                    edit6.setHint("meter");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgHeight,"meter", "inch",edit5,edit6);

                    // call TextWatcher method for foot-meter ------------------------------------------//

                    TextWatcherforWeight(0.0254,"meter",edit5,edit6);
                }


                if (spinnerHeight.getSelectedItemPosition() == 2) {
                    if (edit5.getText() !=null && edit6.getText() !=null) {
                        edit5.setText( "" );
                        edit6.setText( "" );
                    }
                    edit5.setHint("foot");
                    edit6.setHint("inch");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgHeight,"inch", "foot",edit5,edit6);

                    // call TextWatcher method for foot-meter ------------------------------------------//

                    TextWatcherforWeight(12,"inch",edit5,edit6);

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        // call methods for mile-km measurements

        Hints(imgSpeed,"km/hr","mi/hr",edit7, edit8);

        TextWatcherforWeight(1.60934,"km/hr",edit7,edit8);



        // add Spinner for speed measurements

        spinnerSpeed = (Spinner) findViewById(R.id.spinnerSpeed);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterSpeed = ArrayAdapter.createFromResource(this,
                R.array.speed_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterSpeed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSpeed.setAdapter(adapterSpeed);

        spinnerSpeed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (spinnerSpeed.getSelectedItemPosition() == 0) {
                    if (edit7.getText() !=null && edit8.getText() !=null) {
                        edit7.setText( "" );
                        edit8.setText( "" );
                    }
                    edit7.setHint("mi/hr");
                    edit8.setHint("km/hr");





                    // call Hints method to swap hints on Edittexts

                    Hints(imgSpeed,"km/hr", "mi/hr",edit7,edit8);

                    // call TextWatcher method for foot-meter ------------------------------------------//

                    TextWatcherforWeight(0.3048,"meter",edit7,edit8);

                }


                if (spinnerSpeed.getSelectedItemPosition() == 1) {
                    if (edit7.getText() !=null && edit8.getText() !=null) {
                        edit7.setText( "" );
                        edit8.setText( "" );
                    }
                    edit7.setHint("ft/sec");
                    edit8.setHint("m/sec");

                    // call Hints method to swap hints on Edittexts

                    Hints(imgSpeed,"m/sec", "ft/sec",edit7,edit8);

                    // call TextWatcher method for foot-meter ------------------------------------------//

                    TextWatcherforWeight(0.3048,"m/sec",edit7,edit8);
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate( R.menu.refresh,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_refresh) {
            edit1.setText("");
            edit2.setText("");
            edit3.setText("");
            edit4.setText("");
            edit5.setText("");
            edit6.setText("");
            edit7.setText("");
            edit8.setText("");
            edit9.setText("");
            edit10.setText("");
        }


        return super.onOptionsItemSelected( item );
    }




    // add focus on touch outside

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }



    // add ClickListener to swap hints on Edittexts

    public void Hints(final ImageView swap_id,final String hint1, final String hint2,final EditText editfirst,
                      final EditText editsecond) {
        swap_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (clicked) {
                    editfirst.setHint(hint1);
                    editsecond.setHint(hint2);

                } if (!clicked) {
                    editfirst.setHint(hint2);
                    editsecond.setHint(hint1);
                }

                clicked = !clicked;

            }
        });

    }

    public void TextWatcherforWeight(final double value, final String measure,final EditText editfirst,
                                     final EditText editsecond) {
        editfirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    double total = Double.parseDouble(editfirst.getText().toString()) * value;
                    editsecond.setText(String.valueOf(total));

                }

                catch (NumberFormatException ex) {

                    //They didn't enter a number.
                    editsecond.setText(null);
                    return;
                }

                finally {
                    if(editfirst.getHint() == measure){
                        try {
                            double total = Double.parseDouble(editfirst.getText().toString()) / value;
                            editsecond.setText(String.valueOf(total));
                        }
                        catch (NumberFormatException ex) {

                            //They didn't enter a number.
                            editsecond.setText(null);
                            return;
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    // TextWatcher for Temperature------------------------------//

    public void TextWatcherforTemperature(final String measure,final EditText editfirst,
                                          final EditText editsecond) {
        editfirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    double fahrenheit = Double.parseDouble(editfirst.getText().toString());

                    double total = (fahrenheit - 32) * 5/9  ;
                    editsecond.setText(String.valueOf(total));

                }

                catch (NumberFormatException ex) {

                    //They didn't enter a number.
                    editsecond.setText(null);
                    return;
                }

                finally {
                    if(editfirst.getHint() == measure){
                        try {
                            double celsius = Double.parseDouble(editfirst.getText().toString());
                            double total =  celsius *  9/5 + 32  ;
                            editsecond.setText(String.valueOf(total));
                        }
                        catch (NumberFormatException ex) {

                            //They didn't enter a number.
                            editsecond.setText(null);
                            return;
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    //   TextWatcher for Temperature-Kelvin   ------------------------------//

    public void TextWatcherforFahrenheitKelvin(final String measure,final EditText editfirst,
                                          final EditText editsecond) {

        editfirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    double fahrenheit = Double.parseDouble(editfirst.getText().toString());

                    double total = (fahrenheit + 459.67) * 5/9  ;
                    editsecond.setText(String.valueOf(total));

                }

                catch (NumberFormatException ex) {

                    //They didn't enter a number.
                    editsecond.setText(null);
                    return;
                }

                finally {
                    if(editfirst.getHint() == measure){
                        try {
                            double kelvin = Double.parseDouble(editfirst.getText().toString());
                            double total =  kelvin *  9/5 - 459.67  ;
                            editsecond.setText(String.valueOf(total));
                        }
                        catch (NumberFormatException ex) {

                            //They didn't enter a number.
                            editsecond.setText(null);
                            return;
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //   TextWatcher for Temperature Celsius-Kelvin   ------------------------------//

    public void TextWatcherforCelsiusKelvin(final String measure,final EditText editfirst,
                                               final EditText editsecond) {

        editfirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    double celsius = Double.parseDouble(editfirst.getText().toString());

                    double total = (celsius + 273.15)  ;
                    editsecond.setText(String.valueOf(total));

                }

                catch (NumberFormatException ex) {

                    //They didn't enter a number.
                    editsecond.setText(null);
                    return;
                }

                finally {
                    if(editfirst.getHint() == measure){
                        try {
                            double kelvin = Double.parseDouble(editfirst.getText().toString());
                            double total =  kelvin - 273.15  ;
                            editsecond.setText(String.valueOf(total));
                        }
                        catch (NumberFormatException ex) {

                            //They didn't enter a number.
                            editsecond.setText(null);
                            return;
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // add intent library to send an e-mail

    public void support(View view) {

        support_id = (TextView) findViewById(R.id.support_id);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"burakozknn@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Support");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}





