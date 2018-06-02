package com.example.bhagy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editName)
    EditText editName;

    @BindView(R.id.editemail)
    EditText editEmail;

    @BindView(R.id.saveButton)
    Button saveButton;

    @BindView(R.id.getButton)
    Button getButton;

    @BindView(R.id.clearButton)
    Button clearButton;

    @BindView(R.id.nameText)
    TextView nameText;

    @BindView(R.id.emailText)
    TextView emailText;

    private SaveSetting saveSetting = null;

    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Integer> number = new ArrayList<>();
    //hashmap example
    HashMap<String,Integer> map = new HashMap<>();
    static int numberFound = -1;
    Random random = new Random();
    private static String[] result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (null == saveSetting) {
            saveSetting = SaveSetting.getInstance();
            saveSetting.initSetting(getApplicationContext());
        }
        employees.add(new Employee("john", 100));
        employees.add(new Employee("chrstian", 900));
        employees.add(new Employee("ram", 700));
        employees.add(new Employee("alex", 600));

        for (int i = 0; i < 5; i++) {
            number.add(random.nextInt(80) + 20);
        }

        //sorting and searching example
        searchSort();


        map.put("student1", 1);
        map.put("student2",2);
        map.put("student3", 3);
        map.put("student4",4);
        map.remove("student2");
        Log.d("MainActivitymap", "Get student 4: " + map.get("student4").toString());
        Log.d("MainActivitymap",keyInHashMap());
        for(int i :map.values()){
            Log.d("MainActivitymap",String.valueOf(i));
        }
        saveButton.setOnClickListener(btnListener);
        getButton.setOnClickListener(btnListener);
        clearButton.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.saveButton:
                    saveSetting.name = editName.getText().toString();
                    saveSetting.email = editEmail.getText().toString();
                    saveSetting.saveDetails();
                    break;
                case R.id.getButton:

                    break;
                case R.id.clearButton:
                    saveSetting.clear();
                    editEmail.setText("");
                    editName.setText("");
                    break;
            }
            //Setting name and email to textview
            nameText.setText(saveSetting.getName());
            emailText.setText(saveSetting.getEmail());
        }

    };

    public void searchSort() {


        //Print random numbers
        printNumbers(number);

        //print employees
        printEmployess(employees);

        //searching numbers
        numberFound = find(number, 64);
        if (numberFound != -1) {
            Log.d("result", "found");
        } else {
            Log.d("result", "Not found");
        }
       //sorting numbers
        Collections.sort(number, new NumberComparator());
        Log.d("RandomNumbers", "Sorted");
        printNumbers(number);

        //sorting employee
        Collections.sort(employees, new EmployeeComparator());
        Log.d("Employees", "Sorted");
        printEmployess(employees);


    }
//print numbers
    public static void printNumbers(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            Log.d("RandomNumbers", nums.get(i).toString());
        }
    }
//print employee data
    public static void printEmployess(ArrayList<Employee> employeesArrayList) {
        for (Employee e : employeesArrayList) {
            Log.d("Employees", e.getEmployee());
        }
    }

    //Linear search
    public static int find(ArrayList<Integer> numbersArray, Integer target) {


        for (int i = 0; i < numbersArray.size(); i++) {
            if (numbersArray.get(i) == target) {
                Log.d("position", String.valueOf(i));
                numberFound = i;
            }
        }
        return numberFound;
    }
    //check whether key present in  Hashmap
    public String keyInHashMap(){
       return  (map.containsKey("student2")?map.get("student2").toString():"null");

    }
}

