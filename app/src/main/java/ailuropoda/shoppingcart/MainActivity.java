package ailuropoda.shoppingcart;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAddItem, btnDiscardItem;

    TextView cartItemCounter;
    ImageView cartImageBackground;
    int itemCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddItem = (Button) findViewById(R.id.btnAddItem);
        btnDiscardItem = (Button) findViewById(R.id.btnDiscardItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                itemCount++;
                updateCartItem(itemCount);
            }

        });

        btnDiscardItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                itemCount--;
                updateCartItem(itemCount);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.shoppingCart);
        MenuItemCompat.setActionView(item, R.layout.item_number_update);
        View view = MenuItemCompat.getActionView(item);

        cartImageBackground = (ImageView) view.findViewById(R.id.shoppingCartImage);
        cartItemCounter = (TextView) view.findViewById(R.id.cart_item_counter);
        cartItemCounter.setText(String.valueOf(itemCount));

        return super.onCreateOptionsMenu(menu);
    }

    private void updateCartItem(int count){
        itemCount = count;
        invalidateOptionsMenu();
    }

}
