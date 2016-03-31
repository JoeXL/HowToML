package com.example.matthew.howtoml;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /* Initialise expandable list components */
    DrawerLayout mDrawerLayout;
    LanguagesListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedLanguagesListModel> listDataHeader;
    HashMap<ExpandedLanguagesListModel, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.logo);
        toolbar.setLogoDescription("HTML Logo");
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#ff6600"));

        /* Create Navigation Drawer */
        final ActionBar ab = getSupportActionBar();
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView)findViewById(R.id.navigationmenu);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);

        /* If the drawer exists add the content */
        if(navigationView != null) {
            setupDrawerContent(navigationView);
        }

        /* Add the content to the expandable list and set up the adapter */
        prepareListData();
        mMenuAdapter = new LanguagesListAdapter(this, listDataHeader, listDataChild, expandableList);
        expandableList.setAdapter(mMenuAdapter);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        /* Setup homepage fragment */
        /* Create new HomepageFragment and a FragmentTransaction */
        Fragment newHomepageFragment = new HomepageFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        /* Replace the fragment that is loaded in fragment_frame with the new fragment */
        transaction.replace(R.id.fragment_frame, newHomepageFragment);
        transaction.addToBackStack(null); //Think this can be used to navigate through previous pages when pressing the back button. If so I assume it will be accessed again in the onBackPressed() method.
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //If  the drawer is open, close it, if not minimize the app
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            /* One thing I've noticed is that if the back button is pressed to minimize the app, when it is loaded again
             * it will load the homepage fragment, however if it is minimized by pressing the home button on android, it
             * will still load the lesson fragment. Don't think it'll matter though as we'll probably want the backButton
             * to load the homepage if a lesson is already loaded, so this code will change anyway. */
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /* Expandable list data */
    public void prepareListData() {
        listDataHeader = new ArrayList<ExpandedLanguagesListModel>();
        listDataChild = new HashMap<ExpandedLanguagesListModel, List<String>>();

        /* Initialise parents in the expandable list */
        ExpandedLanguagesListModel item1 = new ExpandedLanguagesListModel();
        item1.setIconName("HTML");
        listDataHeader.add(item1);

        ExpandedLanguagesListModel item2 = new ExpandedLanguagesListModel();
        item2.setIconName("CSS");
        listDataHeader.add(item2);

        ExpandedLanguagesListModel item3 = new ExpandedLanguagesListModel();
        item3.setIconName("JavaScript");
        listDataHeader.add(item3);

        /* Create arrays to be stored within each parent in the expandable list */
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Lesson 1");
        heading1.add("Lesson 2");
        heading1.add("Lesson 3");
        heading1.add("Lesson 4");
        heading1.add("Lesson 5");
        heading1.add("Quiz 1");
        heading1.add("Lesson 6");
        heading1.add("Lesson 7");
        heading1.add("Lesson 8");
        heading1.add("Lesson 9");
        heading1.add("Lesson 10");
        heading1.add("Quiz 2");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("Lesson 1");
        heading2.add("Lesson 2");
        heading2.add("Lesson 3");
        heading2.add("Lesson 4");
        heading2.add("Lesson 5");
        heading2.add("Quiz 1");
        heading2.add("Lesson 6");
        heading2.add("Lesson 7");
        heading2.add("Lesson 8");
        heading2.add("Lesson 9");
        heading2.add("Lesson 10");
        heading2.add("Quiz 2");

        List<String> heading3 = new ArrayList<String>();
        heading3.add("Lesson 1");
        heading3.add("Lesson 2");
        heading3.add("Lesson 3");
        heading3.add("Lesson 4");
        heading3.add("Lesson 5");
        heading3.add("Quiz 1");
        heading3.add("Lesson 6");
        heading3.add("Lesson 7");
        heading3.add("Lesson 8");
        heading3.add("Lesson 9");
        heading3.add("Lesson 10");
        heading3.add("Quiz 2");

        /* Add the child lists to the parents */
        listDataChild.put(listDataHeader.get(0), heading1);
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* Navigation drawer data */
    public void setupDrawerContent(NavigationView navigationView) {
        expandableList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            /* Keep track of previous expanded parent */
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                /* Collapse previous parent if expanded */
                if ((previousGroup != -1) && (groupPosition != previousGroup)) {
                    expandableList.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
                /*  Change the header of the Navigation Drawer depending on what
                 *  parent option is selected. 0 = HTML, 1 = CSS, Other = JavaScript */
                if(groupPosition == 0) {
                    ImageButton logoBackground = (ImageButton) findViewById(R.id.HowToMLHeaderLink);
                    ImageButton languageBackground = (ImageButton) findViewById(R.id.htmlHeaderLink);
                    RelativeLayout navHeaderBackground = (RelativeLayout) findViewById(R.id.nav_header);
                    logoBackground.setBackground(getResources().getDrawable(R.drawable.header_green));
                    languageBackground.setBackground(getResources().getDrawable(R.drawable.button_html));
                    navHeaderBackground.setBackgroundColor(Color.parseColor("#0d9445"));
                }
                else if(groupPosition == 1) {
                    ImageButton logoBackground = (ImageButton) findViewById(R.id.HowToMLHeaderLink);
                    ImageButton languageBackground = (ImageButton) findViewById(R.id.htmlHeaderLink);
                    RelativeLayout navHeaderBackground = (RelativeLayout) findViewById(R.id.nav_header);
                    logoBackground.setBackground(getResources().getDrawable(R.drawable.header_blue));
                    languageBackground.setBackground(getResources().getDrawable(R.drawable.button_css));
                    navHeaderBackground.setBackgroundColor(Color.parseColor("#224098"));
                }
                else {
                    ImageButton logoBackground = (ImageButton) findViewById(R.id.HowToMLHeaderLink);
                    ImageButton languageBackground = (ImageButton) findViewById(R.id.htmlHeaderLink);
                    RelativeLayout navHeaderBackground = (RelativeLayout) findViewById(R.id.nav_header);
                    logoBackground.setBackground(getResources().getDrawable(R.drawable.header_red));
                    languageBackground.setBackground(getResources().getDrawable(R.drawable.button_jscript));
                    navHeaderBackground.setBackgroundColor(Color.parseColor("#c01d2e"));
                }
            }
        });

        /* Open a page depending on what child option is selected. Currently doesn't
         * distinguish between options and thus always opens the same page. */
        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
                parent.setItemChecked(index, true);

                /* Display a small toast message that display what what selected */
                Toast.makeText(MainActivity.this, "clicked " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).toString(), Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();

                /* Fragment code */
                /* Create new LessonFragment and a FragmentTransaction */
                Fragment newLessonFragment = new LessonFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                /* The next 3 lines are a direct copy/paste from a tutorial that should allow arguments to be passed that can be used in the onCreate method
                 * of the LessonFragment class. Not sure exactly how it needs to be implemented in our app which is why I've left it commented out,
                 * but it should be possible to use an id (or something) from list in the navigation drawer to load a certain lesson within the fragment.
                 * I've also left the code from the tutorial that the fragment uses in the LessonFragment class.*/
                //Bundle args = new Bundle();
                //args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
                //fragment.setArguments(args);

                /* Replace the fragment that is loaded in fragment_frame with the new fragment */
                transaction.replace(R.id.fragment_frame, newLessonFragment);
                transaction.addToBackStack(null); //Think this can be used to navigate through previous pages when pressing the back button. If so I assume it will be accessed again in the onBackPressed() method.
                transaction.commit();

                return true;
            }
        });
    }

}
