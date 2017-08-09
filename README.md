PlaceHolderDemo
=================

Animated placeholder in desert style

Features:
=========
- Use it as Single screen when 'No Internet Connection'
- Just load this screen when 'Nothing to Show or No data'
- Animated and creative UI
- Easy to integrate.

![image](https://github.com/JetradarMobile/DesertPlaceholder/blob/master/art/desertplaceholder.gif)


Compatibility
-------------

This library is compatible from API 15 (Android 4.0).

Usage
-----

Add view to your layout

``` xml
  <com.jetradar.desertplaceholder.DesertPlaceholder
      android:id="@+id/placeholder"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      app:dp_buttonText="retry"
      app:dp_message="Use this nice placeholder if you have nothing to show"/>
```

Set up listener to button click

``` java
   DesertPlaceholder desertPlaceholder = (DesertPlaceholder) findViewById(R.id.placeholder);
    desertPlaceholder.setOnButtonClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // do stuff
      }
    });
```

Dependencies
------------
- AppCompat Support Library v7:26.0.0-alpha1
- Android Studio 2.3.3
- Butter Knife 7.0.1

