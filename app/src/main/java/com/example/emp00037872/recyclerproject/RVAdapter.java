package com.example.emp00037872.recyclerproject;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by EMP00037872 on 17.07.15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {
    public class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        Button copyButton;
        CopyButtonListener copyButtonListener;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personAge = (TextView) itemView.findViewById(R.id.person_age);
            copyButton = (Button) itemView.findViewById(R.id.recyclerViewItemCopyButton);
            copyButtonListener = new CopyButtonListener();
            copyButton.setOnClickListener(copyButtonListener);

        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.copyButtonListener.setRecord(persons.get(i));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    private void copy(Person record) {
        int position = persons.indexOf(record);
        Person copy = record.copy();
        persons.add(position + 1, copy);
        notifyItemInserted(position + 1);
    }
    private class CopyButtonListener implements View.OnClickListener {
        private Person record;

        @Override
        public void onClick(View v) {
            copy(record);
        }

        public void setRecord(Person record) {
            this.record = record;
        }
    }
}
