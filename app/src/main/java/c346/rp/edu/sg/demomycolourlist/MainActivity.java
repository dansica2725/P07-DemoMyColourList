package c346.rp.edu.sg.demomycolourlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et, idEt;
    ListView lv;
    Button add, remove, udpate;

    ArrayList<String> coloursArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);
        idEt = findViewById(R.id.idEt);
        lv = findViewById(R.id.listView);
        add = findViewById(R.id.addColourBtn);
        remove = findViewById(R.id.removeColourBtn);
        udpate = findViewById(R.id.updateColourBtn);

        coloursArray.add("Red");
        coloursArray.add("Orange");

        final ArrayAdapter aaColour = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, coloursArray);
        lv.setAdapter(aaColour);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().length() > 0) {
                    if (idEt.getText().length() == 0) {
                        coloursArray.add(et.getText().toString());
                        aaColour.notifyDataSetChanged();
                    }
                    else {
                        coloursArray.add(Integer.parseInt(idEt.getText().toString()), et.getText().toString());
                        aaColour.notifyDataSetChanged();
                    }
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(idEt.getText().toString());
                if (idEt.getText().length() > 0) {
                    if (index <= coloursArray.size()) {
                        coloursArray.remove(index);
                        aaColour.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No element at index", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        udpate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().length() > 0) {
                    if (idEt.getText().length() > 0) {
                        coloursArray.set(Integer.parseInt(idEt.getText().toString()), et.getText().toString());
                        aaColour.notifyDataSetChanged();
                    }
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour;
                switch (position) {
                    case 0:
                        colour = coloursArray.get(position);
                        Toast.makeText(MainActivity.this, colour , Toast.LENGTH_SHORT).show();
                    case 1:
                        colour = coloursArray.get(position);
                        Toast.makeText(MainActivity.this,  colour, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
