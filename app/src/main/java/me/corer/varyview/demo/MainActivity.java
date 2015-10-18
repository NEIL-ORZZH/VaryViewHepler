package me.corer.varyview.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import me.corer.varyview.VaryViewHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    VaryViewHelper mVaryViewHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.data).setOnClickListener(this);
        findViewById(R.id.empty).setOnClickListener(this);
        findViewById(R.id.error).setOnClickListener(this);
        findViewById(R.id.loading).setOnClickListener(this);

        mVaryViewHelper = new VaryViewHelper.Builder()
                .setDataView(findViewById(R.id.vary_content))
                .setLoadingView(LayoutInflater.from(this).inflate(R.layout.layout_loadingview,null))
                .setEmptyView(LayoutInflater.from(this).inflate(R.layout.layout_emptyview, null))
                .setErrorView(LayoutInflater.from(this).inflate(R.layout.layout_errorview,null))
                .setRefreshListener(new ErrorClickListener())
                .build() ;

    }

    public class ErrorClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mVaryViewHelper.showLoadingView();
        }
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.data:
               mVaryViewHelper.showDataView();
               break;
           case R.id.empty:
               mVaryViewHelper.showEmptyView();
               break;
           case R.id.error:
               mVaryViewHelper.showErrorView();
               break;
           case R.id.loading:
               mVaryViewHelper.showLoadingView();
               break;
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
