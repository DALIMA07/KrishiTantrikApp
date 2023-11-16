# KrishiTantrikApp
Code of Krishi Tantrik app 


# Basic-Code

## Login Page

### Sign In Button:

```XML
    <Button
           android:layout_width="250dp"
           android:layout_height="wrap_content"
           android:backgroundTint="#FC535550"
           android:id="@+id/sendOTPBtn"
           android:text="Send OTP"
           android:textColor="@color/black"/>

```

```Java

    Button sendOtpBtn = findViewById(R.id.sendOTPBtn);
        sendOtpBtn.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                phoneInput.setError("Phone number not valid");
                return;
            }
            Intent intent = new Intent(LoginActivity.this, OtpverificationActivity.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });

```

### Progress Bar

```XML
    <ProgressBar
           android:layout_width="32dp"
           android:layout_height="wrap_content"
           android:indeterminateTint="@color/black"
           android:layout_gravity="center"
           android:id="@+id/login_progress_bar"/>

```

```Java
        ProgressBar progressBar;
        //at onCreate method
        progressBar = findViewById(R.id.login_progress_bar);
        progressBar.setVisibility(View.GONE);
```

### CountryCode Picker

```XML
        <com.hbb20.CountryCodePicker
            android:id="@+id/editCountryCode"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/rounded_border"
            app:ccp_showFlag="true"
            app:ccp_showNameCode="false"
            app:ccp_showPhoneCode="false" />


```

```Java

        CountryCodePicker countryCodePicker;
        //OnCreate method
        countryCodePicker = findViewById(R.id.editCountryCode);
        countryCodePicker.registerCarrierNumberEditText(phoneInput);

```

## OTP Verification

### Resend Link

```XML
    <LinearLayout

        android:layout_gravity="center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center"
        android:layout_marginTop="30dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Didn't receive OTP ?"/>

        <TextView
            android:id="@+id/resendOTPText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Resend code"
            android:textColor="@color/black"
            android:textStyle="bold"
            android:layout_marginStart="5dp"/>

    </LinearLayout>
```

```Java
    TextView resendOtpTextView;
    //OnCreate Method
    resendOtpTextView = findViewById(R.id.resendOTPText);

    //New Menthod to call the resend Textview
    void startResendTimer(){
        resendOtpTextView.setEnabled(false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeoutSeconds--;
                resendOtpTextView.setText("Resend OTP in "+timeoutSeconds +" seconds");
                if(timeoutSeconds<=0){
                    timeoutSeconds =60L;
                    timer.cancel();
                    runOnUiThread(() -> {
                        resendOtpTextView.setEnabled(true);
                    });
                }
            }
        },0,1000);
    }
```

### Action Bar(Top side)

```XML
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="16dp">
        <ImageView
            android:id="@+id/left_icon"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:src="@drawable/ic_back_arrow"/>

        <TextView
            android:id="@+id/actionbar_title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Title Name"
            android:layout_marginStart="16dp"
            android:textStyle="bold"
            android:layout_centerVertical="true"
            android:layout_toEndOf="@id/left_icon"
            android:textSize="20dp"
            android:textColor="@color/white"/>

        <ImageView
            android:id="@+id/right_icon"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:src="@drawable/ic_menu"
            android:layout_alignParentEnd="true"/>

    </RelativeLayout>

```

```Java


        //OnCreate Method
        ImageView leftIcon = findViewById(R.id.left_icon);
        ImageView rightIcon = findViewById(R.id.right_icon);
        TextView title = findViewById(R.id.actionbar_title);

        leftIcon.setOnClickListener(v -> AndroidUtil.showToast(getApplicationContext(),"You clicked in left icon"));
        rightIcon.setOnClickListener(v -> AndroidUtil.showToast(getApplicationContext(),"You clicked in right icon"));
        title.setText("HOME");
```

### RecyclerView + Bottom Navigation

```XML

<RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerViewMarketItems"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="?attr/actionBarSize"/>

        <com.google.android.material.bottomnavigation.BottomNavigationView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/btnBottomView"
            android:background="#918D8D"
            app:menu="@menu/nav_items"
            android:layout_alignParentBottom="true"/>

    </RelativeLayout>

```

```Java

    //OnCreate Method
    //items for testing
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Soya Bean","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Tomato","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Potato","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Rice","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Wheat","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Sugar Cane","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Bajra","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Jowar","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Corn","Janki Nagar 5 KM","6 oct 2023"));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarketItems);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapterForMarkertView(getApplicationContext(),items));

```

```Java 
    //RecyclerView
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.krishitantrik.R;

        public class MyViewHolderForMarketview  extends RecyclerView.ViewHolder {

            public ImageView increaseIcon;
            public TextView itemName;
            public TextView itemLocation;
            public TextView itemDate;


            public MyViewHolderForMarketview(@NonNull View itemView) {
                super(itemView);

                itemName = itemView.findViewById(R.id.itemName);
                itemLocation = itemView.findViewById(R.id.itemLocation);
                itemDate = itemView.findViewById(R.id.itemDate);
                increaseIcon = itemView.findViewById(R.id.incrementIcon);

            }
        }


```
### MarketViewLayout(Use to implement recycler view)

```XML

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:background="@drawable/rounded_border"
    android:orientation="horizontal">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:id="@+id/itemName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="16dp"
            android:layout_marginTop="1dp"
            android:text="Soya Bean"
            android:textColor="@color/black"
            android:textSize="20sp"
            android:textStyle="bold" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/itemLocation"
            android:text="Janki Nagar 5 KM"
            android:textColor="@color/black"
            android:layout_marginLeft="16dp"
            android:layout_marginTop="2dp"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/itemDate"
            android:text="6 oct 2023"
            android:textColor="@color/black"
            android:layout_marginLeft="16dp"
            android:layout_marginTop="1dp"
            android:layout_marginBottom="1dp"/>

    </LinearLayout>

    <ImageView
        android:id="@+id/incrementIcon"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/green_upward_arrow" />


</LinearLayout>

```
```Java
    //No Java Code required only use Adapter Class

package com.example.krishitantrik.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishitantrik.Class.Item;
import com.example.krishitantrik.R;
import com.example.krishitantrik.RecyclerView.MyViewHolderForMarketview;

import java.util.List;

public class MyAdapterForMarkertView extends RecyclerView.Adapter<MyViewHolderForMarketview> {

    Context context;
    List<Item> items;

    public MyAdapterForMarkertView(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MyViewHolderForMarketview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderForMarketview(LayoutInflater.from(context).inflate(R.layout.market_view_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderForMarketview holder, int position) {

        holder.itemName.setText(items.get(position).getItemName());
        holder.itemLocation.setText(items.get(position).getItemLocation());
        holder.itemDate.setText(items.get(position).getDate());
    }


    @Override
    public int getItemCount() {

        return items.size();
    }
}

```
