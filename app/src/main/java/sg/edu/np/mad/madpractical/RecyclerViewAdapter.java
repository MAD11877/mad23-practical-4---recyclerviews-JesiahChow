package sg.edu.np.mad.madpractical;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
   /* private int DEFAULT_VIEW_TYPE = 0;
    private int SPECIAL_VIEW_TYPE = 1;*/
    ArrayList<User> userList;
    Context context;

    public RecyclerViewAdapter(ArrayList<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the appropriate layout based on the view type
       /*int layoutResId = viewType == SPECIAL_VIEW_TYPE ? R.layout.recycler_view_special : R.layout.recycler_view;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new MyViewHolder(view);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Inflate the appropriate layout based on the view type
        if (viewType == SPECIAL_VIEW_TYPE) {
            View view = inflater.inflate(R.layout.recycler_view_special, parent, false);
            return new MyViewHolder(view, true);
        } else {
            View view = inflater.inflate(R.layout.recycler_view, parent, false);
            return new MyViewHolder(view, false);*/

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        /*User user = userList.get(position);
        holder.name.setText("Name" + user.getName());
        holder.desc.setText("Description" + user.getDescription());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("description", user.getDescription());
                context.startActivity(intent);
            }
        });*/
        holder.name.setText("Name" + userList.get(position).getName());
        holder.desc.setText("Description" + userList.get(position).getDescription());

        boolean isSpecialView = userList.get(position).getName().endsWith("7");

        /*if (holder.specialImageView != null && isSpecialView) {
            holder.specialImageView.setVisibility(View.VISIBLE);
        } else if (holder.specialImageView != null) {
            holder.specialImageView.setVisibility(View.GONE);
        }*/
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("name", userList.get(position).getName());
                intent.putExtra("description", userList.get(position).getDescription());
                context.startActivity(intent);
            }
        });

        // Show or hide the specialImageView based on the view type
        /*int viewType = getItemViewType(position);
        if (viewType == SPECIAL_VIEW_TYPE) {
            holder.specialImageView.setVisibility(View.VISIBLE);
            holder.specialImageView2.setVisibility(View.VISIBLE);
        } else {
            holder.specialImageView.setVisibility(View.GONE);
            holder.specialImageView2.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    /*@Override
    public int getItemViewType(int position) {
        String name = userList.get(position).getName();
        int lastDigit = Character.getNumericValue(name.charAt(name.length() - 1));

        // Check if the last digit is 7
        if (lastDigit == 7) {
            return SPECIAL_VIEW_TYPE;
        } else {
            return DEFAULT_VIEW_TYPE;
        }
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image5;
        ImageView image6;
        TextView name;
        TextView desc;
        ImageView specialImageView;
        ImageView specialImageView2;// Add specialImageView reference
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image5 = itemView.findViewById(R.id.imageView5);
            image6 = itemView.findViewById(R.id.imageView6);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            layout = itemView.findViewById(R.id.user_layout);

            // Initialize specialImageView as null
            specialImageView = null;
        }

        public MyViewHolder(@NonNull View itemView, boolean isSpecialView) {
            this(itemView);

            // Initialize specialImageView if it exists
            if (isSpecialView) {
                specialImageView = itemView.findViewById(R.id.specialImageView);
                specialImageView2 = itemView.findViewById(R.id.specialImageView2);
            }
        }
    }*/


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image5;
        ImageView image6;
        TextView name;
        TextView desc;
        ConstraintLayout layout;
        ImageView specialImageView;
        ImageView specialImageView2;// Special ImageView for the special layout

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image5 = itemView.findViewById(R.id.imageView5);
            image6 = itemView.findViewById(R.id.imageView6);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            layout = itemView.findViewById(R.id.user_layout);
            specialImageView = itemView.findViewById(R.id.specialImageView);
            specialImageView2 = itemView.findViewById(R.id.specialImageView2);

        }
    }
}

