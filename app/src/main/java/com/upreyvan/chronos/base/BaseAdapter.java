package com.upreyvan.chronos.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public abstract class BaseAdapter<T, VB extends ViewBinding> extends ListAdapter<T, BaseAdapter.BaseViewHolder<VB>> {

    private OnItemClickListener<T> listener;

    // Kailangan natin ng DiffUtil parameter dito
    protected BaseAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    protected abstract VB createBinding(LayoutInflater inflater, ViewGroup parent, int viewType);
    protected abstract void bind(VB binding, T item, int position);

    @NonNull
    @Override
    public BaseViewHolder<VB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VB binding = createBinding(LayoutInflater.from(parent.getContext()), parent, viewType);
        return new BaseViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<VB> holder, int position) {
        T item = getItem(position); // Method ito ni ListAdapter
        bind(holder.binding, item, position);

        holder.itemView.setOnClickListener(v -> {
            int currentPos = holder.getBindingAdapterPosition(); // Mas safe ito sa clicks
            if (listener != null && currentPos != RecyclerView.NO_POSITION) {
                listener.onClick(getItem(currentPos), currentPos);
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.listener = listener;
    }

    public static class BaseViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {
        public final VB binding;
        public BaseViewHolder(@NonNull VB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnItemClickListener<T> {
        void onClick(T item, int position);
    }
}