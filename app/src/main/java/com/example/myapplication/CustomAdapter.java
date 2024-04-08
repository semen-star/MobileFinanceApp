package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.example.myapplication.MoneyTransactionSerices.TransactionManager;
import com.example.myapplication.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    private final IncomeModel[] incomes;
    private TransactionManager transactionManager;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Button removeButton;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            removeButton = (Button) view.findViewById(R.id.removeIncome);
            textView = (TextView) view.findViewById(R.id.textView);
        }

        public Button getButton() {
            return removeButton;
        }
        public TextView getTextView() {
            return textView;
        }
    }
    public CustomAdapter(Context context) {
        transactionManager = new TransactionManager(context);
        incomes = transactionManager.GetAllIncomes().toArray(new IncomeModel[0]);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        IncomeModel incomeModel = incomes[position];
        viewHolder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                transactionManager.RemoveIncome(incomeModel);
            }
        });
        viewHolder.getTextView().setText(incomeModel.source + " : " + incomeModel.value);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return incomes.length;
    }
}

