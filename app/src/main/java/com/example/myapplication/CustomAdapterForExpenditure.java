package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MoneyTransactionSerices.Models.ExpenseModel;
import com.example.myapplication.MoneyTransactionSerices.Models.IncomeModel;
import com.example.myapplication.MoneyTransactionSerices.TransactionManager;

public class CustomAdapterForExpenditure extends RecyclerView.Adapter<CustomAdapterForExpenditure.ViewHolder> {
    /**
     * Provide a reference to the type of viewsyou are using
     * (custom ViewHolder)
     */
    private final ExpenseModel[] expenditure;
    private  TransactionManager transactionManager;
    public CustomAdapterForExpenditure(ExpenseModel[] expenditure) {
        this.expenditure = expenditure;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        private Button removeButton;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            removeButton = (Button) view.findViewById(R.id.removeIncome2);
            textView = (TextView) view.findViewById(R.id.textView2);
        }
        public Button getButton() {
            return removeButton;
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public CustomAdapterForExpenditure(Context context) {
        transactionManager = new TransactionManager(context);
        expenditure = transactionManager.GetAllExpenses().toArray(new ExpenseModel[0]);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item2, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        ExpenseModel expenseModel = expenditure[position];
        viewHolder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                transactionManager.RemoveExpense(expenseModel);
            }
        });
        viewHolder.getTextView().setText(expenseModel.purchaseName + " : " + expenseModel.value + "\nКатегория: " + expenseModel.categoryName);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return expenditure.length;
    }
}

