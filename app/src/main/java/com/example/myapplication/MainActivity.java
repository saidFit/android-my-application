package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.myapplication.users.User;

import assets.UserInfo;

public class MainActivity extends AppCompatActivity {

    private UserInfo userInfo;
    private TextView textResult;
    @Override
    // ...
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("info","hello world");
        LinearLayout linearLayout = findViewById(R.id.parentLayout);
        User[] users = {
                new User("example1", "example1@gmail.com", "morocco"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                new User("example2", "example2@gmail.com", "usa"),
                // Add more items as needed
        };

//        for(User user : users){
//            LinearLayout divLayout = new LinearLayout(this);
//            divLayout.setOrientation(LinearLayout.VERTICAL);
//            divLayout.setBackgroundResource(R.drawable.custom_div_layout_bg);
//
//            ImageView deleteIcon = new ImageView(this);
//            deleteIcon.setImageResource(R.drawable.ic_delete);
//
//            TextView nameTextView = new TextView(this);
//            nameTextView.setText("Name: " + user.getName());
//
//            TextView emailTextView = new TextView(this);
//            emailTextView.setText("Email: " + user.getEmail());
//
//            divLayout.addView(nameTextView);
//            divLayout.addView(emailTextView);
//            divLayout.addView(deleteIcon);
//
//            linearLayout.addView(divLayout);
//        }




        // Initialize UserInfoManager and set UI components
        int nextId = View.generateViewId(); // Generate a unique ID for views
        for (User user : users) {
            // Create a LinearLayout as a container for the item
            LinearLayout divLayout = new LinearLayout(this);
            divLayout.setOrientation(LinearLayout.HORIZONTAL);
            divLayout.setBackgroundResource(R.drawable.custom_div_layout_bg);
            // Create a ConstraintLayout to achieve the desired structure
            ConstraintLayout itemLayout = new ConstraintLayout(this);

            // Create TextViews for item details
            TextView nameTextView = new TextView(this);
            nameTextView.setText("Name: " + user.getName());
            nameTextView.setId(nextId++); // Set a unique ID for nameTextView

            TextView emailTextView = new TextView(this);
            emailTextView.setText("Email: " + user.getEmail());
            emailTextView.setId(nextId++); // Set a unique ID for emailTextView

            // Create an ImageView for the delete icon
            ImageView deleteIcon = new ImageView(this);
            deleteIcon.setImageResource(R.drawable.ic_delete);

            // Set IDs for views (important for ConstraintLayout constraints)
            itemLayout.setId(nextId++); // Set an ID for the itemLayout
            deleteIcon.setId(nextId++); // Set an ID for deleteIcon

            // Add views to the itemLayout with appropriate constraints
            itemLayout.addView(nameTextView);
            itemLayout.addView(emailTextView);
            itemLayout.addView(deleteIcon);

            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(itemLayout);

            // Center name and email vertically
            constraintSet.centerVertically(nameTextView.getId(), ConstraintSet.PARENT_ID);
            constraintSet.centerVertically(emailTextView.getId(), ConstraintSet.PARENT_ID);

            // Position name and email to the start of the layout
            constraintSet.connect(nameTextView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            constraintSet.connect(emailTextView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);

            // Position delete icon to the end of the layout
            constraintSet.connect(deleteIcon.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            // Apply constraints
            constraintSet.applyTo(itemLayout);

            // Add the itemLayout to the divLayout
            divLayout.addView(itemLayout);

            // Add the divLayout to the parentLayout as before
            linearLayout.addView(divLayout);
        }



        userInfo = new UserInfo();
        userInfo.setEditTextName(findViewById(R.id.editTextName));
        userInfo.setEditTextEmail(findViewById(R.id.editTextEmail));
        userInfo.setEditTextPhone(findViewById(R.id.editTextPhone));
        userInfo.setButtonSubmit(findViewById(R.id.buttonSubmit));
        textResult = (findViewById(R.id.TextViewResult));
        userInfo.getButtonSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user inputs
                String name = userInfo.getEditTextName().getText().toString();
                String email = userInfo.getEditTextEmail().getText().toString();
                String phone = userInfo.getEditTextPhone().getText().toString();
                // Display a toast message with the collected information
                final Handler handler = new Handler();
                String message = "<b><font color='#FF5733'>info:</font></b> Name: " + name + "\nEmail: " + email+ "\nPhone: " + phone;
                // Set the formatted text to the TextView with HTML formatting
                 if(name.isEmpty() || email.isEmpty() || phone.isEmpty()){
                     return;
                 }
                textResult.setText(Html.fromHtml(message));
                // Make sure the TextView is set to VISIBLE
                textResult.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                  // Hide the TextView after 3 seconds
                     textResult.setVisibility(View.GONE);
                    }
                },3000);
            }
        });

        // Set up a touch event listener for the root layout
        View rootView = findViewById(android.R.id.content);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Check if the touch event is outside of the EditText views

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!isTouchInsideView(userInfo.getEditTextName(), motionEvent) &&
                            !isTouchInsideView(userInfo.getEditTextEmail(), motionEvent)) {
                        // Hide the keyboard
                        hideKeyboard();
                    }
                }
                return false;
            }
        });
    }

// ...

    public void disabled(View Button){
        Button.setEnabled(false);
    }
    // Helper method to check if a touch event is inside a view
    private boolean isTouchInsideView(View view, MotionEvent event) {

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int viewX = location[0];
        int viewY = location[1];
        int touchX = (int) event.getRawX();
        int touchY = (int) event.getRawY();
        System.out.println(viewX+","+viewY+","+touchX+","+touchY+","+view.getWidth()+","+view.getHeight());
        boolean isInside =  touchX >= viewX && touchX <= viewX + view.getWidth() &&
                touchY >= viewY && touchY <= viewY + view.getHeight();
        return isInside;
    }

    // Helper method to hide the keyboard
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(userInfo.getEditTextName().getWindowToken(), 0);
            imm.hideSoftInputFromWindow(userInfo.getEditTextEmail().getWindowToken(), 0);

        }
    }
}
